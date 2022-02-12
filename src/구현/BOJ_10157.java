package 구현;

import java.util.*;

/**
 * BOJ_10157_S4_자리배정
 * @author mingggkeee
 * 구현
 */

public class BOJ_10157 {
	static int C,R,K;
	static int x,y;	// 답 좌표
	static int[][] map;
	static int[][] dir = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();	// 찾아야하는 번호
		
		map = new int[R][C];
		
	    if(R*C<K) {
	    	System.out.println(0);
	    	System.exit(0);
	    }
		
		int count = 1;
		int nx = R-1;
		int ny = 0;
		int direction = 0;
		
		while(count != K) {
			map[nx][ny] = count;
			int tempx = nx + dir[direction][0];
			int tempy = ny + dir[direction][1];
			
			if(tempx<0 || tempy<0 || tempx>=R || tempy>=C || map[tempx][tempy] !=0) {
				direction++;
				if(direction==4) {
					direction=0;
				}
				tempx = nx + dir[direction][0];
				tempy = ny + dir[direction][1];
			}
			
			nx = tempx;
			ny = tempy;
			
			count++;
		}

		
		System.out.println((ny+1)+" "+(R-nx));
		sc.close();

	}

}
