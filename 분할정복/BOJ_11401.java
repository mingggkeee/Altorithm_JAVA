package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_11404_G1_이항 계수 3
 * @Author mingggkeee
 * @Date 2022. 4. 11.
 * @Category : 분할정복, 페르마의 소 정리, 조합론
 */

public class BOJ_11401 {
	
	static int N, K;
	static int mod = 1000000007;
	static long[] factorial;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		factorial = new long[4000001];
		factorial[0] = 1;
		for(int i=1; i<=4000000; i++) {
			factorial[i] = (factorial[i-1] * i) % mod;
		}
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long answer = (factorial[N] * powCalc((factorial[K] * factorial[N-K]) % mod, mod-2))%mod;
		
		System.out.println(answer);
	}
	
	static long powCalc(long x, long a) {
		if(a==0) {
			return 1;
		}
		long val = powCalc(x, a/2);
		long nextVal = (val * val) % mod;
		if(a % 2 == 0) {
			return nextVal;
		} else {
			return (nextVal * x) % mod;
		}
	}

}
