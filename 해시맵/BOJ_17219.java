package 해시맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ_17219_S4_비밀번호 찾기
 * @Author mingggkeee
 * @Date 2022. 5. 15.
 * @Category : Map
 */
public class BOJ_17219 {

	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(map.get(br.readLine())+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
