package 구현;

import java.util.Scanner;

public class BOJ_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] weight = new int[N];
		int[] height = new int[N];
		
		for(int i=0; i<N; i++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			int count = 0;
			int currentWeight = weight[i];
			int currentHeight = height[i];
			for(int k=0; k<N; k++) {
				if(i==k) {
					continue;
				}
				if(currentWeight < weight[k] && currentHeight < height[k]) {
					count++;
				}
			}
			System.out.print(count+1+" ");
		}

	}

}
