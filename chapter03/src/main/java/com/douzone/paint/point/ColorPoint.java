package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;
	
//	public ColorPoint() {
//		// super();			// 파라미터가 없는 super()가 자동으로 들어가는데 해당 생성자는 없기 때문에 error
//		// super(10, 20);	// error는 해결되지만 값을 모르기 떄문에 이렇게 쓰지는 않음
//	}
	
	public ColorPoint(int x, int y, String color) {
		// super(); 	// 자동으로 들어가있음 
		// 부모 클래스에서 x와 y는 private이므로 setter를 사용하여 값 설정
		// setX(x);	
		// setY(y);
		super(x, y); 	// super 안에 x, y를 넣어서 값 설정도 가능(부모 클래스에서 일치하는 생성자를 만들어 줬음)
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// Annotation(태그랑 똑같다고 보면 됨. 컴파일 시점에만 살아있고 런타임에서는 x, 오버라이드가 맞는지 컴파일러가 검사만 함)
	@Override	
	public void show() {
		// 부모 것을 쓰긴 쓸 것이다 하면 super 써줍시당
		// super.show();	
		
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color=" + color + "]을 그렸습니다.");
	}
}
