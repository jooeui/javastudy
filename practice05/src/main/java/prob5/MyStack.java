package prob5;

public class MyStack {
	private int top;
	private int stackSize;
	private String[] stackArr; 
	
	public MyStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		stackArr = new String[stackSize];
	}

	public void push(String str) {
		if(top < this.stackSize) {
			stackArr[++top] = str;
		} else {
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public String pop() {
		return stackArr[top--];
	}
}