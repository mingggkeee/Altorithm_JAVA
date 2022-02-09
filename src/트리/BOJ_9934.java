package 트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ_9934_S1_완전 이진 트리
 * @author mingggkeee
 * 트리
 */

public class BOJ_9934 {
	
	static int level;
	static int [] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer[] answer;
	
	public static void main(String[] args) throws IOException{

		
		level = Integer.parseInt(br.readLine());
		arr = new int[(int)Math.pow(2, level) - 1];	// 2의 level승 -1 만큼 노드가 만들어진다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new StringBuffer[level];
		for(int i=0; i<level; i++) {
			answer[i] = new StringBuffer();
		}
		
		tree(0,arr.length-1,0);
		
		for(int i=0; i<level; i++) {
			bw.write(answer[i].toString() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void tree(int left, int right, int cnt){
		if(cnt==level) {
			return;
		}
		int half = (left + right) / 2;
		answer[cnt].append(arr[half] + " ");
		
		tree(left, half-1, cnt+1);
		tree(half+1, right, cnt+1);
	}
}
