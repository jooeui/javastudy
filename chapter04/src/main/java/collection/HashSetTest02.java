package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {

	public static void main(String[] args) {
		/* final test01 - HashSet 사용하여 풀이 */
		/* 과제는 배열을 사용하여 풀어봅시당 */
		Set<Gugudan> s = new HashSet<>();
		
		s.add(new Gugudan(2, 3));
		s.add(new Gugudan(9, 9));
		s.add(new Gugudan(3, 2));	// 2*3, 3*2는 결과가 같기 때문에 얘는 못들어가게 해야 함
									//	-> set에 '결괏값'을 넣어서 같으면 안 들어가게 선택지에 중복이 없도록 만들기!
		
		for(Gugudan d : s) {
			System.out.println(d);
		}
		
	}

}
