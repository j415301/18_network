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
		//1. ������ ������ ip�ּ�, port�ּ� ����
		String ip = "172.30.1.60";
		//String ip2 = InetAddress.getLocalHost().getHostAddress();//�� ip �ּ� ��������
		
		int port = 8765;
		
		//2. socket ����
		Socket server = new Socket(ip, port);
		
		if(server!=null) {//=������ ������ �Ǹ�
			//������ ����� ���� ��Ʈ�� ����
			InputStream input = server.getInputStream();
			OutputStream out = server.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(out);
			
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("������ ������ �޼��� : ");
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
