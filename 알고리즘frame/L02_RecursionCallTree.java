package 알고리즘frame;

public class L02_RecursionCallTree {

	// 다음 함수의 호출 트리를 작성해보면서 파라미터인 K의 변화를 살펴보세요.
	public static void recur(int k) {
		if (k == 0) {
			System.out.println("재귀 종료");
			return;
		}

		System.out.println("Before: " + k);
		recur(k - 1);
		System.out.println("After: " + k);
	}

	public void recurTest() {
		recur(3);
	}

	public long factorial(long n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	// 배열에저장된 값이 k와 동일하게 처리해보세요.
	public void recur3(int k, int n, int[] arr) {
		if (k == n) {
			return;
		}
		System.out.println(k + " : " + arr[0]);
		recur3(k + 1, n, arr);
		System.out.println(k + " : " + arr[0]);

	}

	public void reur3Test() {
		int[] arr = new int[1];
		recur3(0, 3, arr);
	}

	int N = 3;
	int cnt;

	public void recUseMember(int k) {
		if (k == N) {
			cnt++;
			return;
		}
		recUseMember(k + 1);
	}

	// 위 함수를 호출했을 때 cnt값의 변화를 예상하고 테스트하시오.
	public void recUseMemberTest() {
		recUseMember(0);
		System.out.println(cnt);
	}

	int cnt2;

	public void reUseMemMulti(int k) {
		if (k == N) {
			cnt2++;
			System.out.println(cnt2);
			return;
		}
		reUseMemMulti(k + 1);
		reUseMemMulti(k + 1);
	}

	// 위 함수를 호출했을 때 cnt값의 변화를 예상하고 테스트하시오.
	public void reUseMemMultiTest() {
		reUseMemMulti(0);
		System.out.println("최종: " + cnt2);
	}

	public void reUseLocMulti(int k) {
		if (k == N) {
			System.out.println(k++);
			return;
		}
		reUseLocMulti(k + 1);
		reUseLocMulti(k + 1);
	}

	// 위 함수를 호출했을 때 cnt의 변화를 예상하고 테스트 하시오.
	public void reUseLocMultiTest() {
		reUseLocMulti(0);
	}

	public int reReturn(int k) {
		if (k == N) {
			return 1;
		}
		return reReturn(k + 1) + reReturn(k + 1);
	}

	// TODO: 위 함수의 호출 결과를 예상하고 테스트 하시오.
	// END:
}
