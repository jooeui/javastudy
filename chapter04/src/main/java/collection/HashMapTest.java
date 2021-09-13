package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();	// String: Key(불변) -> Goods...이 들어갈 수는 있음
		
		String ks1 = "one";
		m.put(ks1, 1);		// 1에서 Auto boxing ( new Integer(1) )
		// m.put("one", 1);
		m.put("two", 2);
		m.put("three", 3);
		
		int i = m.get("one");	// Auto unboxing
		int j = m.get(new String("one"));
		System.out.println(i + " : " + j);
		
		m.put("three", 33333);
		System.out.println(m.get("three"));		// 기존 three 키 값에 들어있던 3은 사라지고 33333이 들어가게 됨
		
		// 순회
		Set<String> s = m.keySet();
		for(String key : s) {
			System.out.println(key); 		// one, two, three	(key)
			System.out.println(m.get(key));	// 1, 2, 3	(value)
		}
	}

}
