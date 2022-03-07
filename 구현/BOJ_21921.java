package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_21921_S3_블로그
 * @author mingggkeee
 * 누적합, 구현
 */

/**
 * BOJ_21921_S3_블로그
 * @author mingggkeee
 * 누적합, 구현
 */

public class BOJ_21921 {
	
	static int N, X;
	static int[] visited;
	static int max = 0;
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		visited = new int[N];
		int compare = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			visited[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<X; i++) {
			max += visited[i];
			compare += visited[i];
		}
		
		count++;
		
		for(int i=X; i<N; i++) {
			compare += visited[i];
			compare -= visited[i-X];
			
			if(compare > max) {
				max = compare;
				count = 1;
			} 
			else if(compare == max) {
				count++;
			}
		}
		
		if(max==0) {
			System.out.println("SAD");
		} 
		else {
			System.out.println(max);
			System.out.println(count);
		}
		
	}

}


