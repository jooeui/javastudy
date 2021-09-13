package chapter04;

import java.util.Date;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// Date d = new Date();
		// int i = d.getHours();	
		
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		// Auto Boxing
		// 내부적으로 new Integer로 생성. 다른 객체x, 'literal pool' 작동
		Integer j1  = 10;
		Integer j2  = 10;
		
		// 동질성, 동일성
		System.out.println(j1 == j2); 		// true
		System.out.println(j1.equals(j2));	// true
		
		
		// Auto Unboxing
		// int m = j1.intValue() + 10;
		int m = j1 + 10;		// 객체에다 10을 더한다 -> 이상해!
								// but, j1.intValue()를 사용하여 객체에서 값을 꺼내지 않아도 Auto Unboxing 때문에 사용 가능
		
	}

}
