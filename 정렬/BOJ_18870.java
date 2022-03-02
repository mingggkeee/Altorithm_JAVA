package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ_18870_좌표 압축
 * @author mingggkeee
 *
 */

public class BOJ_18870 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] clone = nums.clone();
		
		Arrays.sort(nums);
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], count++);
			}
		}
		
		for(int i =0; i<N; i++) {
			sb.append(map.get(clone[i])).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
