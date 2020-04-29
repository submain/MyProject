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
	        //��һ���ַ���ת��Ϊ�ַ�����
	        //System.out.println(src);
	        char[] char_arr = src.toCharArray();
	        //���ܲ���
	        for(int i = 0;i<char_arr.length;i++){
	            output.writeChar(char_arr[i]+13);
	        }
	        //����������־��
	        output.writeChar(2333);
	        output.flush();
	    }
	    //��ȡ������
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
	    ServerBO_Thread(Socket s,ArrayList<Socket> ss){//��ʼ��
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
	            while(true){//���ӵ�ǰ�ͻ�����û�з�����Ϣ
	                if(!client.isClosed()){
	                    receive=bo.readDecrypt(input);
	                    clients.trimToSize();
	                    String[] param = receive.split("&");
	                    if(")start".equals(param[1])){    //�����ͻ��˷���������
	                        send = param[0]+"����������";
	                    }else{
	                        send = param[0]+"˵:    "+param[1];
	                    }
	                    if(!("3333".equals(param[1]))){//3333Ϊ�˳��������ź�
	                        for(Socket socket:clients){ //����socke���� 
	                            //�Ѷ�ȡ������Ϣ���͸������ͻ���  
	                            if(!socket.isClosed()){
	                                output = new DataOutputStream(socket.getOutputStream());
	                                bo.encryptWrite(send,output);
	                            }
	                        }  
	                    }else{//����пͻ����˳�
	                        for(Socket socket:clients){ //����socke���� 
	                                if(socket!=client){//���������˴����˳�������
	                                    if(!(socket.isClosed())){
	                                        output = new DataOutputStream(socket.getOutputStream());
	                                        bo.encryptWrite(param[0]+"���˳�������",output);
	                                    }
	                                }
	                            }
	                        output = new DataOutputStream(client.getOutputStream());
	                        bo.encryptWrite("3333",output);//�����źŸ�Ҫ�˳��Ŀͻ��ˣ�Ȼ��ر��߳�
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

