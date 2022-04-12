package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_11098_B1_첼시를 도와줘!
 * @Author mingggkeee
 * @Date 2022. 4. 12.
 * @Category : 문자옅
 */

public class BOJ_11098 {

	static int n, p, cost;
	static String name;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			p = Integer.parseInt(br.readLine());
			cost = 0;
			
			for(int j=0; j<p; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int compare = Integer.parseInt(st.nextToken());
				String temp = st.nextToken();
				
				if(compare > cost) {
					cost = compare;
					name = temp;
				}
			}
			
			sb.append(name+"\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}
