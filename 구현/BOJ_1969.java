package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1969_S5_DNA
 * @author mingggkeee
 * 구현, 문자열
 * A, T, G, C
 */

public class BOJ_1969 {
	
	static int N,M;
	static String [] inputs;
	static int answer;
	static int [] counting;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new String[N];
		
		for(int i=0; i<N; i++) {
			inputs[i] = br.readLine();
		}
		
		String sentence = "";
		
		for(int i=0; i<inputs[0].length(); i++) {
			counting = new int[4];
			for(int j=0; j<N; j++) {
				char temp = inputs[j].charAt(i);
				if(temp == 'A') {
					counting[0]++;
				} else if(temp == 'C') {
					counting[1]++;
				} else if(temp == 'G') {
					counting[2]++;
				} else {
					counting[3]++;
				}
			}
			int saveIdx = -1;
			int compare = -1;
			for(int c=0; c<4; c++) {
				if(compare < counting[c]) {
					compare = counting[c];
					saveIdx = c;		
				}
				answer += counting[c];
			}
			
			answer -= counting[saveIdx];
			switch (saveIdx) {
			case 0:
				sentence+='A';
				break;
			
			case 1:
				sentence+='C';
				break;
			case 2:
				sentence+='G';
				break;
			case 3:
				sentence+='T';
				break;


			}
			
			
		}
		
		System.out.println(sentence);
		System.out.println(answer);
		
	}
	


}
