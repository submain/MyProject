package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiServer {
	public static ArrayList<Socket> list = new ArrayList<Socket>();
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(5000);
		while(true) {
			Socket socket = serverSocket.accept();
			list.add(socket);
			ServerBO_Thread st=new ServerBO_Thread(socket,list);
		}
	}
	
	 public void encryptWrite(String src,DataOutputStream output)throws IOException{
	        //将一个字符串转化为字符数组
	        //System.out.println(src);
	        char[] char_arr = src.toCharArray();
	        //加密操作
	        for(int i = 0;i<char_arr.length;i++){
	            output.writeChar(char_arr[i]+13);
	        }
	        //用作结束标志符
	        output.writeChar(2333);
	        output.flush();
	    }
	    //读取并解密
	    public String readDecrypt(DataInputStream input)throws IOException{
	        String rtn="";
	        while(true){
	            int char_src =input.readChar();
	            if(char_src!=2333){
	                rtn=rtn+(char)(char_src-13);
	            }else{
	                break;
	            }
	        }
	        return rtn;
	    }
	}
	class ServerBO_Thread extends Thread{
	    Socket client = null;
	    ArrayList<Socket> clients;
	    ServerBO_Thread(Socket s,ArrayList<Socket> ss){//初始化
	        client=s;
	        clients=ss; 
	    }
	    public void run(){
	        DataInputStream input = null;
	        DataOutputStream output =null;
	        try{
	            input = new DataInputStream(client.getInputStream());
	            MultiServer bo = new MultiServer();
	            String receive=null;
	            String send=null;
	            while(true){//监视当前客户端有没有发来消息
	                if(!client.isClosed()){
	                    receive=bo.readDecrypt(input);
	                    clients.trimToSize();
	                    String[] param = receive.split("&");
	                    if(")start".equals(param[1])){    //分析客户端发来的内容
	                        send = param[0]+"进入聊天室";
	                    }else{
	                        send = param[0]+"说:    "+param[1];
	                    }
	                    if(!("3333".equals(param[1]))){//3333为退出聊天室信号
	                        for(Socket socket:clients){ //遍历socke集合 
	                            //把读取到的消息发送给各个客户端  
	                            if(!socket.isClosed()){
	                                output = new DataOutputStream(socket.getOutputStream());
	                                bo.encryptWrite(send,output);
	                            }
	                        }  
	                    }else{//如果有客户端退出
	                        for(Socket socket:clients){ //遍历socke集合 
	                                if(socket!=client){//告诉其他人此人退出聊天室
	                                    if(!(socket.isClosed())){
	                                        output = new DataOutputStream(socket.getOutputStream());
	                                        bo.encryptWrite(param[0]+"已退出聊天室",output);
	                                    }
	                                }
	                            }
	                        output = new DataOutputStream(client.getOutputStream());
	                        bo.encryptWrite("3333",output);//返回信号给要退出的客户端，然后关闭线程
	                        client.close();
	                        input.close();
	                        output.close();
	                    }
	                }else{
	                    break;
	                }
	            }
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	    }
	}

