package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(400000);
		goods.setCountStock(30);
		goods.setCountSold(50);
		
		System.out.println(goods.toString());
	}

}
