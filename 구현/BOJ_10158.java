package 구현;

import java.io.*;
import java.util.*;

/**
 * BOJ_10158_S4_개미
 * @author mingggkeee
 * 구현, 사칙, 수학
 */

public class BOJ_10158 {
	
	static int w,h;	// w는 열 h는 행
	static int x,y;	// 초기 위치
	static int t;	// 이동 시간
	
	static int ansx, ansy;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// w,h 값 입력
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		// 현재 위치 입력
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		// 시간
		t = Integer.parseInt(br.readLine());
		
		ansx = (x+t)%(2*w);
		ansy = (y+t)%(2*h);
		
		ansx = w - Math.abs(w-ansx);
		ansy = h - Math.abs(h-ansy);
		
		System.out.println(ansx+" "+ansy);
		
		br.close();
	}
}
