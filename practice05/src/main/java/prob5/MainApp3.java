package prob5;

public class MainApp3 {

	public static void main(String[] args) {
		try {
			MyStack03<String> stack = new MyStack03<>(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			// stack.push(1); // 제너릭 타입으로 결정되었기 떄문에 정수 x
			stack.push("1");
			stack.push(".");

			while (stack.isEmpty() == false) {
				Object s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new MyStack03(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (MyStackException ex) {
			System.out.println(ex);
		}

	}

}
