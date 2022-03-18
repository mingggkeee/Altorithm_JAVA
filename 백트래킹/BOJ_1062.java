package 백트래킹;

import java.util.*;

/**
 * BOJ_1062_G4_가르침
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_1062 {
 
    static int N, K;
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] inputs;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextInt();
        K = sc.nextInt();
        
        sc.nextLine();
        inputs = new String[N];
        
        for(int i = 0; i < N; i++) {
            String str = sc.nextLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            inputs[i] = str;
        }
        
        if(K < 5) { 
            System.out.println("0");
            System.exit(0);
        } else if(K == 26) { 
            System.out.println(N);
            System.exit(0);
        }
        
        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        // 필수로 가르쳐야하는 것들
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        
        combi(0, 0);
        System.out.println(answer);
        
        sc.close();
    }
    
    public static void combi(int start, int cnt) {
        if(cnt == K - 5) {
            int count = 0;
            for(int i = 0; i < N; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for(int j = 0; j < inputs[i].length(); j++) {
                    if(!visited[inputs[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            answer = Math.max(answer, count);
            return;
        }
        
        for(int i = start; i < 26; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                combi(i, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
