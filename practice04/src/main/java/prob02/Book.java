package prob02;

public class Book {
	private int bookNo;		// 번호
	private String title;	// 제목
	private String author;	// 작가
	private int stateCode;	// 상태코드(대여유무)
	
	public void Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}
	
	
}
