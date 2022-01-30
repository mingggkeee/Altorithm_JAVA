package 스택과큐;

import java.util.*;
import java.io.*;

public class BOJ_9093 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		Stack<Character> stack = new Stack<Character>();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t=0; t<T; t++) {
			String input = bf.readLine()+"\n";
			for(char c : input.toCharArray()) {
				if(c == ' ' || c == '\n') {
					while(!stack.isEmpty()) {
						bw.write(stack.pop());
					}
					bw.write(c);
				} else
					stack.push(c);
			}
		}
		bw.close();
		bf.close();
	}
	/*
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<T; i++) {
			Stack<Character> st = new Stack<>();
			String line = sc.nextLine();
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == ' ') {
					while (!st.empty()) {
						System.out.print(st.pop());
					}
					System.out.print(" ");
				} else {
					st.push(line.charAt(j));
				}
			}
			while(!st.empty()) {
				System.out.print(st.pop());
			}
			System.out.println();
		}
		sc.close();
	}*/
}
