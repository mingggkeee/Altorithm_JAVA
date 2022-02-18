package 그리디;

import java.io.*;
import java.util.*;

/**
 * BOJ_1700_G1_멀티탭 스케줄링
 * @author mingggkeee
 * 그리디 알고리즘
 */

public class BOJ_1700 {
	
	static int N,K;
	static int answer;
	static int [] sequence;
	static boolean [] isUsing;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sequence = new int [K];
		isUsing = new boolean[K+1];	// K가 1<=K<<=100
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			// 꽂는 순서 받기
			sequence[i] = Integer.parseInt(st.nextToken());	
		}
		
		int size = 0;	// 멀티탭에 현재 꽂혀 있는 전자제품 개수
		
		
		for(int i=0; i<K; i++) {
			int temp = sequence[i];
			
			// 사용 하려는 것이 이미 콘센트에 꽂혀 있는 경우 -> pass(조건 1)
			if(isUsing[temp] == true) {
				continue;
			}
			// 사용 하려는 것이 콘센트가 안꽂혀 있는 경우(조건 2)
			else {
				// 여유공간 O(조건 2-1)
				if(size<N) {
					isUsing[temp] = true;
					size++;
				}
				// 여유공간 X(조건 2-2)
				else {
					List<Integer> list = new ArrayList<>();
					// 현재 꽂혀 있는 것이 나중에 쓸 때 리스트에 추가
					for(int j=i; j<K; j++) {
						if(isUsing[sequence[j]]==true&&!list.contains(sequence[j])) {
							list.add(sequence[j]);
						}
					}
					
					// 나중에 사용되는 컨센트가 멀티탭 구멍 개수보다 작을 때 : 나중에 쓰지 않는 것이 있다는 뜻이다. (조건 3)
					if(list.size() < N) {
						// 나중에 안쓰는거 제거해주기
						for(int j=0; j<isUsing.length; j++) {
							if(isUsing[j] == true && !list.contains(j)) {
								isUsing[j] = false;
								break;
							}
						}
						
					}
					// 현재 꽂혀있는 모든 컨센트가 나중에 사용될 때 : 가장 나중에 사용되는 것을 뽑기 (조건 4)
					else {
						int removeIdx = list.get(list.size()-1);
						isUsing[removeIdx] = false;
					}
					
					// 현재 사용하려는거 추가
					isUsing[temp] =true;
					// 빼고 꽂았으므로 추가
					answer++;
				}
			}
		}
			
		System.out.println(answer);

	}
	
}
