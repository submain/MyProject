package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {
	//�����ip
    public  String ip = "127.0.0.1";
    //����˶˿�
    public  int port = 5000;
    public  DataOutputStream output = null;
    public  Socket socket = null;
    public  DataInputStream input = null;
    public  Scanner sc =new Scanner (System.in);
    public  String send ;
    public  String receive;
    public  String name;
    public String sd = null;
    public static void main(String[]aa){
    	MultiClient po = new MultiClient();
        po.start();
    }
    public void start(){
        try{
            System.out.println("*******��ӭʹ�����������ң�**********");
            System.out.println("�������㽫Ҫʹ�õ��ǳƣ�");
            name=sc.nextLine();//��ȡ�ǳ�
            socket = new Socket(ip,port);
            output=new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            send = name+"&)start";//���ǳƷ��͵�server �������������³�Ա����������
            System.out.println("(���Ҫ�˳������������롰3333����)");
            System.out.println("*******�ɹ��������������ң�**********");
            System.out.println("");
            encryptWrite(send,output);
            Out out=new Out(output,name,input,socket);
            out.start();//���������������ݵĶ��߳�
            while(true){    
                String receive = readDecrypt(input);
                if("3333".equals(receive)){//����յ���3333�����˳�������
                    System.out.println("*******�ɹ��˳����������ң�**********");
                    input.close();
                    output.close();
                    socket.close();
                    System.exit(0);
                }
                System.out.println(receive);
            }
        }catch(Exception ex){
                ex.printStackTrace();
        }finally{
            try{
                if(socket!=null) socket.close();
                input.close();
                output.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }    
    }
    public void encryptWrite(String src,DataOutputStream output)throws IOException{
        //��һ���ַ���ת��Ϊ�ַ�����
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
class Out extends Thread {
    public DataOutputStream output;
    public DataInputStream input;
    public static String name;
    public Socket socket;
    public  Scanner sc =new Scanner (System.in);
    Out(DataOutputStream ot,String n,DataInputStream it,Socket socket){
        output=ot;
        input=it;
        name=n;
    }
    public void run(){
    	MultiClient po = new MultiClient();
        try{
            while(true){
                String send=sc.nextLine();//��ȡ�û�����
                String send2=name+"&"+send;//���������ݴ����Լ����ʽ
                po.encryptWrite(send2,output);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("sfef");
        }
    }
}
