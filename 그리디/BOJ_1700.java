package 그리디;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1700_G1_멀티탭 스케줄링
 * @author mingggkeee
 * 그리디 알고리즘
 */

public class BOJ_1700 {
	
	static int N,K;
	
	static int answer;
	static int [] seq;
	static int [] counting;
	static int [] using;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		seq = new int [K];
		using = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			// 꽂는 순서 받기
			seq[i] = Integer.parseInt(st.nextToken())-1;	// K는 0~K-1
		}
		
		// 일단 꽂기
		for(int i=0; i<N; i++) {
			using[i] = seq[i];
		}
		
		// 나머지 순서 멀티탭이 꽉찬 후
		for(int i=N; i<K; i++) {
			// 이미 꽃혀있는 경우
			boolean success = false;
			int compareNum = seq[i];
			for(int a=0; a<N; a++) {
				if(using[a] == compareNum) {
					success = true;
					break;
				}
			}
			if(success == true) {
				continue;
			}
			
			// 아닌 경우
			else {
				int [] counting = new int[K];
				// 멀티탭 구 개수 만큼 뒤의 개수를 확인
				for(int j=i; j<j+N; j++) {
					if(j>=N) {
						break;
					}
					int temp = seq[j];
					counting[temp]++;
					
				}
				
				// 빼낼 멀티탭 콘센트 찾기
				int subNum = Integer.MAX_VALUE;
				int idx = -1;
				for(int m=0; m<N; m++) {
					int compare = counting[using[m]];
					if(compare < subNum) {
						idx = m;
						subNum = compare;
					}
				}
				
				// 빼낼거 빼기
				answer++;
				using[idx] = compareNum;
			}
				
			
			
		}
		
		
		
		System.out.println(answer);
		
		
		
	}
	
}
