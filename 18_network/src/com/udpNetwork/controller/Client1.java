package com.udpNetwork.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client1 {
	
	public static void main(String[] args) {
		
		//���� ��Ʈ, ip
		String ip = "172.30.1.60";
		int port = 9990;
		DatagramSocket socket = null;
		
		try {
			//������ ������
			socket = new DatagramSocket(port);
			
			String msg = "�ȳ� ������ �� �޾�!";
			DatagramPacket packet = new DatagramPacket(msg.getBytes(),
					msg.getBytes().length, InetAddress.getLocalHost(), 8880);
			socket.send(packet);
			
			//������ ������ �ޱ�
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			System.out.println(new String(buf));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket!=null) socket.close();
		}
	}

}
