package 해시맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * BOJ_1302_S4_베스트셀러
 * @Author mingggkeee
 * @Date 2022. 5. 18.
 * @Category : 문자열, 베스트셀러
 */
public class BOJ_1302 {

	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				map.replace(input, map.get(input)+1);
			} else {
				map.put(input, 1);
			}
		}
		
		int max = 0;
		for(String a : map.keySet()) {
			max = Math.max(max, map.get(a));
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for(String str : list) {
			if(map.get(str)==max) {
				System.out.println(str);
				break;
			}
		}
		
	}

}
