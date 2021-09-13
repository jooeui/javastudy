package collection;

import java.util.Objects;

public class Gugudan {
	private int left;
	private int right;
	
	public Gugudan(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Gugudan [left=" + left + ", right=" + right + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(left * right);	// Hash를 left * right로 하여 결괏값을 비교	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		return left * right == other.left * other.right;	// equeals 또한 left * right를 비교하여 출력
	}
	
}
