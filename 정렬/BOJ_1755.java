package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * BOJ_1755_S4_숫자놀이
 * @Author mingggkeee
 * @Date 2022. 4. 25.
 * @Category : 정렬
 */

public class BOJ_1755 {
	
	static int start, end;
	static String[] nums;
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		nums = new String[end-start+1];	// 입력 배열
		ans = new int[end-start+1];	// 출력 배열
		
		// 입력받기
		for(int i=start, j=0; i<=end; i++) {
			nums[j++] = convertString(i);
		}
		
		Arrays.sort(nums);	// 사전순으로 정렬
		
		for(int i=0; i<end-start+1; i++) {
			int num = convertInt(nums[i]);
			ans[i] = num;
		}
		
		// 결과 출력해주기
		for(int i=0; i<ans.length; i++) {
			if(i!=0 && i%10 == 0) {
				System.out.println();
			}
			
			System.out.print(ans[i]+" ");
		}
		
	}
	
	// 단어를 숫자로 바꾸기
	static int convertInt(String res) {
		
		StringTokenizer st = new StringTokenizer(res);
		String temp = "";
		
		while(st.hasMoreTokens()) {
			temp += switching(st.nextToken());
		}
		
		return Integer.parseInt(temp);
		
	}
	
	// 단어를 숫자로 바꿔주는 함수
	static String switching(String n) {
		String res = "";
		
		switch (n) {
		case "zero":
			res += "0";
			break;
		
		case "one":
			res += "1";
			break;
			
		case "two":
			res += "2";
			break;
			
		case "three":
			res += "3";
			break;
			
		case "four":
			res += "4";
			break;
			
		case "five":
			res += "5";
			break;
			
		case "six":
			res += "6";
			break;
			
		case "seven":
			res += "7";
			break;
			
		case "eight":
			res += "8";
			break;
			
		case "nine":
			res = "9";
			break;
		}
		
		return res;
		
	}
	
	// 숫자 단위로 하나씩 읽는 함수
	static String convertString(int num) {
		
		String res = "";
		
		if(num < 10) {
			
			res += switching(num);
			
		} else {
			
			int n1 = num/10;
			int n2 = num%10;
			res += switching(n1);
			res += switching(n2);
			
		}
		
		return res;
		
	}
	// 숫자를 단어로 바꿔주는 함수
	static String switching(int n) {
		
		String res = "";
		
		switch (n) {
		case 0:
			res += "zero ";
			break;
		
		case 1:
			res += "one ";
			break;
			
		case 2:
			res += "two ";
			break;
			
		case 3:
			res += "three ";
			break;
			
		case 4:
			res += "four ";
			break;
			
		case 5:
			res += "five ";
			break;
			
		case 6:
			res += "six ";
			break;
			
		case 7:
			res += "seven ";
			break;
			
		case 8:
			res += "eight ";
			break;
			
		case 9:
			res = "nine ";
			break;
		}
		
		return res;
		
		
	}
}
