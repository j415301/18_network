package com.udpNetwork.controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		int port = 8880;
		DatagramSocket socket = new DatagramSocket(port);
		String msg = "�� �ʵ� �޾�";
		
		DatagramPacket packet = new DatagramPacket(msg.getBytes(),
				msg.getBytes().length, InetAddress.getLocalHost(), 9990);
		socket.send(packet);
		
		
		//������ �ޱ�
		byte[] buf = new byte[256];
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		System.out.println(new String(buf));
		socket.close();
	}

}
