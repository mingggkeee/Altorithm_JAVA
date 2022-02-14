package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ_2564_S1_경비원
 * @author mingggkeee
 * 구현  직사각형을 직선으로 펴보자
 */
public class BOJ_2564 {
	
	static int C, R;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());	// 가로의 길이
		R = Integer.parseInt(st.nextToken());	// 세로의 길이
		
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int totalLength = (C + R) * 2;
		
		// 동근이까지 해야해서 <=N
		for(int t=0; t<=N; t++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			
			switch(dir) {
			case 1:
				list.add(position);
				break;
			case 2:
				list.add(C+R+(C - position));
				break;
			case 3:
				list.add(2*C+R+(R-position));
				break;
			case 4:
				list.add(C + position);
			}
		}
		
		int person = list.get(list.size()-1);	// 동근이 위치
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			int temp = Math.abs(list.get(i) - person);
			answer += Math.min(temp, totalLength-temp);
		}
		
		bw.write(answer+"\n");
		
		bw.flush();
		br.close();
		bw.close();
	}

}
