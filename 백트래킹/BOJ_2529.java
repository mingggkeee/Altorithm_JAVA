package 백트래킹;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_2529_S2_부등호
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_2529 {

	static int K; 
	static boolean[] isVisited = new boolean[10]; // 중복숫자불가
	static char[] signs; 
	private static List<String> list = new ArrayList<>(); 
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		K = sc.nextInt(); 
		signs = new char[K]; 
		for (int i = 0; i < K; i++) { 
			signs[i] = sc.next().charAt(0); 
		} 
		dfs("", 0); 
		Collections.sort(list); 
		System.out.println(list.get(list.size() - 1)); //최댓값 
		System.out.println(list.get(0)); //최솟값 
		
		sc.close();
	} 
	
	
	static void dfs(String num, int depth) { //처음 nums를 int[]로 접근했는데 String으로 하는게 간단해진다. 
		if (depth == K + 1) { 
			list.add(num); 
			return; 
		} 
		
		for (int i = 0; i <= 9; i++) { 
			if (depth == 0 || !isVisited[i] && compare(num.charAt(num.length() - 1) - '0', i, signs[depth - 1])) { //처음건 비교할게없으므로 통과 || 방문안한숫자 && 비교 
				isVisited[i] = true; 
				dfs(num + i, depth + 1); 
				isVisited[i] = false; 
			} 
		} 
	} 
	
	static boolean compare(int a, int b, char c) { 
		if (c == '<') 
			return a < b; 
		else 
			return a > b; 
	}

}
