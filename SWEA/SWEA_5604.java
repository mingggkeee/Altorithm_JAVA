package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_5604_D4_구간 합
 * @Author mingggkeee
 * @Date 2022. 4. 12.
 * @Category :
 */
public class SWEA_5604 {

	static int T;
	static long answer, digit, start, end;
	static long[] numbers;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			
			numbers = new long[10];
			answer = 0;
			digit = 1;	// 1의자리수부터 
			
			if(start == 0) {
				start = 1;
			}
			
			while(start<=end) {
				
				while(start%10 != 0 && start<=end) {
					calcNum(start);
					start++;
				}
				
				if(start > end) {
					break;
				}
				
				while(end%10 != 9 && start<=end) {
					calcNum(end);
					end--;
				}
				
				long diff = (end / 10) - (start / 10) + 1;
				for(int i=0; i<10; i++) {
					numbers[i] += diff * digit;
				}
				
				digit *= 10;
				start /= 10;
				end /= 10;
				
			}
			
			for(int i=1; i<10; i++) {
				answer += i * numbers[i];
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void calcNum(long num) {
		for(long i = num; i > 0; i/=10) {
			String s = Long.toString(i);
			
			int temp = s.charAt(s.length()-1)-'0';	// 끝자리 저장
			numbers[temp] += digit;
		}
	}
	

}
