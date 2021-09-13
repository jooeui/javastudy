package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);
		
		System.out.println(s.size());
		System.out.println(s.contains("둘리")); 		// 안에 둘리가 있는지 없는지 true/false 반환
		System.out.println(s.contains(s2));			// '값'이 있는지 확인하므로 s1(도우너)와 값이 같은 s2는 true 반환
		
		// key, index가 없으므로 순회
		// 순회1
		for(String str : s) {
			System.out.println(str);
		}
		
		
		
	}
}
