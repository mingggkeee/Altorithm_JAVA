package SK_프로그래머스;

class Solution2 {
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	// 시계방향
	static int[][] dir1 = {{0,1},{1,0},{0,-1},{-1,0}};
	// 반시계방향
	static int[][] dir2 = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static Location[] order = new Location[4];
	
	static boolean[][] isVisited;
	
	static int[][] map;
	
    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        isVisited = new boolean[n][n];
        map = new int[n][n];
        
        // 시계방향
        if(clockwise) {
        	map[0][0] = 1;
        	isVisited[0][0] = true;
        	order[0] = new Location(0, 0);
        	
        	map[0][n-1] = 1;
        	isVisited[0][n-1] = true;
        	order[1] = new Location(0, n-1);
        	
        	map[n-1][n-1] = 1;
        	isVisited[n-1][n-1] = true;
        	order[2] = new Location(n-1, n-1);
        	
        	map[n-1][0] = 1;
        	isVisited[n-1][0] = true;
        	order[3] = new Location(n-1, 0);
        	
        	answer = move(map, true, n);
        }
        // 반시계방향
        else {
        	map[0][0] = 1;
        	isVisited[0][0] = true;
        	order[0] = new Location(0, 0);
        	
        	map[n-1][0] = 1;
        	isVisited[n-1][0] = true;
        	order[1] = new Location(n-1, 0);
        	
        	map[n-1][n-1] = 1;
        	isVisited[n-1][n-1] = true;
        	order[2] = new Location(n-1, n-1);
        	
        	map[0][n-1] = 1;
        	isVisited[0][n-1] = true;
        	order[3] = new Location(0, n-1);
        	
        	answer = move(map, false, n);
        	
        }
        return answer;
    }
    
    static int[][] move(int[][] answer, boolean clockwise, int n) {
    	
    	int count = 1;
    	int idx = 0;
    	
    	if(clockwise) {
    		
        	while(true) {
        		boolean check = false;
        		count++;
        		for(int i=0; i<4; i++) {
        			int r = order[i].r;
        			int c = order[i].c;

    				int nr = r + dir1[(idx+i)%4][0];
    				int nc = c + dir1[(idx+i)%4][1];
    				
    				if(nr>=0 && nc>=0 && nr<n && nc<n && !isVisited[nr][nc]) {
    					isVisited[nr][nc] = true;
    					answer[nr][nc] = count;
    					order[i].r = nr;
    					order[i].c = nc;
    					check = true;
    				}
    				else {
    					idx++;
    					nr = r + dir1[(idx+i)%4][0];
        				nc = c + dir1[(idx+i)%4][1];
        				if(nr>=0 && nc>=0 && nr<n && nc<n && map[nr][nc] == 0) {
        					isVisited[nr][nc] = true;
        					answer[nr][nc] = count;
        					order[i].r = nr;
        					order[i].c = nc;
        					check = true;
        				}
    				}
        		}
        		
        		if(!check) {
        			break;
        		}
        	}
    		
    	}
    	else {
        	while(true) {
        		boolean check = false;
        		count++;
        		for(int i=0; i<4; i++) {
        			int r = order[i].r;
        			int c = order[i].c;

    				int nr = r + dir2[(idx+i)%4][0];
    				int nc = c + dir2[(idx+i)%4][1];
    				
    				if(nr>=0 && nc>=0 && nr<n && nc<n && !isVisited[nr][nc]) {
    					isVisited[nr][nc] = true;
    					answer[nr][nc] = count;
    					order[i].r = nr;
    					order[i].c = nc;
    					check = true;
    				}
    				else {
    					idx++;
    					nr = r + dir2[(idx+i)%4][0];
        				nc = c + dir2[(idx+i)%4][1];
        				if(nr>=0 && nc>=0 && nr<n && nc<n) {
        					if(isVisited[nr][nc]) {
        						break;
        					}
        					isVisited[nr][nc] = true;
        					answer[nr][nc] = count;
        					order[i].r = nr;
        					order[i].c = nc;
        					check = true;
        				}
    				}
        		}
        		
        		if(!check) {
        			break;
        		}
        	}
    	}
    	
    	
    	return answer;
    }
    

}
