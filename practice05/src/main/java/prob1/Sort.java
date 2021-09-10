package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		//
		
		System.out.println();
		
		int max = 0;	// 최댓값
		
		// 배열 안에서 최댓값 구하기
		for(int i = 0; i < count; i++) {
			if (max < array[i]) {
				max = array[i]; 
			}
		}
		
		int tryCount = 0;
		int temp;
		
		// 내림차순으로 정렬 = array[0]이 최댓값이 됨
		// 그러므로 array[0]이 최댓값이 아닌 경우 반복
		while(array[0] != max) {
			for(int i = 1; i < count-tryCount; i++) {
				if(array[i-1] < array[i]) {
					temp = array[i-1];
					array[i-1] = array[i];
					array[i] = temp;
				}
			}
			tryCount++;
		}

		
		// 결과 출력
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}