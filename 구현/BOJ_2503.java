package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_2503_S4_숫자 야구
 * @author mingggkeee
 * 구현, 브루트포스, 순열
 */

public class BOJ_2503 {
	
	static int N;
	static int strike[], ball[];
	static int [] nums = {1,2,3,4,5,6,7,8,9};
	static String inputs[];
	static int [] numbers;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		strike = new int[N];
		ball = new int[N];
		inputs = new String[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			inputs[i] = st.nextToken();
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}
		
		numbers = new int[9];
		
		for(int i=0; i<9; i++) {
			numbers[i] = i;
		}
		
		permu(numbers, 0);
		
		System.out.println(count);
		
	}
	
	public static void permu(int[] numbers, int cnt) {
		
		if(cnt == 3) {
			String str = "";
			for(int i=0; i<cnt; i++) {
				str += Integer.toString(nums[numbers[i]]);
			}
			if(check(str)) count++;
			return;
		}
		
		for(int i=cnt; i<9; i++) {
			swap(numbers, i, cnt);
			permu(numbers, cnt+1);
			swap(numbers, i, cnt);
		}
	}
	
	public static boolean check(String str) {
		String[] check = str.split("");
		
		for(int i=0; i<N; i++) {
			String[] check2 = inputs[i].split("");
			int s = 0;
			int b = 0;
			
			for(int j=0; j<check.length; j++) {
				if(check[j].equals(check2[j]))
					s++;
			}
			
			for(int j=0; j<check.length; j++) {
				for(int m=0; m<check2.length; m++) {
					if(j==m)
						continue;
					else {
						if(check[j].equals(check2[m]))
							b++;
					}
				}
			}
			
			if(strike[i] != s || ball[i] != b) {
				return false;
			}
		}
		return true;
	}
	
	public static void swap(int[] numbers, int i, int index) {
		int temp = numbers[i];
		numbers[i] = numbers[index];
		numbers[index] = temp;
	}
	
}
