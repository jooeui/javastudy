package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		
		String[] inputArr;
		
		inputArr = text.split("");
		
		int printlength = 1;
		for(int i = 0; i < text.length(); i++) {
			for(int j = 0; j < printlength; j++) {
				System.out.print(inputArr[j]);
			}
			printlength++;
			System.out.println();
		}

		System.out.println("finished");
		scanner.close();
	}

}
