package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ_1644_G3_소수의 연속합
 * @Author mingggkeee
 * @Date 2022. 5. 11.
 * @Category : 에라토스테네스의 체, 투 포인터
 */

public class BOJ_1644 {

	static int N, answer;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		prime = new boolean[N+1];
		
		for(int i=2; i<=(N+1)/2; i++) {
			for(int j=2; j*i <=N; j++) {
				prime[j*i] = true;
			}
		}
		prime[1] = true;
		
		for(int i=2; i<=N; i++) {
			if(!prime[i]) {
				list.add(i);
			}
		}
		
		
		for(int i=0; i<list.size(); i++) {
			int sum = 0;
			for(int j=0; j+i < list.size(); j++) {
				sum += list.get(i+j);
				if(sum == N) {
					answer++;
					break;
				} else if(sum > N) {
					break;
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
}
