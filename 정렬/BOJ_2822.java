package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

/**
 * BOJ_2822_S5_점수 계산
 * @author mingggkeee
 * 정렬
 */

public class BOJ_2822 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[8];
		Integer[] sortArr = new Integer[8];
		
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sortArr[i] = arr[i];
		}
		
		Arrays.sort(sortArr, Collections.reverseOrder());
		int answer = 0;
		for(int i=0; i<5; i++) {
			answer += sortArr[i];
		}
		
		bw.write(answer+"\n");
		
		for(int i=0; i<8; i++) {
			int num = arr[i];
			for(int j=0; j<5; j++) {
				if(num==sortArr[j]) {
					bw.write((i+1)+" ");
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
