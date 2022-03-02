package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ_1422_P4_숫자의 신
 * @author mingggkeee
 * 그리디, 정렬
 */

public class BOJ_1422 {

    static int K,N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        String[] nums = new String[K];
        max = Integer.MIN_VALUE;

        for(int i=0; i<K; i++){
            nums[i] = br.readLine();
            max = Integer.max(max, Integer.parseInt(nums[i]));
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        boolean chk = true;

        StringBuilder sb = new StringBuilder();

        for(String n : nums){
            sb.append(n);
            if(max == Integer.parseInt(n) && chk){
                for(int i=K; i<N; i++){
                    sb.append(n);
                    chk = false;
                }
            }
        }

        System.out.println(sb);
    }
}
