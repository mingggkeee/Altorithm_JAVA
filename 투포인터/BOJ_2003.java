package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2003_S3_수들의 합2
 * @Author mingggkeee
 * @Date 2022. 4. 28.
 * @Category : 투 포인터
 */
public class BOJ_2003 {
	
	static int N, M, count;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int lc = 0;
		int rc = 0;
		int sum = 0;
		
		while(true) {
			if(sum >= M) {
				sum -= nums[lc++];
			}
			else if(rc == N) {
				break;
			} else {
				sum += nums[rc++];
			}
			
			if(sum == M) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
