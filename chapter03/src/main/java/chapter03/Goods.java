package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	// 생성자 - 안 만들 경우 java가 개입하여 자동으로 넣어줌
	// private로 하면 생성 불가 - private를 사용하는 경우는 팩토리패턴, 싱글톤패턴을 만들기 위해서
	public Goods() {
		// 클래스와 이름이 같기 때문에 Goods 생략 가능
		// Goods.countOfGoods = Goods.countOfGoods + 1;
		countOfGoods = countOfGoods + 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public void showInfo() {
		System.out.println(
				"name: " + name + 
				", price: " + price + 
				", countStock: " + countStock + 
				", countSold: " + countSold);
	}
	public int calcDiscountPrice(int percentage) {
		return price * percentage / 100;
	}
	
}
