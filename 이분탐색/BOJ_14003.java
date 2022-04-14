package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ_14003_P5_가장 긴 증가하는 부분 수열 5
 * @Author mingggkeee
 * @Date 2022. 4. 14.
 * @Category : 이분탐색, 스택
 */
public class BOJ_14003 {
	static int[] memo;
	static int INF = Integer.MIN_VALUE;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		memo = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			
			if(list.get(list.size()-1) < nums[i]) {
				list.add(nums[i]);
				memo[i] = list.size()-1;
			} else {
				int left = 1;
				int right = list.size()-1;
				
				while(left < right) {
					int mid = (left + right) / 2;
					if(list.get(mid) < nums[i]) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				
				list.set(right, nums[i]);
				
				memo[i] = right;
			}
			
		}
		
		
		System.out.println(list.size()-1);
		
        int value = list.size()-1;
        Stack<Integer> stack = new Stack<>();

        for (int i = N-1; i >= 0; i--) {
            if (value == memo[i]) {
                stack.push(nums[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

	}
}
