package 자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_1043_G4_거짓말
 * @author mingggkeee
 *
 */

public class BOJ_1043 {
	
	static int N, M;	// 사람 수, 파티 수
	static int truth;	// 진실을 아는 사람 수
	static int[] parents;
	
	static void makeSet() {
		parents = new int[N+1];
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		makeSet();
		
		truth = sc.nextInt();
		int repre = 0;
		
		if(truth > 0) {
			repre = sc.nextInt();
			for(int i=1; i<truth; i++) {
				int b = sc.nextInt();
				union(repre, b);
			}
		}
		
		for(int i=0; i<M; i++) {
			List<Integer> list = new ArrayList<Integer>();
			int cov = sc.nextInt();
			for(int j=0; j<cov; j++) {
				list.add(sc.nextInt());
			}
		}
		
		sc.close();
	}

}
