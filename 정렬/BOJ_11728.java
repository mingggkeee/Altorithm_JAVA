package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ_11728_S5_배열 합치기
 * @author mingggkeee
 * 정렬
 */

public class BOJ_11728 {
	
	static int N,M;
	static int[] nums1, nums2, nums;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums1 = new int[N];
		nums2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			nums2[i] = Integer.parseInt(st.nextToken());
		}
		
		nums = new int[N+M];
		
		int idx1 = 0;
		int idx2 = 0;
		int idx = 0;
		
		while(true) {
			if(idx==N+M) {
				break;
			}
			
			if(idx1<N && idx2<M &&nums1[idx1] > nums2[idx2]) {
				nums[idx++] = nums2[idx2++];
			} 
			else if(idx2<M && idx1<N &&nums2[idx2] > nums1[idx1]){
				nums[idx++] = nums1[idx1++];
			}
			else if(idx1>=N && idx2<M) {
				nums[idx++] = nums2[idx2++];
			}
			else {
				nums[idx++] = nums1[idx1++];
			}
			
		}
		
		for(int i=0; i<nums.length; i++) {
			bw.write(nums[i]+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
}
