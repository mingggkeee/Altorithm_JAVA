package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_4344_B1_평균은 넘겠지
 * @author mingggkeee
 * 구현
 */

public class BOJ_4344 {
	
	static int[] nums;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			nums = new int[size];
			double sum = 0;
			for(int i=0; i<size; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				sum += nums[i];
			}
			double avg = sum/size;
			
			int count = 0;
			
			for(int i=0; i<size; i++) {
				if(nums[i] > avg) {
					count++;
				}
			}
			char a = '%';
			
			System.out.printf("%.3f%c%n",(double)count/size*100, a);
			
			
		}
		

	}
	
}
