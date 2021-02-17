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
		
		//���� �����ϱ�
		//1. port ���ϱ�: int�� ���ڷ� ���ϸ� ��
		int port = 8765;
		
		//2. ServerSocket��ü ����
		ServerSocket server = new ServerSocket(port);
		
		while(true) {
			//Ŭ���̾�Ʈ�� ��û�� ��ٸ�
			Socket client = server.accept();//Ŭ���̾�Ʈ�� ���� Ŭ���̾�Ʈ ���Ͽ� ���� ���� ����
			//������ �Ǹ� ��û�� client�� ������ �����
			
			//Stream ����
			InputStream input = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			//���� ��Ʈ�� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(out);
			
			while (true) {
				String message = br.readLine();
				if(!message.equals("exit")) {
					System.out.println(client.getInetAddress()+" : "+message);
					//Ŭ���̾�Ʈ�� ���� �޽��� ���
					pw.println("���� �Ϸ�");//Ŭ���̾�Ʈ ���� �޽���
					pw.flush();
				} else {
					System.out.println("������ �����մϴ�.");
					break;
				}
			}
			br.close();
			pw.close();
			client.close();
		}

	}

}
