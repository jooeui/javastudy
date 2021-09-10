package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		// Class cl = p.getClass();
		System.out.println(p.getClass());	// reflection
		System.out.println(p.hashCode());	// address 기반의 해싱값(10진수)
											// address x, reference x
		System.out.println(p.toString());	// getClass() + "@" + hashCode()(16진수)
		System.out.println(p);				// toString을 생략해도 어떤 객체를 print로 호출하면 자동으로 toString을 호출
	}

}
