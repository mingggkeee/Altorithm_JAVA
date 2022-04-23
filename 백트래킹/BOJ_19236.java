package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_19236_G2_청소년 상어
 * @Author mingggkeee
 * @Date 2022. 4. 22.
 * @Category : 백트래킹, 시뮬레이션
 */

public class BOJ_19236 {
    static class Shark {
        int x, y, dir, eatSum;

        Shark() { }

        Shark(int x, int y, int dir, int eatSum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }

    static class Fish {
        int x, y, no, dir;
        boolean isAlive = true;

        Fish() { }
        
        Fish(int x, int y, int no, int dir, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.no = no;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }
    
    // 0 부터 7 까지 순서대로 ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        // input
        for (int r = 0; r < 4; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < 4; c++) {
                Fish f = new Fish();
                f.no = Integer.parseInt(st.nextToken());
                f.dir = Integer.parseInt(st.nextToken()) - 1;
                f.x = r;
                f.y = c;
                
                fishes.add(f);
                map[r][c] = f.no;
            }
        }

        // 물고기는 작은 순서부터 이동해야 하기 때문에 미리 정렬
        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.no - o2.no;
            }
        });

        // 상어는 (0, 0) 물고기를 먹고 시작하며 위치는 -1 로 표현
        Fish f = fishes.get(map[0][0] - 1);
        Shark shark = new Shark(0, 0, f.dir, f.no);
        f.isAlive = false;
        map[0][0] = -1;
        
        // solution
        dfs(map, shark, fishes);
        System.out.println(maxSum);
    }

    // 재귀로 상어가 이동할 수 없을 때까지 반복한다.
    static void dfs(int[][] arr, Shark shark, List<Fish> fishes) {
        // 잡아먹은 양의 최대값 구하기
        if (maxSum < shark.eatSum) {
            maxSum = shark.eatSum;
        }

        // 모든 물고기 순서대로 이동
        fishes.forEach(e -> moveFish(e, arr, fishes));
        
        for (int dist = 1; dist < 4; dist++) {
            int nx = shark.x + dx[shark.dir] * dist;
            int ny = shark.y + dy[shark.dir] * dist;
    
            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > 0) {
                // 물고기 잡아먹고 dfs
                int[][] arrCopies = copyArr(arr);
                List<Fish> fishCopies = copyFishes(fishes);
                
                arrCopies[shark.x][shark.y] = 0;
                Fish f = fishCopies.get(arr[nx][ny] - 1);
                Shark newShark = new Shark(f.x, f.y, f.dir, shark.eatSum + f.no);
                f.isAlive = false;
                arrCopies[f.x][f.y] = -1;
                
                dfs(arrCopies, newShark, fishCopies);
            }
        }
    }
    
    // 이동가능한 칸은 빈칸, 다른 물고기가 있는 칸
    // 45도 반시계 방향으로 회전하면서 스캔
    static void moveFish(Fish fish, int[][] arr, List<Fish> fishes) {
        if (fish.isAlive == false) return;

        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.dir + i) % 8;
            int nx = fish.x + dx[nextDir];
            int ny = fish.y + dy[nextDir];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > -1) {
                arr[fish.x][fish.y] = 0;
                
                if (arr[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish temp = fishes.get(arr[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    arr[fish.x][fish.y] = temp.no;

                    fish.x = nx;
                    fish.y = ny;
                }

                arr[nx][ny] = fish.no;
                fish.dir = nextDir;
                return;
            }
        }
    }

    static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        fishes.forEach(e -> temp.add(new Fish(e.x, e.y, e.no, e.dir, e.isAlive)));
        return temp;
    }
}
