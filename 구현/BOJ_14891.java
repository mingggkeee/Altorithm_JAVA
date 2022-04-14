package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_14891_G5_톱니바퀴
 * @Author mingggkeee
 * @Date 2022. 4. 13.
 * @Category : 구현, 시뮬
 */

public class BOJ_14891 {

	static int answer, K;
	static int[] mag1, mag2, mag3, mag4;
	static int idx1, idx2, idx3, idx4;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{

		answer = 0;

		input();
		
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotate(num, -dir);
		}
		
		if(mag1[idx1%8] == 1) {
			answer+=1;
		}
		
		if(mag2[idx2%8] == 1) {
			answer+=2;
		}
		
		if(mag3[idx3%8] == 1) {
			answer+=4;
		}
		
		if(mag4[idx4%8] == 1) {
			answer+=8;
		}
			
		System.out.println(answer);
	}
	
	static void rotate(int num, int dir) {
		
		if(num == 1) {
			
			int coIdx1 = (idx1 + 2) % 8;
			int coIdx2 = (idx2 + 6) % 8;
			idx1 += dir;
			if(idx1 < 0) {
				idx1 += 8;
			}
			
			if(mag1[coIdx1] != mag2[coIdx2]) {
				idx2 += -dir;
				if(idx2 < 0) {
					idx2 += 8;
				}
				coIdx2 = (coIdx2 + 4) % 8;
				int coIdx3 = (idx3 + 6) % 8;
				
				if(mag2[coIdx2] != mag3[coIdx3]) {
					idx3 += dir;
					if(idx3 < 0) {
						idx3 += 8;
					}
					coIdx3 = (coIdx3 + 4) % 8;
					int coIdx4 = (idx4 + 6) % 8;
					
					if(mag3[coIdx3] != mag4[coIdx4]) {
						idx4 += -dir;
						if(idx4 < 0) {
							idx4 += 8;
						}
					}
				}
				
			}
			
		} else if(num ==2) {
			
			int coIdx2 = (idx2 + 6) % 8;
			idx2 += dir;
			if(idx2 < 0) {
				idx2 += 8;
			}
			// 1
			int coIdx1 = (idx1 + 2) % 8;
			if(mag1[coIdx1] != mag2[coIdx2]) {
				idx1 += -dir;
				if(idx1 < 0) {
					idx1 += 8;
				}
			}
			// 3
			coIdx2 = (coIdx2 + 4) % 8;
			int coIdx3 = (idx3 + 6) % 8;
			if(mag2[coIdx2] != mag3[coIdx3]) {
				idx3 += -dir;
				if(idx3 < 0) {
					idx3 += 8;
				}
				coIdx3 = (coIdx3 + 4) % 8;
				int coIdx4 = (idx4 + 6) % 8;
				if(mag3[coIdx3] != mag4[coIdx4]) {
					idx4 += dir;
					if(idx4 < 0) {
						idx4 += 8;
					}
				}
			}
			
		} else if(num == 3){
			
			int coIdx3 = (idx3 + 2) % 8;
			idx3 += dir;
			if(idx3 < 0) {
				idx3 += 8;
			}
			int coIdx4 = (idx4 + 6) % 8;
			if(mag3[coIdx3] != mag4[coIdx4]) {
				idx4 += -dir;
				if(idx4 < 0) {
					idx4 += 8;
				}
			}
			
			coIdx3 = (coIdx3 + 4) % 8;
			int coIdx2 = (idx2 + 2) % 8;
			if(mag3[coIdx3] != mag2[coIdx2]) {
				
				idx2 += -dir;
				if(idx2 < 0) {
					idx2 += 8;
				}
				
				coIdx2 = (coIdx2 + 4) % 8;
				int coIdx1 = (idx1 + 2) % 8;
				if(mag1[coIdx1] != mag2[coIdx2]) {
					idx1 += dir;
					if(idx1 < 0) {
						idx1 += 8;
					}
				}
				
			}
			
		} else {
			
			int coIdx4 = (idx4 + 6) % 8;
			idx4 += dir;
			if(idx4 < 0) {
				idx4 += 8;
			}
			int coIdx3 = (idx3 + 2) % 8;
			if(mag3[coIdx3] != mag4[coIdx4]) {
				idx3 += -dir;
				if(idx3 < 0) {
					idx3 += 8;
				}
				coIdx3 = (coIdx3 + 4) % 8;
				int coIdx2 = (idx2 + 2) % 8;
				if(mag2[coIdx2] != mag3[coIdx3]) {
					idx2 += dir;
					if(idx2 < 0) {
						idx2 += 8;
					}
					coIdx2 = (coIdx2 + 4) % 8;
					int coIdx1 = (idx1 + 2) % 8;
					if(mag1[coIdx1] != mag2[coIdx2]) {
						idx1 += -dir;
						if(idx1 < 0) {
							idx1 += 8;
						}
					}
				}
			}
			
		}
		
	}
	
	static void input() throws IOException{
		mag1 = new int[8];
		mag2 = new int[8];
		mag3 = new int[8];
		mag4 = new int[8];
		idx1 = 0;
		idx2 = 0;
		idx3 = 0;
		idx4 = 0;
		
		String input = br.readLine();
		for(int i=0; i<8; i++) {
			mag1[i] = input.charAt(i)-'0';
		}
		
		input = br.readLine();
		for(int i=0; i<8; i++) {
			mag2[i] = input.charAt(i)-'0';
		}
		
		input = br.readLine();
		for(int i=0; i<8; i++) {
			mag3[i] = input.charAt(i)-'0';
		}
		
		input = br.readLine();
		for(int i=0; i<8; i++) {
			mag4[i] = input.charAt(i)-'0';
		}
	}
	
	
}
