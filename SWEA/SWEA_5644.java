package SWEA;

/**
 * SWEA_5644_무선충전
 * @author mingggkeee
 * 구현
 */ 

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5644 {

	static class BC {
		int x;
		int y;
		int c;
		int p;
				
		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	static int chargeMax;
	static int M, A, x1, y1, x2, y2;
	static int[] moveA, moveB;
	static BC[] list;
	static int[][] dir = {{0,0}, {0,-1}, {1,0}, {0,1}, {-1,0}};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		input(T);
	}
	
	// 입력
	public static void input(int T) throws IOException{
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M];
			moveB = new int[M];
			list = new BC[A];
			
			// A 무빙 입력
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			// B 무빙 입력
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			// 충전기 정보 입력
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				list[i] = new BC(
							Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken())							
						);
			}
			
			chargeMax = 0;
			x1=y1=1;
			x2=y2=10;
			// 0부터 시작이니까 계산먼저		
			for(int i=0; i<M; i++) {
				chargeMax += calculator();
				x1 += dir[moveA[i]][0];
				y1 += dir[moveA[i]][1];
				x2 += dir[moveB[i]][0];
				y2 += dir[moveB[i]][1];
			}
			// 마지막 정보까지
			chargeMax += calculator();
			
			System.out.println("#" + tc + " " + chargeMax);
		}
	}
	
	public static int calculator() {
		
		ArrayList<BC> A = new ArrayList<>();
		ArrayList<BC> B = new ArrayList<>();
		
		for(int i=0; i<list.length; i++) {
			BC bc = list[i];
			
			int lengthA = Math.abs(x1-bc.x) + Math.abs(y1-bc.y);
			int lengthB = Math.abs(x2-bc.x) + Math.abs(y2-bc.y);
			
			
			if(lengthA <= bc.c) {
				A.add(bc);
			}
			
			if(lengthB <= bc.c) {
				B.add(bc);
			}
		}
		
		
		int temp = 0;
		
		// A만 범위안에 있을 때
		if(B.size() == 0) {
			for(BC bc : A) {
				temp = Math.max(bc.p, temp);
			}
		} else if(A.size() == 0) {
			// B만 범위안에 있을 때
			for(BC bc : B) {
				temp = Math.max(bc.p, temp);
			}
		} else if (A.size() != 0 && B.size() != 0) {
			// A B 둘다 범위 안에 있을 떄
			for(BC bcA : A) {
				for(BC bcB : B) {
					if((bcA.x == bcB.x) && (bcA.y == bcB.y)) {
						temp = Math.max(temp, bcA.p);
					} else {
						temp = Math.max(temp, bcA.p+bcB.p);
					}
				}
			}
		}
		
		return temp;
	}
	
}