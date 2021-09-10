package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		/* escape 문자 */
		
		// c:\temp 출력
		System.out.println("c:\\temp");
		
		// "hello" 출력
		System.out.println("\"hello\"");
		
		/*
		 * \t : tab
		 * \r : carrige return
		 * \n : newline
		 * \b : beep
		 */
		
		System.out.println("hello\tworld\n");
		System.out.println("hello\tworld");
		
		// '
		char c = '\'';
		System.out.println(c);
	}

}
