package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_11582_S4_치킨 TOP N
 * @author mingggkeee
 * 분할정복, 정렬
 */

public class BOJ_11582 {
	
	static int N, K;
	static int[] chicken;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		chicken = new int[N];
		for(int i=0; i<N; i++) {
			chicken[i] = Integer.parseInt(st.nextToken());
		}
		
		K = Integer.parseInt(br.readLine());
		int d = N/K;
		int scope = N / d;
		int idx = 0;
		for(int i=0; i<scope-1; i++) {
			List<Integer> list = new ArrayList<>();
			for(int k=idx; k<idx+N/K; k++) {
				list.add(chicken[k]);
			}
			
			Collections.sort(list);
			for(int k=0; k<list.size(); k++) {
				bw.write(list.get(k)+" ");
			}

			idx += N/K;
			
		}
		

		List<Integer> list = new ArrayList<>();
		for(int k=idx; k<N; k++) {
			list.add(chicken[k]);
		}
		
		Collections.sort(list);
		
		for(int k=0; k<list.size(); k++) {
			bw.write(list.get(k)+" ");
		}

		
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
