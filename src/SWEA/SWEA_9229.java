package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229 {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int answer = -1; // 정답출력용 변수
			st = new StringTokenizer(br.readLine()); // 과자 봉지 개수와 무게 합 제한 입력받기
			int N = Integer.parseInt(st.nextToken()); // 봉지 개수
			int M = Integer.parseInt(st.nextToken()); // 무게 제한
			st = new StringTokenizer(br.readLine()); // 과자 봉지들의 무게
			int [] weight = new int[N];
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
			for(int i=0; i<N; i++) {
				int temp = weight[i];
				for(int j=i+1; j<N; j++) {
					if(temp + weight[j] <= M) {
						answer = Math.max(answer, temp+weight[j]);
					}
				}
			}
			
			
			bw.write("#"+t+" "+answer+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
