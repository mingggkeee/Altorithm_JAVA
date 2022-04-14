package DP;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ_14002_G4_가장 긴 증가하는 부분 수열 4
 * @Author mingggkeee
 * @Date 2022. 4. 14.
 * @Category : dp
 */

public class BOJ_14002 {
	
	static int N;
	static int[] dp, nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }


        // 역추적

        // 최장길이값
        int value = ans;
        Stack<Integer> stack = new Stack<>();

        for (int i = N; i >= 1; i--) {
            if (value == dp[i]) {
                stack.push(nums[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(ans);
        System.out.println(sb);

    }
	
}
