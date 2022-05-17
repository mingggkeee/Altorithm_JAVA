package 해시맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ_9375_S3_패션왕신해빈
 * @Author mingggkeee
 * @Date 2022. 5. 17.
 * @Category : 해시맵, 조합
 */

public class BOJ_9375 {

	static int T, N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			N = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			
			while(N-->0) {
				st = new StringTokenizer(br.readLine());
				
				st.nextToken();	// 이름은 필요 X
				
				String cloth = st.nextToken();
				
				if(map.containsKey(cloth)) {
					map.put(cloth, map.get(cloth)+1);
				}
				else {
					map.put(cloth, 1);
				}
			}
			
			int result = 1;
			
			for(int i : map.values()) {
				result *= (i + 1);
			}
			
			System.out.println(result-1);
		}
	}
	
}
