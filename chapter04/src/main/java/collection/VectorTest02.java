package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		/* java 1.2 - 이렇게 씁시당 */
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		// 순회1
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		// 삭제
		list.remove(2);		// list.remove("도우너");
		
		// 순회2 - 정석 ...
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		/* hasNext()는 한 번 쓰면 끝!!!!!! 주의하기!!!!! */
//		while(it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
		
		// 순회3 - for each문을 많이 쓰깅 ....
		for(String s : list) {
			System.out.println(s);
		}
	}

}
