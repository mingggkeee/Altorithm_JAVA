package 완탐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ_1497_S1_기타콘서트
 * 기타콘서트
 * 부분집합 문제
 */

public class BOJ_1497 {

	static int N, M;
	static int[] music;
	static String[] canPlay;
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		canPlay = new String[N];
		music = new int[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			canPlay[i] = st.nextToken();
		}

		playingMusic(0, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static void playingMusic(int count, int guitarCount) {
		if (count == N) {
			int musicCount = 0;
			for (int i = 0; i < M; i++) {
				if (music[i] > 0)
					musicCount++;
			}
			if (musicCount != 0 && musicCount == max) {
				if (min > guitarCount) {
					min = guitarCount;
				}
			} else if (musicCount > max) {
				min = guitarCount;
				max = musicCount;
			}
			return;
		}

		playingMusic(count + 1, guitarCount);
		for (int i = 0; i < M; i++) {
			if (canPlay[count].charAt(i) == 'Y') {
				music[i]++;
			}
		}
		playingMusic(count + 1, guitarCount + 1);
		for (int i = 0; i < M; i++) {
			if (canPlay[count].charAt(i) == 'Y') {
				music[i]--;
			}
		}

	}
}




/*
public class BOJ_1497 {
	
	static int N,M;
	static int[][] arr;
	static int[] arrIndex;
	static int maxSong,needGuitar;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 기타의 개수
		M = Integer.parseInt(st.nextToken()); // 곡의 개수
		
		arr = new int[N][M];
		arrIndex = new int[N];
		needGuitar = N;	
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // 기타이름은 필요없음
			String[] str = st.nextToken().split("");
			for(int j=0; j<M; j++) {
				arr[i][j] = str[j].equals("Y")?1:0; // Y이면 1 X이면 0
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			generateSubset(0,0,i);
		}
		if(cnt==0) {
			System.out.println(-1);
		} else {
			System.out.println(needGuitar);
		}

	}
	
	public static void generateSubset(int count, int start, int max) {
		if(count==max) {
			if(bitmask(arr, arrIndex, max)) {
				System.out.println(max);
				System.exit(0);
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			arrIndex[count] = i;
			generateSubset(count+1, i+1, max);
		}
	}
	
	public static boolean bitmask(int guitar[][], int index[],int max) {
		//max 만큼의 인덱스 배열의 행값으로 모든 기타를 비트마스킹
		boolean res = true;
		int can = 0;
		for(int i=0; i<M; i++) {
			//index의 0~ max 번째 까지  기타의 각 열을 비트마스킹
			int result = guitar[index[0]][i];
			if(result ==0) {
				for(int j=1; j<max; j++) {
					result = guitar[index[j]][i] | result;
				}				
			}
			if(result == 0) res = false;
			if(result == 1) can++;
		}
		if(maxSong<can) {
			maxSong = can;
			needGuitar = max;
		}
		return res;
	}

}
*/
