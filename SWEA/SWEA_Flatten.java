package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_Flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=1; i<=10; i++) {
			int dump = Integer.parseInt(br.readLine());
			int [] arr = new int[100];
			st = new StringTokenizer(br.readLine()," ");
			for(int k=0; k<100; k++) {
				arr[k] = Integer.parseInt(st.nextToken());
			}
			for(int d=0; d<dump; d++) {
				Arrays.sort(arr);
				arr[0] += 1;
				arr[99] -= 1;
			}
			Arrays.sort(arr);
			int sub = arr[99] - arr[0];
			System.out.println("#"+i+" "+sub);
		}
	}
}
