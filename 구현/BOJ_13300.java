package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_13300_B2_방 배정
 * @author mingggkeee
 * 구현
 */

public class BOJ_13300 {
	static int N, K, answer;
	static int [][]students;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		students = new int[7][2];
		
		for(int i=0; i<N; i++) {
			// 여자 0 남자 1
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(num1 == 0) {
				students[num2][0]++;
			} else {
				students[num2][1]++;
			}

			
		}
		
		for(int i=1; i<=6; i++) {
			answer += students[i][0]/K;
			if(students[i][0]%K !=0) {
				answer++;
			}
			answer += students[i][1]/K;
			if(students[i][1]%K !=0) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
}
