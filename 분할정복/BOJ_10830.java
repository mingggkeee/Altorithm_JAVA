package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_10830_G4_행렬 제곱
 * @Author mingggkeee
 * @Date 2022. 4. 12.
 * @Category : 분할정복
 * B가 짝수일 때 B번 행렬을 곱한 결과는 B/2번 행렬을 곱한 결과에 B/2번 행렬을 곱한 결과
 * B/2번은 B/4번 * B/4번
 */

public class BOJ_10830 {
	
	static int N;
	static long B;
	static int[][] A;
	static int mod = 1000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		A = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken()) % mod;
			}
		}
		
		int[][] ans = divide(B);
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(ans[r][c]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int[][] divide(long cnt){
		
		if(cnt == 1) {
			return A;
		}
		
		int[][] arr = divide(cnt/2);
		
		if(cnt % 2 == 0) {
			return calculcate(arr, arr);
		}
		else {
			int[][] arr2 = calculcate(arr, A);
			return calculcate(arr, arr2);
		}
		
	}
	
	static int[][] calculcate(int[][] A, int[][] B){
		
		int[][] temp = new int[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int k=0; k<N; k++) {
					temp[r][c] += (A[r][k] * B[k][c]) % mod;
				}
				
				temp[r][c] %= mod;
			}
			
			
		}
		
		return temp;
		
	}
	
}
