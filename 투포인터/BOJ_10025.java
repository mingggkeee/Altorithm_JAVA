package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_10025_S4_게으른 백곰
 * @Author mingggkeee
 * @Date 2022. 5. 4.
 * @Category : 슬라이딩 윈도우
 */
public class BOJ_10025 {

	static int N, K;
	static int val[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		val = new int[1000001];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int value= Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			val[loc] = value;
		}
		
		int sum = 0;
		int window = 1 +(2*K);
		int max = 0;
		
		for(int i=0; i<=1000000; i++) {
			if(i >= window) {
				sum -= val[i-window];
			}
			sum += val[i];
			if(sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
	
}
