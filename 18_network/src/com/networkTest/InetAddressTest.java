package com.networkTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException{
		// TODO Auto-generated method stub
		
		//InetAddress 클래스는 네트워크 상에서 운영되는 IP의 정보를 얻거나
		//서버 컴퓨터의 정보를 가져올 수 있음
		
		InetAddress localIP = InetAddress.getLocalHost();
		//현재 컴퓨터의 네트워크 정보를 가져옴
		
		//컴퓨터 ip 주소 확인하기
		System.out.println(localIP.getHostAddress());
		
		//컴퓨터 이름
		System.out.println(localIP.getHostName());
		
		
		//운영되고 있는 서버의 정보를 가져올 수 있음
		//서버가 제공하는 정보에 한해서...
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
