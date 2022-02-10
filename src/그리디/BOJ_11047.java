package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ_11047_S3_동전0
 * @author mingggkeee
 * 그리디 알고리즘
 */
public class BOJ_11047 {
	
	static int N,K;
	static ArrayList<Integer> money;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 동전 종류
		K = Integer.parseInt(st.nextToken());	// 원하는 돈
		money = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			money.add(Integer.parseInt(br.readLine()));
		}
		
		money.sort(Collections.reverseOrder());
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			int temp = money.get(i);
			count += K / temp;
			K = K % temp;
		}
		
		System.out.println(count);
		br.close();

	}

}
