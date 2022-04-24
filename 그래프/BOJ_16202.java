package 그래프;

/**
 * BOJ_16202_G4_MST게임
 * @author : mingggkeee
 * @date : 2022.04.24
 * MST, 크루스칼
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16202 {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }

    static int N, M ,K;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(start, end, i+1);
        }

        for(int i=0; i<K; i++){
            Queue<Integer> queue = new LinkedList<>();

            makeSet();
            int answer = 0;
            for(int j=i; j<M; j++){
                int start = findSet(nodes[j].start);
                int end = findSet(nodes[j].end);

                if(start==end)
                    continue;

                union(start,end);
                queue.offer(j+1);
                answer += nodes[j].weight;
            }

            boolean check = true;
            int flag = 0;
            for(int m=1; m<=N; m++){
                if(m==1){
                    flag = findSet(1);
                }
                if(flag != findSet(m)){
                    check = false;
                    break;
                }
            }

            if(check){
                System.out.print(answer+" ");
            } else{
                for(int m=i; m<K; m++){
                    System.out.print("0 ");
                }
                break;
            }
        }
    }

    static void makeSet(){
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }
    }

    static int findSet(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot){
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }

}
