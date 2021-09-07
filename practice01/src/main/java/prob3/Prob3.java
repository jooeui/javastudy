package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int x = 0, i, sum;
		while(x < 3) {
			sum = 0;
			
			System.out.print("숫자를 입력하세요: ");
			int input = scanner.nextInt();
			if( input % 2 == 0 ) {
				i = 0;
				while(i <= input) {
					sum += i;
					i += 2;
				}
			}
			else {
				i = 1;
				while(i <= input) {
					sum += i;
					i += 2;
				}
			}
			
			System.out.println("결과 값 : " + sum);
			System.out.println();
			x++;
		}
		
		System.out.println("finished");
		scanner.close();
	}
}
