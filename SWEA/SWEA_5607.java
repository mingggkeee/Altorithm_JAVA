package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_5607_D3_조합
 * @Author mingggkeee
 * @Date 2022. 4. 11.
 * @Category : 페르마의 소 정리
 */

public class SWEA_5607 {
	
	static int mod = 1234567891;
	static int N, R, T;
	static long[] factorial;
	static long answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		factorial = new long[1000001];
		factorial[0] = 1;
		for(int i=1; i<=1000000; i++) {
			factorial[i] = (factorial[i-1] * i) % mod;
		}
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			answer = (factorial[N] * powCalc((factorial[R]*factorial[N-R])%1234567891, 1234567891-2))%1234567891;
			
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	static long powCalc(long x, long a) {
		if(a==0) {
			return 1;
		}
		long val = powCalc(x, a/2);
		long nextVal = (val * val) % 1234567891;
		if(a % 2 == 0) {
			return nextVal;
		} else {
			return (nextVal * x) % 1234567891;
		}
	}

}
