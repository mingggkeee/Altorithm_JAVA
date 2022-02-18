package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1018_S5_체스판 다시 칠하기
 * @author mingggkeee
 * 구현
 */

public class BOJ_1018 {
    static char [][]b_origin = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };

    static char [][]w_origin = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
    };
    static int b_min=0;
    static int w_min=0;

    static char [][] compare;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); //세로
        int C = Integer.parseInt(st.nextToken()); //가로

        compare = new char[R][C] ;

        for (int i=0;i<R;i++) {
            compare[i] = br.readLine().toCharArray();
           
        }//비교할 체스판 입력받음

      

        int min = Integer.MAX_VALUE;


        for (int i=0;i<=R-8;i++) {
            for (int j=0;j<=C-8;j++) {
                for (int t=0; t<8 ; t++) {
                    for (int c =0; c<8; c++) {
                        if (w_origin[t][c] != compare[t+i][c+j]) w_min++;
                        else if (b_origin[t][c] != compare[t+i][c+j]) b_min++;
                    }
                 }
                min=Integer.min(min,Integer.min(w_min,b_min));
                w_min=0;
                b_min=0;
            }
        }
        System.out.println(min);



    }

}