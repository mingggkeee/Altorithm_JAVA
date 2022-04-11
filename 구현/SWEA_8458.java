package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_8458_D4_원점으로 집합
 * @Author mingggkeee
 * @Date 2022. 4. 11.
 * @Category :
 */

public class SWEA_8458 {

	static int T, N;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int val = -1;
			int compare = Integer.MIN_VALUE;
			boolean check = false;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int distance = Math.abs(x) + Math.abs(y);
				if(i==0) {
					val = distance %2;
					compare = distance;
				} else {
					if(val!=distance%2) {
						check = true;
					} else {
						compare = Math.max(compare, distance);
					}
				}
			}
			int answer = 0;
			if(check) {
				answer = -1;
			} else {
				while(compare > 0) {
					answer++;
					compare-=answer;
				}
				compare *= -1;
				
				if(compare%2==1) {
					if(answer%2==0) {
						answer+=1;
					} else {
						answer+=2;
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
		
	}
	
}
