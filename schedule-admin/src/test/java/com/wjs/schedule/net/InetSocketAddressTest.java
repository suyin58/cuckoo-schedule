package com.wjs.schedule.net;

import java.net.InetSocketAddress;
import java.util.Random;

public class InetSocketAddressTest {
	public static void main(String[] args) {
		InetSocketAddress addr = new InetSocketAddress("127.0.0.3", 2123);
		System.out.println(addr.getPort());
		System.out.println(addr.getAddress().getHostAddress());
		System.out.println(addr.getAddress());
		System.out.println(addr.getHostString());
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(new Random().nextInt(2));
		}
	}
}
