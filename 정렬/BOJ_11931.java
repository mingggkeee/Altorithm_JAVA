package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ_11931_S5_수 정렬하기 4
 * @author mingggkeee
 * 정렬
 */

public class BOJ_11931 {
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		for(int i=N-1; i>=0; i--) {
			bw.write(nums[i]+"\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
