package chapter03;

public class SongTest {

	public static void main(String[] args) {
//		Song song = new Song();
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setYear(2010);
//		song.setTrack(3);
		
		/* 생성자 생성과 동시에 값 설정을 할 수 있으므로 더욱 간결해졌음 */
		Song song1 = new Song("좋은날", "아이유", "이민수", "Real", 2010, 3);
		song1.show();
		
		Song song2 = new Song("신호등", "이무진");
		song2.show();
	}
	

}
