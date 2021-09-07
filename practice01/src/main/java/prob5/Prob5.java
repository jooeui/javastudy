package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i = 1; i <= 99; i++) {
			if(i/10 == 3 || i/10 == 6 || i/10 == 9) {
				if(i % 3 == 0 && !(i%10 == 0)) {
					System.out.println(i + " 짝짝");
				}
				else {
					System.out.println(i + " 짝");
				}
			}
			else { 
				if (i%10 == 3 || i%10 == 6 || i%10 == 9) {
					System.out.println(i + " 짝");
				}
			}
		}

		System.out.println("finished");
	}
}
