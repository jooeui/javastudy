package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			File file = new File("phone.txt");
			
			// File 객체를 사용하면 file이 존재하는지 여부를 if로 판단할 수 있음
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("============ 파일정보 ============");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(file.lastModified());
			System.out.println();
			
			System.out.println("============ 전화번호 ============");
			// 1. 기반 스트림 설정(표준 입력, stdin, System.in)
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조 스트림1(byte|byte|byte -> char) - UTF-8일 때 가능
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");

			// 3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4"(String))
			// br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) { 	// 해당 토큰이 있는가 없는가
					String token = st.nextToken();
					if(index == 0) {	// 이름
						System.out.print(token + ":");
					} else if(index == 1) {		// 전화번호1
						System.out.print(token + "-");
					} else if(index == 2) {		// 전화번호2
						System.out.print(token + "-");
					} else if(index == 3) {		// 전화번호3
						System.out.println(token);
					}
					index++;
				}
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
