package 구현;

/**
 * BOJ_20361_B3_일우는 야바위꾼
 * 구현
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_20361 {
	
	static int N;
	static int X,K;
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);	// 스캐너 선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = sc.nextInt();	// 종이컵의 수 받기
		X = sc.nextInt();	// 간식이 들어있는 종이컵 받기
		K = sc.nextInt();	// 컵의 위치를 바꾸는 횟수 받기
		arr = new int[N+1];	// 간식이 든 종이컵의 위치를 저장할 배열 선언
		arr[X] = 1;			// 간식이 든 종이컵의 위치를 저장
		// K번만큼 종이컵의 위치 바꾸기
		for(int k=0; k<K; k++) {
			// 서로 맞바꿀 종이컵의 위치 입력 받기
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			// 맞바꾸는 작업
			int temp = arr[num1];
			arr[num1] = arr[num2];
			arr[num2] = temp;

			
		}
		
		// 값이 1인 것을 찾아서 변수에 저장(그것이 간식이 들어있는 종이컵의 위치)
		for(int i=0; i<N+1; i++) {
			if(arr[i]==1) {
				answer = i;
			}
		}
		// 종이컵의 위치 출력
		bw.write(answer+"\n");
		sc.close();
		bw.flush();
		bw.close();
	}
}
