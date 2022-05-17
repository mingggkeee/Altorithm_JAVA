package 해시맵;

import java.util.*;
import java.io.*;
 
public class BOJ_1620 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        Map<String, String> map = new HashMap<>();
 
        for(int i=0; i<n; i++) {
            String pokemon = br.readLine();
            String no = Integer.toString(i+1);
            map.put(pokemon, no);
            map.put(no, pokemon);
        }
 
        StringBuilder sb = new StringBuilder(m);
        for(int i=0; i<m; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.print(sb);
    }
}
