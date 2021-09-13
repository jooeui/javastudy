package chapter04;

public class MyClass {
	private static MyClass instance = null;
	
	private MyClass() {
	}
	
	// Singleton + Factory Method
	public static MyClass getInstance() {
		// return new MyClass();	// Factory Method는 되지만 Singleton x
		
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}
