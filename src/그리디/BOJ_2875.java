package 그리디;

import java.util.Scanner;

/**
 * BOJ_2875_B3_대회 or 인턴
 * @author mingggkeee
 * 2명의 여학생, 1명의 남학생이 참가원칙(대회)
 * 인턴십에 참가하면 대회참가 불가
 */
public class BOJ_2875 {
	
	static int N,M,K;
	static int answer=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 여자 수
		M = sc.nextInt();	// 남자 수
		K = sc.nextInt();	// 인턴십 참가해서 빠져야되는 수
		
		
		for(int i=0; i<=K; i++) {
			// 여자 빼기
			int female = (N-i)/2;
			// 남자 빼기
			int male = M - (K-i);
			
			// 팀 수
			int team = Math.min(female, male);
			answer = Math.max(team, answer);
		}
		
		System.out.println(answer);
		
		sc.close();
	}

}
