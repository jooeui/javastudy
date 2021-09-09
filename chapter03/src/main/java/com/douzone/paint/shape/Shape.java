package com.douzone.paint.shape;

import com.douzone.paint.i.Drawable;

// abstract를 가지고 있는 클래스는 abstract를 써줘야 함!
// 인터페이스 상속 받을 때 implements
public abstract class Shape implements Drawable {
	private String lineColor;
	private String fillColor;
	
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	
}
