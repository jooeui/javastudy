package com.douzone.paint.point;

import com.douzone.paint.i.Drawable;

public class Point implements Drawable {
	private int x;
	private int y;
	
	// ColorPoint의 생성자에서 파라미터가 없는 생성자를 불러오기 때문에 기본 생성자를 오버로딩 해준다! 
	public Point() {
		
	}
	// 생성자를 명시했기 때문에 기본 생성자는 자동 생성되지 않음!
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void show() {
		System.out.println("점[x=" + x + ", y=" + y + "]을 그렸습니다.");
	}
	
	public void show(boolean visible) {
		if(visible) {
			// 반복 코드 x
			// System.out.println("점[x=" + x + ", y=" + y + "]을 그렸습니다.");
			show();
		} else {
			System.out.println("점[x=" + x + ", y=" + y + "]을 지웠습니다.");
		}
	}
	
	@Override
	public void draw() {
		show();
	}
	
//	public void disapear() {
//		System.out.println("점[x=" + x + ", y=" + y + "]을 지웠습니다.");
//	}
	
}
