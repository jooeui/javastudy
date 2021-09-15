package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		// Thread thread3 = new UpperCaseAlphabetRunnableImpl();			// 스레드가 아니기 때문에 바로 쓰지 못함
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnableImpl());	// 스레드를 상속받지 못할 때 사용
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
