package 정렬;

import java.util.Arrays;
import java.util.Scanner;

/**
 * BOJ_14469_S4_소가 길을 건너간 이유 3
 * @Author mingggkeee
 * @Date 2022. 5. 6.
 * @Category : 정렬
 */

public class BOJ_14469 {
	
	static class Cow implements Comparable<Cow>{
		int getIn;
		int time;
		
		public Cow(int getIn, int time) {
			this.getIn = getIn;
			this.time = time;
		}

		@Override
		public int compareTo(Cow o) {
			return getIn-o.getIn;
		}
		
		
	}

	static Cow[] info;
	static int N, answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		info = new Cow[N];
		
		for(int i=0; i<N; i++) {
			info[i] = new Cow(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(info);
		
		for(int i=0; i<N; i++) {
			int in = info[i].getIn;
			if(answer < in) {
				answer = in;
			}
			answer += info[i].time;
		}
		
		
		System.out.println(answer);
		sc.close();
		
	}
	
}
