package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();		// 배열보단 탐색이 느릴 수 있음. 메모리 사용량은 줄어든다!

		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");

		// 순회1
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}

		// 삭제
		list.remove(2);

		// 순회2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

		// 순회3
		for (String s : list) {
			System.out.println(s);
		}
	}

}
