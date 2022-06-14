package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_1449_S3_수리공 항승
 * @Author mingggkeee
 * @Date 2022. 6. 14.
 * @Category : 그리디, 정렬
 */
public class BOJ_1449 {

	static int N, L;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int tapeR = (int)(arr[0] -0.5 + L);
		answer++;
		

		
		for(int i=1; i<N; i++) {
			if(tapeR < (int)(arr[i] + 0.5)) {
				tapeR = (int)(arr[i] - 0.5 + L);
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}
