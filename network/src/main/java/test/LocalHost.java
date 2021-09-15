package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 프로그램이 돌고있는 컴퓨터(작업 공간)
public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				// System.out.println(address);
				
				// 형변환을 시켜도 보호비트는 그대로
				// System.out.println((int)address);		
				
				// & 연산으로 맨 앞의 보호비트를 0으로 만들어줌
				// 마지막 비트는 제대로 나와야하므로 ff(11111111)를 and
				System.out.print(address & 0x000000ff);	
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
