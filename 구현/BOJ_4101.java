package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4101 {

	static int n1, n2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			if(n1==0 && n2==0) {
				break;
			}
			
			if(n1 > n2) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	
}
