package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ_1786_P5_찾기
 * @author mingggkeee
 * KMP
 */

public class BOJ_1786 {
	
	static List<Integer> list;
	static int cnt;
	
	static int[] getPi(String sub) {
		int[] pi = new int[sub.length()];
		int j=0;
		for(int i=1; i<sub.length(); i++) {
			while(j>0 && sub.charAt(i)!=sub.charAt(j)) {
				j = pi[j-1];
			}
			if(sub.charAt(i) == sub.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	static void kmp(String origin, String sub) {
		int pi[] = getPi(sub);
		int j=0;
		for(int i=0;i<origin.length();i++) {
			while(j>0 && origin.charAt(i)!=sub.charAt(j)) {
				j = pi[j-1];
			}
			if(origin.charAt(i)==sub.charAt(j)) {
				if(j==sub.length()-1) {
					++cnt;
					list.add(i-j+1);
					j=pi[j];
				}
				else
					j++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String sub = br.readLine();
		list = new ArrayList<>();
		kmp(origin, sub);
		System.out.println(cnt);
		for(int i=0; i<cnt; i++) {
			System.out.println(list.get(i));
		}
	}

}
