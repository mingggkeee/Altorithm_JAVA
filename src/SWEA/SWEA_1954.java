package SWEA;

import java.util.Scanner;

public class SWEA_1954 {

    static int[] dx = {0,1,0,-1}; // 방향
    static int[] dy = {1,0,-1,0}; // 방향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        for (int t = 1; t <= T; t++) { 
            int N = sc.nextInt(); 
            int[][] map = new int[N][N]; 

            int r = 0; //행 숫자
            int c = 0; //렬 숫자

            int cnt = 1; //첫번째로 입력하는 숫자
            map[r][c] = cnt; //해당하는 위치에 숫자 입력
            cnt++; //입력 후 숫자 올려주기

            for (int i = 0; i < 2*N-1; i++) { 
                while(true) { 
                    int nr = r + dx[i%4]; // 처음은 +(0,1) -> 우측으로 진행
                    int nc = c + dy[i%4]; // 두번째 +(1,0) v 아래로 방향 진행
                     
                    if(nr >= 0 && nc >=0 && nr < N && nc < N && map[nr][nc] == 0) {
                        map[nr][nc] = cnt; 
                        cnt++; 
                    } else { 
                        break;
                    }
                    r = nr; 
                    c = nc;
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}


