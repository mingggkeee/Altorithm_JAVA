package 해시맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * BOJ_2002_S1_추월
 * @Author mingggkeee
 * @Date 2022. 5. 18.
 * @Category : 문자열, 해시맵
 */
public class BOJ_2002 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		Map<String, Integer> start = new HashMap<>();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			start.put(input, i);
		}
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			int compare = start.get(input);
			
			if(i < compare) {
				answer++;
			}
			
			
		}
		
		System.out.println(answer);
	}

}
