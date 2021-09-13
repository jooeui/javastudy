package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectiorTest01 {

	public static void main(String[] args) {
		/* java 1.0 */
		Vector<String> v1 = new Vector<>();		// new Vector();  <> 생략 가능 
		Vector<Integer> v2 = new Vector<>();
		
		v1.addElement("둘리");
		v1.addElement("마이콜");
		v1.addElement("도우너");
		v2.addElement(10);		// Auto Boxing
		
		// 순회1
		for(int i =0; i < v1.size(); i++) {
			String s = v1.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		v1.removeElementAt(2);
		
		// 순회2
		Enumeration<String> e = v1.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
		
	}

}
