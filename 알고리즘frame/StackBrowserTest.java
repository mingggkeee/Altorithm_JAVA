package 알고리즘frame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackBrowserTest {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> backward = new Stack<String>();
		Stack<String> forward = new Stack<String>();
		
		String current = "http://www.ssafy.com";
		
		while(true) {
			String input = br.readLine();
			if(input.charAt(0)=='Q') {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(input);
			
			switch(st.nextToken()) {
			
			case "V":	// 방문처리
				backward.push(current);
				forward.clear();
				current = st.nextToken();
				System.out.println(current);
				break;
				
			case "B":
				if(!backward.isEmpty()) {
					forward.push(current);
					current = backward.pop();
				} else {
					System.out.println("Ignored");
					continue;
				}
				break;
				
			case "F":
				if(!forward.isEmpty()) {
					backward.push(current);
					current = forward.pop();
				} else {
					System.out.println("Ignored");
					continue;
				}
				break;
			
			}
		}

	}

}
