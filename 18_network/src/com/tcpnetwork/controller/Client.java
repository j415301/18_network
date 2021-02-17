package com.tcpnetwork.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws Exception{
		//1. 접속할 서버의 ip주소, port주소 설정
		String ip = "172.30.1.60";
		//String ip2 = InetAddress.getLocalHost().getHostAddress();//내 ip 주소 가져오기
		
		int port = 8765;
		
		//2. socket 생성
		Socket server = new Socket(ip, port);
		
		if(server!=null) {//=서버와 연결이 되면
			//서버와 통신을 위한 스트림 열기
			InputStream input = server.getInputStream();
			OutputStream out = server.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(out);
			
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("서버에 전송할 메세지 : ");
				String msg = sc.nextLine();
				pw.println(msg);
				pw.flush();
				
				if(msg.equals("exit")) {
					break;
				}
				
				String response = br.readLine();
				System.out.println(response);
			} while (true);
			
			br.close();
			pw.close();
			sc.close();
			server.close();
		}
	}

}
