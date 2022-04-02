package ShowMeTheCode_원티드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_숫자이어붙이기 {
	
	static int N, Q;
	static String[] nums;
	static int[] parents;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		nums = new String[N];
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = st.nextToken();
		}
		
		for(int i=0; i<N-1; i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			list[from].add(to);
			list[to].add(from);
			
		}
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			boolean[] isVisited = new boolean[N];
			isVisited[start] = true;
			String answer = "";
			
			while(true) {
				if(start==end) {
					answer += nums[start];
					break;
				}
				
				answer += nums[start];
				
				for(int j=0; j<list[start].size(); j++) {
					if(!isVisited[list[start].get(j)]) {
						isVisited[list[start].get(j)] = true;
						start = list[start].get(j);
						break;
					}
				}
				
				
				
			}
			
			BigInteger a = new BigInteger(answer);
			BigInteger b = new BigInteger("1000000007");
			bw.write(a.remainder(b)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
