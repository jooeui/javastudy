package chapter04;

public class MyClassTest {
	public static void main(String[] args) {
		/* Singleton 실습 */ 
		// MyClass myClass0 = new MyClass();	// 생성자가 private이기 때문에 생성 x
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
	}
}
