package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2477_S4_참외밭
 * @author mingggkeee
 * 구현
 */

public class BOJ_2477 {
	static int [] input;
	static int K, count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());	// 참외의 개수
		
		input = new int[6]; // 변수 저장용
		int maxX = 0;
		int maxY = 0;
		int xIndex = -1;
		int yIndex = -1;
		int subX = 0;
		int subY = 0;
		// 변 입력
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			input[i] = Integer.parseInt(st.nextToken());
			if(dir == 1 || dir == 2) {
				if(input[i] > maxX) {
					maxX = input[i];
					xIndex = i;
				}
			}
			if(dir == 3 || dir == 4) {
				if(input[i] > maxY) {
					maxY = input[i];
					yIndex = i;
				}
			}
		}
		
		if(xIndex == 0) {
			subX = Math.abs(input[1] - input[5]);
		} else if(xIndex == 5) {
			subX = Math.abs(input[4] - input[0]);
		}
		else {
			subX = Math.abs(input[xIndex+1] - input[xIndex-1]);
		}
		
		if(yIndex == 0) {
			subY = Math.abs(input[1] - input[5]);
		} else if(yIndex == 5) {
			subY = Math.abs(input[4] - input[0]);
		}
		else {
			subY = Math.abs(input[yIndex+1] - input[yIndex-1]);
		}
		
		
		count = 0; // 밭 넓이 계산용
		// 넓이 계산
		count = maxX * maxY - subX * subY;
		
		System.out.println(count*K);
		
		
	}

}
