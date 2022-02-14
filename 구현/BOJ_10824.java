package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10824 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a1 = st.nextToken();
		String a2 = st.nextToken();
		String b1 = st.nextToken();
		String b2 = st.nextToken();
		long num1 = Long.parseLong(a1+a2);
		long num2 = Long.parseLong(b1+b2);
		System.out.println(num1+num2);
		br.close();
	}

}
