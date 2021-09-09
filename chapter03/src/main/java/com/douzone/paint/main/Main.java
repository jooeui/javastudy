package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rectangle;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		// 생성자를 만들어줬기 떄문에 기본 생성자는 생성되지 않으므로 오류
		// Point point1 = new Point();
		// point1.setX(10);
		// point1.setY(10);

		Point point1 = new Point (10, 10);
		
		/* 점 그리기, 지우기 */
		// drawPoint(point1);
		draw(point1);
		// point1.disapear();
		point1.show(false);
		
//		ColorPoint colorPoint1 = new ColorPoint();
//		colorPoint1.setX(100);
//		colorPoint1.setY(200);
//		colorPoint1.setColor("red");
//		drawColorPoint(colorPoint1);

		/* 오버라이딩 실습 */
		/* 색 있는 점 그리기 */
		// Point point2 = new ColorPoint();
		// point2.setX(100);
		// point2.setY(200);
		
		Point point2 = new ColorPoint(100, 200, "red");
		
		// 업 캐스팅(Up Casting)은 명시 안 해줘도 되지만 다운 캐스팅(Down Casting)을 해줘야 자식 클래스에 있는 setColor를 사용할 수 있음!
		// point2.setColor("red");
		((ColorPoint)point2).setColor("red");	// 다운 캐스팅
		// drawPoint(point2);
		draw(point2);
		
		point2.show(false);
		// 부모 클래스의 show(true)를 사용할 경우 show()를 불러오는데 오버라이딩을 했기 때문에 결과적으로 자식클래스의 show()를 불러옴!
		point2.show(true);
		
		/* 삼각형 그리기 */
		Triangle triangle = new Triangle();
		// drawTriangle(triangle);
		// drawShape(triangle);
		draw(triangle);
		
		/* 사각형 그리기 */
		Rectangle rect = new Rectangle();
		// drawRectangle(rect);
		// drawShape(rect);
		draw(rect);
		
		/* 원 그리기 */
		Circle circle = new Circle();
		// drawCircle(circle);
		// drawShape(circle);
		draw(circle);
		
		/* 텍스트 그리기 */
		GraphicText text = new GraphicText("Hello World");
		draw(text);
		
		
		/* instanceof test */
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류: class는 hierarchy 상위와 하위만 instanceof 연산자 사용할 수 있다!
		// System.out.println(circle instanceof Rectangle);
		
		// interface는 hierarchy와 상관없이 instanceof 연산자 사용할 수 있다!
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);	
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
	/*
	public static void drawPoint(Point point) {
		point.show();
	}
	
	public static void drawColorPoint(ColorPoint colorPoint) {
		colorPoint.show();
	}
	
	public static void drawShape(Shape shape) {
		// Triangle, Rectangle ...에 실제 구현된 draw()를 불러오게 됨
		shape.draw();
	}
	
	public static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}

	public static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	}
	
	public static void drawCircle(Circle circle) {
		circle.draw();
	}
	*/

}
