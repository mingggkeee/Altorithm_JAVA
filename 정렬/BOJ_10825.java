package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_10825_S4_국영수
 * @author mingggkeee
 * 정렬
 */

public class BOJ_10825 {

	static class Info implements Comparable<Info>{
		
		String name;
		int korean;
		int english;
		int math;
		
		public Info(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Info o) {
			
			if(this.korean==o.korean) {
				
				if(this.english == o.english) {
					
					if(this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					
					return o.math-this.math;
				}
				
				return this.english-o.english;
			}
			
			
			return o.korean-this.korean;
		}
		
		
		
	}
	
	static int N;
	static Info[] inputs;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		inputs = new Info[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			inputs[i] = new Info(name, korean, english, math);

		}
		
		Arrays.sort(inputs);
		
		for(int i=0; i<N; i++) {
			System.out.println(inputs[i].name);
		}
		
	}
}
