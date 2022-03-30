package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ_1377_G2_버블 소트
 * @author mingggkeee
 * 정렬
 * 더 이상 정렬이 발생하지 않는 인덱스를 구하기. 앞쪽 칸으로 많이 이동한 숫자의 인덱스가 정답..
 */

public class BOJ_1377 {
	
	static class Point implements Comparable<Point>{
		
		int num;
		int idx;
		
		public Point(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return num - o.num;
		}
		
	}
	
	static int N;
	static Point[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new Point[N+1];
		
		for(int i=1; i<=N; i++) {
			nums[i] = new Point(Integer.parseInt(br.readLine()), i);
		}
		
		// 숫자를 기준으로 오름차순 정렬
		Arrays.sort(nums, 1, N+1);
		
		int max = 0;
		// 해당 숫자의 인덱스가 몇 칸 움직였는지 확인 가능
		for(int i=1; i<=N; i++) {
			max = Math.max(max, nums[i].idx-i);
		}
		
		System.out.println(max+1);
	}

}
