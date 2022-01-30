package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] countArr = new int[10001];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            countArr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 0) {
                continue;
            }

            for (int j = 0; j < countArr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
