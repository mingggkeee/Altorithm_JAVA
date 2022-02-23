package 정렬;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_16236_G3_아기 상어
 * @author mingggkeee
 * BFS, 조건분기, 구현
 * 0 : 빈칸, {1,2,3,4,5,6} : 물고기의 크기, 9 : 아기 상어의 위치
 */

public class BOJ_16236 {
	
	static int N;
	static int time;
	static int[][] map;
	static int startR, startC;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static int weight = 2;	// 초기에는 무게가 2
	static int count = 2;	// 무게가 증가하기 위해 먹어야하는 물고기 수
	static Queue<Location> queue;
	static boolean[][] isVisited;
	
	static class Location{
		int r;
		int c;
		int loc;
		int weight;
		
		public Location(int r, int c, int loc) {
			this.r=r;
			this.c=c;
			this.loc=loc;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					map[r][c] = 0;
					startR = r;
					startC = c;
				}
			}
		}
		
		while(true) {
			if(!bfs(startR, startC)) {
				break;
			}
		}
		
		System.out.println(time);
		
		
	}
	
	static boolean bfs(int r, int c) {
		queue = new LinkedList<>();
		isVisited = new boolean[N][N];
		isVisited[r][c] = true;
		
		List<Location> list = new ArrayList<>();
		
		queue.offer(new Location(r,c,0));
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && !isVisited[nr][nc] && weight>=map[nr][nc]) {
					isVisited[nr][nc] = true;
					queue.offer(new Location(nr,nc,now.loc+1));
					if(map[nr][nc] != 0 && map[nr][nc] < weight) {
						list.add(new Location(nr,nc,now.loc+1));
					}
				}
				
			}
		}
		
		Collections.sort(list, new Comparator<Location>() {

			@Override
			public int compare(Location o1, Location o2) {
				if(o1.loc==o2.loc) {
					if(o1.r==o2.r) {
						return o1.c-o2.c;
					}
					return o1.r-o2.r;
				}
				return o1.loc-o2.loc;
			}
		});
		
		if(list.size()==0) {
			return false;
		}
		
		Location go = list.get(0);
		startR = go.r;
		startC = go.c;
		time += go.loc;
		if(map[go.r][go.c]<weight) {
			map[go.r][go.c] = 0;
			count--;
			if(count==0) {
				weight++;
				count = weight;
			}
		}
		
		return true;
		
	}
	

}
