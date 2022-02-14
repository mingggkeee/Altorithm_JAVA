package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2563_B1_색종이
 * @author mingggkeee
 * 구현
 */

public class BOJ_2563 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        int map[][] = new int[100][100];
        int count = 0;
        int number = Integer.parseInt(br.readLine());
         
        for(int i=0; i<number; i++) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
             
            for(int j=y; j<y+10; j++) {
            	
                for(int z=x; z<x+10; z++) {
                    map[j][z]=1;
                }
            }
        }
        
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if(map[i][j]==1) {
                    count++;
                }
            }
        }
        System.out.println(count);
        
        br.close();
 
    }  
}
