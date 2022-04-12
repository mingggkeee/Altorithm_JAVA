package SWEA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA_9760_D4_포커게임
 * @Author mingggkeee
 * @Date 2022. 4. 12.
 * @Category : 구현
 * 0 : space ,1 : diamond ,2 : heart ,3 : clover
 */

public class SWEA_9760 {
	
	static int T;
	static String answer;
	static String[] cards;
	static int[] suit, rank;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			cards = new String[5];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<5; i++) {
				cards[i] = st.nextToken();
			}
			
			pokerGame();
			
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void pokerGame() {
		
		suit = new int[4];
		rank = new int[14];
		
		for(int i=0; i<5; i++) {
			String input = cards[i];
			
			char c1 = input.charAt(0);
			char c2 = input.charAt(1);
			
			if(c1 == 'S') {
				suit[0]++;
			} else if(c1 == 'D') {
				suit[1]++;
			} else if(c1 == 'H') {
				suit[2]++;
			} else {
				suit[3]++;
			}
			
			if(c2 == 'A') {
				rank[1]++;
			} else if(c2 == 'T') {
				rank[10]++;
			} else if(c2 == 'J') {
				rank[11]++;
			} else if(c2 == 'Q') {
				rank[12]++;
			} else if(c2 == 'K') {
				rank[13]++;
			} else {
				rank[c2-'0']++;
			}
			
		}
		
		boolean check = false;
		
		for(int i=1; i<=13; i++) {
			
			int count = 0;
			
			for(int j=i; j<i+5; j++) {
				
				if(count != j-i) {
					break;
				}
				
				int idx = j;
				if(j>13) {
					idx = j%13;
				}
				
				if(rank[idx] == 1) {
					count++;
				}
			}
			
			if(count == 5) {
				check = true;
				break;
			}
			
		}
		
		Arrays.sort(suit);
		
		// 1번이거나, 4번
		if(suit[3] == 5) {

			if(check) {
				answer = "Straight Flush";
			} else {
				answer = "Flush";
			}
			
		} // 5번 
		else if(check) {
			answer = "Straight";
		}
		else {
			Arrays.sort(rank);
			
			// 2번
			if(rank[13] == 4) {
				answer = "Four of a Kind";
			} 
			// 3번, 6번
			else if(rank[13] == 3) {
					
				if(rank[12] == 2) {
					answer = "Full House";
				} else {
					answer = "Three of a kind";
				}
					
			} else if(rank[13] == 2) {
				
				// 7번
				if(rank[12] == 2) {
					answer = "Two pair";
				} 
				// 8번
				else {
					answer = "One pair";
				}
			}
			else {
				// 9번
				answer = "High card";
			}			
		}
	}

}
