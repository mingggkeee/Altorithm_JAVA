package SWEA;

import java.util.Scanner;

/**
 * SWEA_4047_D3_영준이의 카드 카운팅
 * @author mingggkeee
 * S : 0, D : 1, H : 2, C : 3
 */

public class SWEA_4047 {
	
	static boolean [][] having;
	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		sc.nextLine();
		
		for(int t=1; t<=T; t++) {
			
			having = new boolean[4][14];	// 1~13, 4종류
			
			String input = sc.nextLine();
			boolean dupli = false;
			
			for(int i=0; i<input.length(); i++) {
				int num = 0;
				char type = input.charAt(i++);
				num += (input.charAt(i++) - '0')*10;
				num += input.charAt(i) - '0';
				
				if(type=='S') {
					if(having[0][num]) {
						dupli = true;
					}
					
					having[0][num] = true;
					
				} else if(type=='D') {
					if(having[1][num]) {
						dupli = true;
					}
					
					having[1][num] = true;
					
				} else if(type=='H') {
					if(having[2][num]) {
						dupli = true;
					}
					
					having[2][num] = true;
				} else {
					if(having[3][num]) {
						dupli = true;
					}
					
					having[3][num] = true;
				}
				
			}
			
			if(dupli) {
				System.out.println("#"+t+" ERROR");
			} else {
				
				System.out.print("#"+t+" ");
				
				for(int i=0; i<4; i++) {
					int count = 0;
					for(int j=1; j<=13; j++) {
						if(!having[i][j])
							count++;
					}
					System.out.print(count+" ");
				}
				
				System.out.println();
				
			}
			
			
			
			
		}
		
		sc.close();
	}

}
