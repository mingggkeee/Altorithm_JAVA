package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2012 {

	public static void main(String[] args) throws IOException{
		long answer = 0; // 불만도
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=1; i<=N; i++) {
			if(arr[i] == i) {
				continue;
			} else {
				answer += Math.abs(i-arr[i]);
				arr[i] = i;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
