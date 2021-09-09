package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		// 생성자는 부모 클래스 - 자식 클래스 순서로 호출이 된다!		
		// new Student();
		
		Student s1 = new Student();
	
		
		s1.setGrade(1);
		s1.setMajor("cs");
		s1.setName("둘리");
		// ((Person)s1).setName("둘리");

		// Up Casting은 자동으로 해줌. 굳이 안 써도 됨
		// UpCasting ('암시적', implicity)
		Person p1 = s1;
		p1.setName("둘리");
		
		// Down Casting('명시적', explicity)
		Student s2 = (Student)p1;
		s2.setMajor("cs");
		// ((Student)p1).setMajor("cs");
	}

}
