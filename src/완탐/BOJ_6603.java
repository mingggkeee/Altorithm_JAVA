package 완탐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ_6603_S2_로또
 * @author USER
 * 조합 문제
 */
public class BOJ_6603 {
	static int N;
	static int[] input, nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) {
				break;
			} else {
				input = new int[N];
				nums = new int[6];
				for(int i=0; i<N; i++) {
					input[i] = Integer.parseInt(st.nextToken());
				}
				lotto(0, 0);
				System.out.println();
			}
		}
		
		br.close();

	}
	
	public static void lotto(int cnt, int start) {
		if(cnt == 6) {
			for(int i : nums) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<N; i++) {
			nums[cnt] = input[i];
			lotto(cnt+1, i+1);
		}
	}

}
