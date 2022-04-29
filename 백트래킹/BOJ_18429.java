package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_18429_S3_근손실
 * @Author mingggkeee
 * @Date 2022. 4. 29.
 * @Category : 백트래킹
 */
public class BOJ_18429 {
	
	static int N, K;
	static int[] kits;
	static int[] selected;
	static boolean[] isVisited;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		kits = new int[N];
		selected = new int[N];
		isVisited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			kits[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(0);
		
		System.out.println(count);
		
	}
	
	static void permu(int cnt) {
		if(cnt == N) {
			if(chk()) {
				count++;
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(!isVisited[i]) {
				isVisited[i] = true;
				selected[cnt] = kits[i];
				permu(cnt+1);
				isVisited[i] = false;
			}
			
		}
	}
	
	static boolean chk() {	
		int start = 500;
		for(int i=0; i<N; i++) {
			
			start -= K;
			start += selected[i];
			if(start < 500) {
				return false;
			}
			
		}
		
		return true;
		
	}

}
