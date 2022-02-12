package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_2527_S1_직사각형
 * @author mingggkeee
 * 수학, 구현, 조건분기
 * 2개의 직사각형 중에 겹치는 범위를 알려주기
 */

public class BOJ_2527 {
	
	static int x1,y1,x2,y2;
	static int x3,y3,x4,y4;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 4번 입력
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());
			
			// 점인경우 (c)
			if((x2==x3 && y2==y3) || (x1==x4 && y2==y3) || (x2==x3 && y1==y4) || (x1==x4 && y1==y4)) {
				System.out.println('c');
			}
			// 선분인 경우(b)
			else if((x2==x3 && y2!=y3) || (x1==x4 && y2!=y3) || (x2!=x3 && y1==y4) || (x1!=x4 && y1==y4)) {
				System.out.println('b');
			}
			// 겹치지 않는 경우(d)
			else if(x2<x3 || x4<x1 || y2<y3 || y4<y1) {
				System.out.println('d');
			}
			// 직사각형(a)
			else {
				System.out.println('a');
			}
		}
		
		br.close();

	}

}
