package 그리디;

import java.io.*;
import java.util.*;

/**
 * BOJ_13904_G3_과제
 * @author USER
 * 그리디
 */
public class BOJ_13904 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		List<Homework> list = new ArrayList<>();
		int maxDay = 0;	// 가장 남은 일수가 많은 과제부터 처리하기

		for (int i = 0; i < N; i++) {

			String[] input = br.readLine().split(" ");
			int d = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);

			list.add(new Homework(d, w));
			maxDay = Math.max(maxDay, d);
		}

		int answer = 0;

		for (int i = maxDay; i >= 1; i--) {

			Homework ans = new Homework(0, 0);

			for (Homework hw : list) {
				if (hw.d >= i) {
					if (ans.w < hw.w) {
						ans = hw;
					}
				}
			}

			answer += ans.w;
			list.remove(ans);
		}

		bw.write(answer + "\n");
		bw.flush();

	}

	static class Homework {

		int d, w;	// 남은 일수와 점수

		Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}

	}

}
