package 재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ_15652_S3_N과 M(4)
 * @author "mingggkeee"
 * 중복조합
 */
public class BOJ_15652 {
	
	static int n,m;
	static int[] numbers;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		
		combi(0, 1);
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void combi(int cnt, int start) throws IOException{
		if (cnt == m) {
			for(int i : numbers) {
				bw.write(i + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i);
		}
	}
}
