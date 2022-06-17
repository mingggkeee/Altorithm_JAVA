package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_1208_G1_부분수열의 합 2
 * @Author mingggkeee
 * @Date 2022. 6. 17.
 * @Category : 이분탐색
 */

public class BOJ_1208 {

	static int N, S;
	static long count;
	static List<Integer> left = new ArrayList<>();
	static List<Integer> right = new ArrayList<>();
	static int[] arr;
	
	static void makeSum(int sum, int start, int end, List<Integer> list) {
		if(start == end) {
			list.add(sum);
			return;
		}
		makeSum(sum, start+1, end, list);
		makeSum(sum+arr[start], start+1, end, list);
	}
	
	static void calc() {
		int pointerL = 0;
		int pointerR = right.size()-1;
		
		while(true) {
			if(pointerL == left.size() || pointerR < 0) {
				break;
			}
			int lv = left.get(pointerL);
			int rv = right.get(pointerR);
			
			// 합이 목적 값과 같으면 합을 이루고 있는 각 수가 list 내에 몇개 있는지 센다. 
			if(lv + rv == S) {
				long lc = 0;
				while(pointerL < left.size() && left.get(pointerL) == lv) {
					lc++;
					pointerL++;
				}
				
				long rc = 0;
				while(0 <= pointerR && right.get(pointerR) == rv) {
					rc++;
					pointerR--;
				}
				count += lc * rc;
			}
			
			// 목적하는 값보다 더 큰 경우
			if(lv + rv > S) {
				pointerR--;
			}
			
			// 목적하는 값보다 더 작은 경우 
			if(lv + rv < S) {
				pointerL++;
			}
			
			
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSum(0, 0, N/2, left);
		makeSum(0, N/2, N, right);
		
		
		Collections.sort(left);
		Collections.sort(right);
		
		count = 0;
		calc();
		
		if(S == 0) {
			System.out.println(count - 1);
		}else {
			System.out.println(count);
		}
	}
	
}
