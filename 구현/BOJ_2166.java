package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2166_G5_다각형의 면적
 * @Author mingggkeee
 * @Date 2022. 4. 13.
 * @Category : 구현, 수학
 */

public class BOJ_2166 {

	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		double answer = 0.0;
		for(int j=N-1,i=0; i<N; i++) {
			answer += 1.0 * (arr[j][0] + arr[i][0]) * (arr[j][1] - arr[i][1]);
			j = i;
		}
		
		System.out.printf("%.1f\n", Math.abs(0.5 * answer));
		
	}
	
}
