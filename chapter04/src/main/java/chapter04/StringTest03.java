package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1 = "Hello " + "World" + " Java " + 1.8;
		String s1 = new StringBuffer("Hello ")
						.append("World")
						.append(" Java ")
						.append(1.8)
						.toString();
		
		System.out.println(s1);
		
		String s2 = "";
		
		// 메모리 할당량이 많아져서 CPU 사용량 증가
		// + 연산자가 많이 일어날 때에는 append
		for(int i = 0; i < 1000000; i++) {
			// s2 = s2 + i;
			// s2 = new StringBuffer(s2).append(i).toString();
		}
		
		StringBuffer sb2 = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			sb2.append(i);
		}
		String s3 = sb2.toString();
		System.out.println(s3.length());
		
		// String method들!
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));		// -1, 없다!
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));		// 마지막 인덱스(5)는 포함x. 3, 4만 출력
		
		String s5 = "    ab    cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("----" + s5.trim() + "----"); 		// 앞뒤 공백 제거
		System.out.println("----" + s5.replaceAll(" ", "") + "----");	// 모든 공백 제거
		
		String[] tokens = s6.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		// split을 하지 못하면 처음에 원본을 출력함
		String[] tokens2 = s6.split(" ");
		for(String s : tokens2) {
			System.out.println(s);
		}
		
	}
	
}
