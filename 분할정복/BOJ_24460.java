package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_24460_S3_특별상이라도 받고 싶어
 * @Author mingggkeee
 * @Date 2022. 4. 7.
 * @Category : 분할정복
 */

public class BOJ_24460 {

	static int N, count;
	static int[][] map;
	static int[] arr, arr2;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new int[4];
		System.out.println(divide(0,0,N));

	}
	
	static int divide(int r, int c, int size) {
		if(size==1) {
			return map[r][c];
		} else {
			arr[0] = divide(r,c,size/2);
			arr[1] = divide(r,c+size/2,size/2);
			arr[2] = divide(r+size/2,c,size/2);
			arr[3] = divide(r+size/2,c+size/2,size/2);
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
			return arr[1];
		}
		
	}
	
}
