package com.networkTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException{
		// TODO Auto-generated method stub
		
		//InetAddress Ŭ������ ��Ʈ��ũ �󿡼� ��Ǵ� IP�� ������ ��ų�
		//���� ��ǻ���� ������ ������ �� ����
		
		InetAddress localIP = InetAddress.getLocalHost();
		//���� ��ǻ���� ��Ʈ��ũ ������ ������
		
		//��ǻ�� ip �ּ� Ȯ���ϱ�
		System.out.println(localIP.getHostAddress());
		
		//��ǻ�� �̸�
		System.out.println(localIP.getHostName());
		
		
		//��ǰ� �ִ� ������ ������ ������ �� ����
		//������ �����ϴ� ������ ���ؼ�...
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver.getHostAddress());
		System.out.println(naver.getHostName());
		
		
		InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
		System.out.println(navers.length);
		for(InetAddress ip : navers) {
			System.out.println(ip.getHostAddress());
		}
	}

}
