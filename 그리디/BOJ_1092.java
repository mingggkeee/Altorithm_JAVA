package 그리디;

import java.io.*;
import java.util.*;

/**
 * BOJ_1092_G5_배
 * @author mingggkeee
 * 정렬 그리디
 */

public class BOJ_1092 {
	
	
	static int N, M, time;
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        
        M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());
        
        if(crane.get(0) < box.get(0)) {
        	System.out.println("-1");
        }
        else {
            while(!box.isEmpty()) {
                int idx = 0;
                for(int i = 0; i < crane.size();) {
                    if(idx == box.size()) break;
                    else if(crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    }
                    else idx++;
                }
                time++;
            }
            System.out.println(time);
        }
    }

}
