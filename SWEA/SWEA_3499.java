package SWEA;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA_3499_D3_퍼펙트 셔플
 * @author mingggkeee
 *
 */
public class SWEA_3499 {
	
	static int T, N;
	// static String[] deque;
	static Queue<String> temp1, temp2, deque;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());	// 테케 개수
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());	// 카드의 개수
			// deque = new String[N];
			deque = new LinkedList<String>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				// deque[i] = st.nextToken();
				deque.offer(st.nextToken());
			}
			
			shuffle(deque);
			
			bw.write("#"+t+" ");
			for(String str : deque) {
				bw.write(str+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	public static void shuffle(Queue<String> deque) {
		temp1 = new LinkedList<String>();
		temp2 = new LinkedList<String>();
		int idx = 0;
		// 홀수일때
		if(N%2==0) {
			idx = N/2;
		} else {
			idx = N/2+1;
		}
		
		for(int i=0; i<N; i++) {
			if(i<idx) {
				temp1.offer(deque.poll());
			} else {
				temp2.offer(deque.poll());
			}
		}
		int cnt = 0;
		while(!temp1.isEmpty() || !temp2.isEmpty()) {
			if (cnt%2==0) {
				deque.offer(temp1.poll());
			} else {
				deque.offer(temp2.poll());
			}
			cnt++;
		}
		
		
	}

}
