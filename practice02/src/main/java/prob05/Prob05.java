package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */
			int start = 1;
			int end = 100;
			int inputNum = 0;
			int count = 1;
			
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;

			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			
			while(true) {
				System.out.println(start + "-" + end);
				System.out.print(count + ">>");
				inputNum = scanner.nextInt();
				
				if(inputNum == correctNumber) {
					System.out.println("맞았습니다.");
					break;
				} 
				else if(inputNum > correctNumber) {
					System.out.println("더 작게");
					end = inputNum;
				}
				else if(inputNum < correctNumber) {
					System.out.println("더 크게");
					start = inputNum;
				}
				count++;
				
			}
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}