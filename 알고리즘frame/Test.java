package 알고리즘frame;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			double x = sc.nextInt();
			double y = sc.nextInt();
			double h = 1;
			double answer = 0;
			if(x>=y) {
				while(h<y/2) {
					double nx = x - 2*h;
					double ny = y - 2*h;
					double temp = nx*ny*h;
					answer = Math.max(temp, answer);
					h+=1;
				}
				
			} else {
				while(h<x/2) {
					double nx = x - 2*h;
					double ny = y - 2*h;
					double temp = nx*ny*h;
					answer = Math.max(temp, answer);
					h+=1;
				}
			}
			
			
			answer = x*y*h;
			
			System.out.println("#"+tc+" "+answer);
		}
		
		sc.close();
	}

}
