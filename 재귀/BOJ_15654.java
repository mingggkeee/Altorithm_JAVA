package 재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BoJ_15654_S3_N과 M(5)
 * @author "mingggkeee"
 * 순열
 */
public class BOJ_15654 {
	
	static int N,M;
	static int[] numbers, nums;
	static boolean[] isSelected;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N+1];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		permu(0);
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void permu(int cnt) throws IOException{
		if(cnt==M) {
			for(int i : numbers) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) {
				continue;
			}
			numbers[cnt] = nums[i];
			isSelected[i] = true;
			
			permu(cnt+1);
			isSelected[i] = false;
		}
	}

}
