package com.douzone.paint.text;

import com.douzone.paint.i.Drawable;

public class GraphicText implements Drawable {
	private String text;
	
	// setting 방법은 setter나 생성자를 사용한다!
	public GraphicText(String text) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		System.out.println(text + "를 그렸습니다.");
	}

}
