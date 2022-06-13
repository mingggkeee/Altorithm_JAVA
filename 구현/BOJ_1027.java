package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1027 {
	
	static int N;
	static int[] building, vision;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		building = new int[N];
		vision = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			vision[i] += 1;
			vision[i+1] += 1;
			double slope = building[i+1] - building[i];
			for(int j=i+2; j<N; j++) {
				double nextSlope = (double)(building[j]-building[i])/(j-i);
				if(nextSlope <= slope) continue;
				slope = nextSlope;
				vision[i]++;
				vision[j]++;
			}
		}
		
		Arrays.sort(vision);
		System.out.println(vision[vision.length-1]);
	}

}
