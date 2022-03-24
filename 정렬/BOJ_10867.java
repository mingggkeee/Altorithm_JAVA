package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ_10867_S5_중복 빼고 정렬하기
 * @author mingggkeee
 * 정렬
 */

public class BOJ_10867 {

	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		Integer[] arr = set.toArray(new Integer[0]);
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			bw.write(arr[i]+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
