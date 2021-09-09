package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(400000);
		goods.setCountStock(30);
		goods.setCountSold(50);
		
		goods.setPrice(-1);
		
		goods.showInfo();
		int discountPrice = goods.calcDiscountPrice(50);
		
		
		System.out.println(discountPrice);
		
		System.out.println(Goods.countOfGoods);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
	}

}
