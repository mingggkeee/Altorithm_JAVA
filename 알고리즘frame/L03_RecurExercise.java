package 알고리즘frame;

public class L03_RecurExercise {
	static int getMultiFor(int n, int m) {
		int result = 1;
		for (int i = n; i <= m; i++) {
			result *= i;
		}
		return result;
	}

	// TODO: getMultiFor를 재귀로 처리하시오.
	// END:

	static int getPowerFor(int n, int m) {
		int result = 1;
		for (int i = 1; i <= m; i++) {
			result *= n;
		}
		return result;
	}

	// TODO: a의 b 승을 계산할 수 있는 power 함수를 재귀 형태로 작성하고 테스트 하시오.
	// END:

	static int getDigitSumFor(int n) {
		int sum = 0;
		for (; n > 0; n /= 10) {
			sum += n % 10;
		}
		return sum;
	}

	// TODO: 10진수 숫자를 입력 받아서 각 자릿수의 합을 구하시오.
	// END:

	static String getBinaryFor(int n) {
		String result = "";
		for (; n > 0; n /= 2) {
			result = n % 2 + result;
		}
		return result;
	}

	// TODO: 10진수 숫자를 입력 받아서 2진수로 출력하시오.
	// END:

	

	static boolean isPalindromeFor(String str) {
		for (int s = 0, e = str.length() - 1; s < e; s++, e--) {
			if (str.charAt(s) != str.charAt(e)) {
				return false;
			}
		}
		return true;
		}
	}

	// TODO: 주어지는 문자열이 팰린도룸인지 판별하시오.
	// END:

	