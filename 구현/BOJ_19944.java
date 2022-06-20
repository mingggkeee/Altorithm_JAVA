package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19944 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(M > N) {
			System.out.println("TLE!");
		} else {
			if(M<=2) {
				System.out.println("NEWBIE!");
			} else {
				System.out.println("OLDBIE!");
			}
		}
	}
	
}
