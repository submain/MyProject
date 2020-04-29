package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	final static int part=10003; 
	static String readLine;
	static String inTemp;
	public static void  main(String [] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(part);
			Socket socket = serverSocket.accept();
			BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter socketOut = new PrintWriter(socket.getOutputStream());	
			socketOut.println("ª∂”≠ƒ˙¡¨Ω”Œ“~~");
			socketOut.flush();
			while(readLine != "bye") {
			inTemp = socketIn.readLine();
			System.out.println("client:"+"\n"+inTemp);
			System.out.println("server");
			readLine = systemIn.readLine();
			socketOut.println(readLine);
			socketOut.flush();
			}
			systemIn.close();
	        socketIn.close();
	        socketOut.close();
	        socket.close();
	        serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
