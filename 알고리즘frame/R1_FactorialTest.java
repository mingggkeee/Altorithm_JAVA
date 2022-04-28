package 알고리즘frame;

import java.util.Scanner;

public class R1_FactorialTest {
	
	public static int factorial(int n) {
		int res = 1;
		for(int i=n; i>0; i--) {
			res *= i;
		}
		return res;
	}
	
	// 리턴값 활용하지 않음 : 위 반복문을 재귀로 변경
	static int res = 1;
	public static void factorial2(int n) {
		if(n==0) {
			return;
		}
		res *= n;
		factorial2(n-1);
	}
	
	// 리턴값을 활용 : n! = n* n-1!
	public static int factorial3(int n) {
		if(n==1) {
			return 1;
		}
		return n*factorial3(n-1);
	}
	
	static int arr[] = {10,20,30};
	public static void printArray1(int r) {
		if(r == arr.length) {
			System.out.println();
			return;
		}
		System.out.print(arr[r]+" ");
		printArray1(r+1);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n));
		
		factorial2(n);
		System.out.println(res);
		
		System.out.println(factorial3(n));
		printArray1(0);
		sc.close();
	}
	
}
