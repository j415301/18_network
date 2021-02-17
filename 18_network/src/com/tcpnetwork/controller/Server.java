package com.tcpnetwork.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//서버 세팅하기
		//1. port 정하기: int형 숫자로 정하면 됨
		int port = 8765;
		
		//2. ServerSocket객체 생성
		ServerSocket server = new ServerSocket(port);
		
		while(true) {
			//클라이언트의 요청을 기다림
			Socket client = server.accept();//클라이언트가 보낸 클라이언트 소켓에 대한 정보 저장
			//진행이 되면 요청한 client와 서버가 연결됨
			
			//Stream 열기
			InputStream input = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			//보조 스트림 연결
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(out);
			
			while (true) {
				String message = br.readLine();
				if(!message.equals("exit")) {
					System.out.println(client.getInetAddress()+" : "+message);
					//클라이언트가 보낸 메시지 출력
					pw.println("전송 완료");//클라이언트 전송 메시지
					pw.flush();
				} else {
					System.out.println("접속을 종료합니다.");
					break;
				}
			}
			br.close();
			pw.close();
			client.close();
		}

	}

}
