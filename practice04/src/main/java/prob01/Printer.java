package prob01;

public class Printer {
//	public void println(int integer) {
//		System.out.println(integer);
//	}
//
//	public void println(boolean bool) {
//		System.out.println(bool);
//	}
//
//	public void println(double d) {
//		System.out.println(d);
//	}
//
//	public void println(String s) {
//		System.out.println(s);
//	}

	// Generic을 사용하면 다른 타입 오버로딩 안 해도 됨
	public <T> void println(T t) {
		System.out.println(t);
	}

//	public <T, R> void println(T t, R r) {
//
//	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);	
		}
	}
	
	// 매개변수 순서, 개수를 모를 때 사용
	public int sum(Integer... nums) {
		int sum = 0;
		for(Integer i : nums) {
			sum += i;
		}
		
		return sum;
	}
}
