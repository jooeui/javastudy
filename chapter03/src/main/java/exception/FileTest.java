package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			// checked exception. try catch를 쓰지 않으면 error
			fis = new FileInputStream("hello.txt");
			int data = fis.read();		// 저장될 때는 숫자로 저장됨
			System.out.println((char)data);
		} catch (FileNotFoundException e) {		// IOException만 써도 되지만 써주는게 좋음..
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(fis != null) {
					fis.close();	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
	}

}
