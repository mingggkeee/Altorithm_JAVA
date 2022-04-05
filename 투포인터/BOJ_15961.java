package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_15961_G4_회전 초밥
 * @author mingggkeee
 * 투포인터
 */
public class BOJ_15961 {
	
	static int N, D, K, C;
	static int[] sushi;
	static int[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 벨트에 놓인 접시의 수
		sushi = new int[N];
		D = Integer.parseInt(st.nextToken());	// 초밥의 가짓 수
		K = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		C = Integer.parseInt(st.nextToken()); 	// 쿠폰 번호
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		isSelected = new int[D+1];
		
		System.out.println(slideWindow());
		
	}
	
	static int slideWindow() {
		
		int dup = 0;
		int max;
		
		for(int i=0; i<K; i++) {
			if(isSelected[sushi[i]] == 0) {	// 중복이 아니면 추가
				dup++;
			}
			isSelected[sushi[i]]++;	// 중복방지체크
		}
		
		max = dup;
		
		for(int i=1; i<N; i++) {
			
			if(max <= dup) {
				if(isSelected[C]==0) {	// 쿠폰이 없으면 max 1 추가
					max = dup + 1;
				} else {
					max = dup;
				}
			}
			
			// 슬라이드 이동
			isSelected[sushi[i-1]]--;
			if(isSelected[sushi[i-1]] == 0) {
				dup--;
			}
			
			if(isSelected[sushi[(i+K-1)%N]] == 0) {
				dup++;
			}
			isSelected[sushi[(i+K-1)%N]]++;
			
		}
		
		return max;
		
		
	}

}
