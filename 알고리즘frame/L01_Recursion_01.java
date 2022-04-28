package 알고리즘frame;

public class L01_Recursion_01 {

	public static void recursionEndless() {
		System.out.println("Hello Recursion");
		recursionEndless();
	}

	public static void recursionLimit(int k) {
		if (k == 0) {       // 기본 부분 - 언젠가 종료
			return;
		}
		System.out.println("실제로 하고 처리할 로직");
		recursionLimit(k - 1); // 유도 부분 - 성장한 자기호출
	}

	public static void beepLoop() {
		for (int i = 0; i < 10; i++) {
			System.out.print("beep~~ ");
		}
	}
	
	// TODO: 위의 beepLoop를 재귀 형태로 처리하시오.
	public static void beepRecur(int i) {
		if(i==10) {
			return;
		}
		System.out.print("beep~~ ");
		
		beepRecur(i+1);
	}
	
	public static void beepRecur2(int i) {
		if(i<10) {
			System.out.print("beep~~ ");
			beepRecur2(i+1);
		}
	}
	// END:
	
	public void beepTest() {
		beepLoop();
		System.out.println();
		beepRecur(0);
		System.out.println();
		beepRecur2(0);
	}
	
	// 배열에 저장된 값이 k와 동일하게 처리
	public void recur3(int k, int n, int[] arr) {
		if(k==n) {
			return;
		}
		arr[0] = k;
		System.out.println(k + " : "+arr[0]);
		recur3(k + 1, n, arr);
		arr[0] = k;
		System.out.println(k+" : "+arr[0]);
	}
	
	public void recur3Test() {
		int arr[] = new int[1];
		recur3(0, 3, arr);
	}
	
}
