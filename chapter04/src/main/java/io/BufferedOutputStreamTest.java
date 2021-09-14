package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림(주 스트림)
			FileOutputStream fos = new FileOutputStream("test.txt");
			
			// 보조 스트림
			// new BufferedOutputStream(new FileOutputStream("test.txt"));
			bos = new BufferedOutputStream(fos);
			
			// for(int i = 97; i <= 122; i++)
			for(int i = 'a'; i < 'z'; i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't Open: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if(bos != null) {
					// flush를 사용할 때
					// 1. close() 사용
					// 2. buffer가 가득 찼을 때
					// 3. 명시적으로 flush를 사용
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
