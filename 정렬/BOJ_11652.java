package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long []card = new long[N];
		int cntM = 1;
		int cnt = 1;
		for(int i=0; i<N; i++) {
			card[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(card);
		
		long num = card[0];
		for(int i=1; i<N; i++) {
			if(card[i-1] == card[i]) {
				cnt++;
			}
			else
				cnt = 1;
			if(cntM<cnt) {
				cntM = cnt;
				num = card[i];
			}
		}
		
		bw.write(Long.toString(num));
		br.close();
		bw.flush();
		bw.close();
	}
}
