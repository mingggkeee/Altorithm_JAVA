package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10797 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		
		st= new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		for(int i=0; i<5; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(temp == num) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
