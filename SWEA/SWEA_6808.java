package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_6808_D3_규영이와 인영이의 카드게임
 * @author mingggkeee
 *
 */
public class SWEA_6808 {
	
	static int T;
	static int [] gyuyoung, inyoung, nums;
	static boolean [] isVisited, isSelected;
	static int answer1, answer2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer1 = 0;
			answer2 = 0;
			gyuyoung = new int[9];
			inyoung = new int[9];
			nums = new int[9];
			isVisited = new boolean[19];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gyuyoung[i] = num;
				isVisited[num] = true;
			}
		
			int index = 0;
			for(int i=1; i<=18; i++) {
				if(isVisited[i] == false) {
					nums[index] = i;
					index++;
				}
			}
			
			isSelected = new boolean[9];
			
			permu(0);
			
			bw.write("#"+t+" "+answer1+" "+answer2+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void permu(int cnt) {
		if(cnt==9) {
			cardGame();
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(isSelected[i] == true) {
				continue;
			}
			
			inyoung[cnt] = nums[i];
			isSelected[i] = true;
			permu(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void cardGame() {
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<9; i++) {
			if(gyuyoung[i] > inyoung[i]) {
				sum1 += gyuyoung[i] + inyoung[i];
			} else {
				sum2 += gyuyoung[i] + inyoung[i];
			}
		}
		// 규영이가 이긴경우
		if(sum1 > sum2) {
			answer1++;
		} else if(sum1 < sum2) {
			answer2++;
		} 
	}

}
