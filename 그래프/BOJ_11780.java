package 그래프;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ_11780_G2_플로이드 2
 * @Author mingggkeee
 * @Date 2022. 4. 10.
 * @Category : 플로이드-와샬
 */

public class BOJ_11780 {

	
	static int[][] map;
	static int[][] savePath;
	static int N, M;
	static int INF = 20000000;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		savePath = new int[N+1][N+1];
		map = new int[N+1][N+1];
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				savePath[r][c] = INF;
				if(r==c)
					continue;
				map[r][c] = INF;
			}
		}
		
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[start][end] = Math.min(map[start][end], weight);
			savePath[start][end] = start;
		}
		
		floyd();
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(map[r][c] == INF) {
					System.out.print(0+" ");
				} else {
					System.out.print(map[r][c]+" ");
				}
			}
			System.out.println();
		}
		
        for(int r=1; r<=N; r++) {
            for(int c=1; c<=N; c++) {
                if(savePath[r][c]==INF)
                    System.out.println(0);

                else {
                    int pre = c;
                    stack.push(c);
                    while(r != savePath[r][pre]) {
                        pre = savePath[r][pre];
                        stack.push(pre);
                    }
                    System.out.print((stack.size()+1)+" ");
                    System.out.print(r+" ");
                    while(!stack.empty())
                        System.out.print(stack.pop()+" ");
                    System.out.println();
                }
            }
        }
		
	}
	
    public static void floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][j] > map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                        savePath[i][j] = savePath[k][j];
                    }
                }
            }
        }
    }
	
	
	
}
