package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_14465_S2_소가 길을 건너간 이유 5
 * @Author mingggkeee
 * @Date 2022. 5. 8.
 * @Category : 슬라이딩 윈도우
 */
public class BOJ_14465 {

	static int N, K, B;
	static int[] traffic;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		traffic = new int[N+1];
		
		for(int i=0; i<B; i++) {
			int num = Integer.parseInt(br.readLine());
			traffic[num]++;
		}
		
		int sum = 0;
		
		for(int i=1; i<=K; i++) {
			sum += traffic[i];
		}
		
		int answer = sum;
		
		int lc = 0;
		int rc = K;
		
		for(int i=1; i<=N-K; i++) {
			sum -= traffic[++lc];
			sum += traffic[++rc];

			answer = Math.min(answer, sum);
		}
		
		System.out.println(answer);
		
		
	}
	
}
