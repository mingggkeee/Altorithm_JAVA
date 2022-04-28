package 알고리즘frame;

import java.util.Arrays;
import java.util.Scanner;

/**
 * nPr
 * n개의 수 입력받아 처리
 */
public class PermutationTest {
	
	static int N,R;
	static int[] input, numbers; // input : 입력수배열, numbers : 선택수배열
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0, 0);
		
		sc.close();
	}
	
	// 현재 자리의 수 뽑기
	public static void permutation(int cnt, int flag) {	// cnt : 직전까지 뽑은 수 개수, flag : 뽑힌 수들에 대한 플래그비트열
		
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 입력받은 모든 수를 현재 자리에 넣어보기
		for (int i = 0; i < N; i++) {
			// 기존자리의 수들과 중복되는지 체크
			if((flag & 1<<i) !=0 ) continue;
			
			numbers[cnt] = input[i];
			
			permutation(cnt+1, flag | 1<<i);
		}
	}
}
