package 해시맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * BOJ_S4_25192_인사성 밝은 곰곰이
 * @Author mingggkeee
 * @Date 2022. 5. 16.
 * @Category : 해시 맵
 */
public class BOJ_25192 {

	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int answer = 0;
		Set<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.equals("ENTER")) {
				answer += set.size();
				set = new HashSet<>();
			} else {
				set.add(input);
			}
		}
		if(set.size() > 0) {
			answer+=set.size();
		}
		System.out.println(answer);
	}
	
}
