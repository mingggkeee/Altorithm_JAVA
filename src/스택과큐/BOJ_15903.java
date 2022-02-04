package 스택과큐;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15903{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] arr1 = new long[n];
		for(int i = 0; i<n; i++){
			int k = sc.nextInt();
			arr1[i] = k;
		}
		
		for(int i = 0;i<m;i++){
			Arrays.sort(arr1);
			long add = arr1[0]+arr1[1];
			arr1[0] = add;
			arr1[1] = add;
		}
		for(int i = 0; i<arr1.length; i++){
			sum += arr1[i];
		}
		System.out.println(sum);
	}
}
