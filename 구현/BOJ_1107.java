package 구현;

import java.util.Scanner;

/**
 * BOJ_1107_G5_로그인
 * @author mingggkeee
 * 구현
 */

public class BOJ_1107 {

	static int current = 100;
	static int target;
	static boolean[] isBreak;
	static int answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		target = sc.nextInt();
		int N = sc.nextInt();
		
		isBreak = new boolean[10];
		
		for(int i=0; i<N; i++) {
			isBreak[sc.nextInt()] = true;
		}
		
		answer = Math.abs(target - current);
		
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean check = false;
            for(int j = 0; j < len; j++) {
                if(isBreak[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                    check = true; 
                    break; 
                }
            }
            if(!check) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                answer = Math.min(min, answer);
            }
        }        
        System.out.println(answer);
		
		sc.close();
		
	}
	
}
