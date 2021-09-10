package chapter04;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {		// 디버깅할 때 많이 씀
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	// equals와 hashCode는 항상 같이 Override 해주어야함
	// 오작동, 성능 문제
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
	
	
}
