package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA_D4_사친연산 유효성 검사
 * @author mingggkeee
 * 루트 번호는 반드시 1
 */

public class SWEA_사칙연산유효성검사 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// 테스트케이스는 10번
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean isValid = true;
			bw.write("#"+t+" ");
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				// 숫자가 들어가면 자식 X
				// 연산이 들어가면 자식 O
				char temp = st.nextToken().charAt(0);
				// 자식이 있을 때
				if(st.hasMoreTokens()) {
					if(temp >= '0' && temp < '9')
						isValid = false;
				}
				// 자식이 없을 때
				else {
					if(temp < '0' || temp > '9')
						isValid = false;
				}
			}
			
			if(isValid == false) 
				bw.write(0+"\n");
			else 
				bw.write(1+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
public class SWEA_사칙연산유효성검사 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// 테스트케이스는 10번
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());	// 정점의 총 수
			Tree tree = new Tree(N);
			int count = 0;
			if(N%2==0) {
				for(int i=0; i<N/2; i++) {
					st = new StringTokenizer(br.readLine());
					st.nextToken();
					tree.add(st.nextToken());
					st.nextToken();
					if(i!=N/2-1)
						st.nextToken();
				}
			} else {
				for(int i=0; i<N/2; i++) {
					st = new StringTokenizer(br.readLine());
					st.nextToken();
					tree.add(st.nextToken());
					st.nextToken();
					st.nextToken();
				}
			}
			for(int i=N/2; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String temp = st.nextToken();
				try {
					int trash = Integer.parseInt(temp);
				} catch (NumberFormatException e) {
					count++;
				}
				tree.add(temp);
			}
			
			if(count == 0) {
				bw.write("#"+t+" "+1+"\n");
			} else {
				bw.write("#"+t+" "+0+"\n");
			}
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static class Tree{
		
		private String[] nodes;
		private final int SIZE;
		private int lastIndex;
		
		public Tree(int size) {
			nodes = new String[size+1];	// 1부터 시작
			SIZE = size;
		}
		
		public boolean isEmpty() {
			return lastIndex==0;
		}
		
		public boolean isFull() {
			return lastIndex==SIZE;
		}
		
		public void add(String c) {
			if(isFull()) {
				return;
			}
			nodes[++lastIndex] = c;
		}
		
	}
}
*/