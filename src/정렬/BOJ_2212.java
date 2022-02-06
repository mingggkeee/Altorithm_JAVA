package 정렬;

import java.util.*;
public class BOJ_2212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt(); 
		int k = sc.nextInt(); 
		
		int sum = 0;
		
		// 입력
		int[] sensorArr = new int[n];
		for(int i = 0; i < n; i++)
			sensorArr[i] = sc.nextInt();
		
		// 센서의 거리를 오름차순으로 정렬
		Arrays.sort(sensorArr);
		
		// 각 센서 거리의 차이를 담은 배열을 만든다.
		Integer[] diffArr = new Integer[n-1];
		for(int i = 0; i < n-1; i++)
			diffArr[i] = sensorArr[i+1] - sensorArr[i];
		
		//5. 차이 배열을 내림차순으로 정렬한다.
		Arrays.sort(diffArr, Collections.reverseOrder());
		
		//6. 차이 배열의 k-1 ~ 마지막 까지의 합을 출력한다.
		for(int i = k-1; i < n-1; i++) {
			sum += diffArr[i];
		}
		System.out.println(sum);
		sc.close();
	}
}