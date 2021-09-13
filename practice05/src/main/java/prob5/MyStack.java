package prob5;

public class MyStack {
	private int top;
	private int stackSize;
	private String[] stackArr; 
	private String[] tempStackArr; 
	
	public MyStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		stackArr = new String[stackSize];
	}

	public void push(String str) {
		if(top < this.stackSize-1) {
			stackArr[++top] = str;
		} else {
			tempStackArr = new String[stackSize];
			for(int i = 0; i < stackArr.length; i++) {
				tempStackArr[i] = stackArr[i];
			}
			
			stackArr = new String[++stackSize];
			
			for(int i = 0; i < tempStackArr.length; i++) {
				stackArr[i] = tempStackArr[i];
			}
			stackArr[++top] = str;
		}
	}

	public boolean isEmpty() {
		return (top == -1) ? true : false;
	}

	public String pop() {
		try { 
			return stackArr[top--];
		} catch(MyStackException ex) { 
			throw ex;
		}
	}
}