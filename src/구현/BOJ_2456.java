package 구현;

import java.util.Scanner;

public class BOJ_2456 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[4]; // 점수 저장
        int[] arr2 = new int[4]; // 2점 받은 수
		int[] arr3 = new int[4]; // 3점 받은 수
	
		int temp = 0; // 1등점수 저장용
		int temp2 = 0; // 후보 번호 저장용
		int temp3 = 0; // 인덱스 저장용
		
		// 점수 저장 및 3점 2점 표 개수 계산
		for (int i=0;i<N;i++) {
			for (int j=0;j<3;j++) {
				int num = sc.nextInt();
				 arr[j] +=num;
				if (num == 3) {
					arr3[j] += 1;
				
				} else if (num == 2) {
					arr2[j] += 1;
				}
			}
		}
		
		for (int i=0;i<3;i++) {
			if (temp < arr[i]) {
				temp = arr[i]; // 최고점수
				temp2 = i+1; // 반장 저장
				temp3 = i; // 인덱스 저장
				
			
			
			} else if (temp == arr[i]) {
				if(arr3[temp3] > arr3[i]) {
					// 반장 안바뀌니 패스
				}
				// 반장 바뀌는 경우
				else if (arr3[temp3] < arr3[i]) {
						temp2 = i+1; // 반장 교체
				}
				// 3점표가 같을 때
				else if (arr3[temp3]==arr3[i]) {
					
					if (arr2[temp3]<arr2[i]) {
					
						temp2 = i+1; // 반장 교체
						
					} else {
						temp2 = 0; // 반장 없음
					}
					
					} 
					
				}
			
			}
			System.out.println(temp2+ " " + temp);
			sc.close();
		}
}