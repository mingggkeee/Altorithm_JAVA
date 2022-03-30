package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_24885_G4_주식
 * @author mingggkeee
 * 구현, 시뮬레이션
 */
public class BOJ_24885 {
	
	static int N;
	static long M, K;
	static long[] prices;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		prices = new long[N];
		for(int i=0; i<N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		long stock = 0;
		long loan = 0;
		long save = 0;
		
		for(int i=0; i<N-1; i++) {
			
//			System.out.print(stock+" "+M+" "+loan+" ");
			
			if(stock != 0) {
				
				M = M + (prices[i]*stock);
				M -= loan;
				stock = 0;
				save = loan;
				loan = 0;
			}
			
//			System.out.println(stock+" "+M+" "+loan);
			
			if(prices[i] < prices[i+1]) {
				
				loan = M * K;
				M = M + M*K;
				if(M / prices[i] == 0) {
					M -= loan;
					loan = 0;
				}
				else {
					stock = M / prices[i];
					M = M % prices[i];
				}
				
			}
			
		}
		
		if(stock!=0) {
//			System.out.println(stock+" "+M+" "+loan);
			M = M + (prices[N-1]*stock);
			stock = 0;
			
		} else {
			M += save;
		}
		

		System.out.println(M);
		
	}

}
