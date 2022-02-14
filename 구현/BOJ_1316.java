package 구현;

import java.util.Scanner;

public class BOJ_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int answer = 0;
		for(int t=0; t<T; t++) {
			int[] arr = new int[26];
			String input = sc.nextLine();
			char c = input.charAt(0);
			arr[c-97]++;
			int cnt = 0;
			for(int i=1; i<input.length(); i++) {
				if(c==input.charAt(i)) {
					continue;
				} else {
					if(arr[input.charAt(i)-97]!=0) {
						cnt++;
						break;
					}
					else {
						arr[input.charAt(i)-97]++;
						c = input.charAt(i);
					}
				}
			}
			if(cnt==0) {
				answer++;
			}
			
		}
		System.out.println(answer);
		sc.close();
	}
}

