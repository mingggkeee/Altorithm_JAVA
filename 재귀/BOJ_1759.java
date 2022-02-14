package 재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * BOJ_1759_G5_암호 만들기
 * @author "mingggkeee"
 * 조합 문제
 */

public class BOJ_1759 {
	
	static int L,C;
	static char[] alpha, temp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedHashSet<String> answer;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());	// 뽑아야하는 문자 개수 즉 L사이즈의 단어
		C = Integer.parseInt(st.nextToken());	// 입력 문자의 수
		alpha = new char[C];
		temp = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			String alphabet = st.nextToken();
			alpha[i] = alphabet.charAt(0);
		}
		Arrays.sort(alpha);
		answer = new LinkedHashSet<String>();
		
		combi(0, 0);
		
		for(String str : answer) {
			bw.write(str+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void combi(int cnt, int start) throws IOException {
		if(cnt==L) {
			String word = "";
			int vowels = 0;		// 모음
			int consonants = 0; // 자음
			for(char a : temp) {
				if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u') {
					vowels++;
				} else {
					consonants++;
				}
				word += a;
			}
			if(vowels>=1 && consonants>=2)
				answer.add(word);
			return;
		}
		
		for(int i=start; i<C; i++) {
			temp[cnt] = alpha[i];
			combi(cnt+1, i+1);
		}
	}

}
