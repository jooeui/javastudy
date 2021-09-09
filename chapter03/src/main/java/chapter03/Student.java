package chapter03;

public class Student extends Person {
	private int grade;
	private String major;

	public Student() {
		// 자식의 모든 생성자에서 부모의 특정 생성자를 명시(explicity)하지 않으면
		// 암시적(implicity)으로 자식 생성자 코드 앞에 부모의 기본 생성자가 호출
		// super();
		System.out.println("Student() called");
		// super(); 	// 뒤에서 호출하면 오류. 부모 생성자를 먼저 부르기 때문!
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
