package 해시맵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


/**
 * BOJ_13414_S3_수강신청
 * @Author mingggkeee
 * @Date 2022. 5. 17.
 * @Category : 해시맵
 */
public class BOJ_13414 {
	
	static int limit, N;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		limit = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(set.contains(input)) {
				set.remove(input);
				set.add(input);
			} else {
				set.add(input);
			}
		}
		
		for(String str : set) {
			if(limit == 0) {
				break;
			}
			bw.write(str+"\n");
			limit--;
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
