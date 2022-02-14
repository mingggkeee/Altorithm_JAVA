package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int x = 0; // 전차 위치 저장
		int y = 0; // 전차 위치 저장
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());	// 행 입력
			int C = Integer.parseInt(st.nextToken());	// 열 입력
			String [][] map = new String[R][C];
			for(int r=0;r<R;r++) {
				String str = br.readLine();
				String[] strs = str.split("");
				for(int c=0;c<C;c++) {
					String s = strs[c];
					if(s.equals("^") || s.equals("<") || s.equals(">") || s.equals("v")) {
						x = c;
						y = r;
					}
					map[r][c] = s;
				}
			}
			int count = Integer.parseInt(br.readLine());
			String commands = br.readLine();
			String [] command = commands.split("");
			for(int i=0; i<count; i++) {
				if(command[i].equals("U")) {
					map[y][x] = "^";
					if(y-1>=0 && map[y-1][x].equals(".")) {
						map[y][x] = ".";
						map[y-1][x] = "^";
						y--;
					}
				} else if(command[i].equals("D")) {
					map[y][x] = "v";
					if(y+1<R && map[y+1][x].equals(".")) {
						map[y][x] = ".";
						map[y+1][x] = "v";
						y++;
					}
				} else if(command[i].equals("L")) {
					map[y][x] = "<";
					if(x-1>=0 && map[y][x-1].equals(".")) {
						map[y][x] = ".";
						map[y][x-1] = "<";
						x--;
					}
				} else if(command[i].equals("R")) {
					map[y][x] = ">";
					if(x+1<C && map[y][x+1].equals(".")) {
						map[y][x] = ".";
						map[y][x+1] = ">";
						x++;
					}
				} else if(command[i].equals("S")) {
					if(map[y][x].equals("^")) {
						int r = y;
						while(r>=0) {
							if(map[r][x].equals("*")) {
								map[r][x] = ".";
								break;
							}
							if(map[r][x].equals("#")) {
								break;
							}
							r--;
						}
						
					} else if(map[y][x].equals("v")) {
						int r = y;
						while(r<R) {
							if(map[r][x].equals("*")) {
								map[r][x] = ".";
								break;
							}
							if(map[r][x].equals("#")) {
								break;
							}
							r++;
						}
						
					} else if(map[y][x].equals("<")) {
						int c = x;
						while(c>=0) {
							if(map[y][c].equals("*")) {
								map[y][c] = ".";
								break;
							}
							if(map[y][c].equals("#")) {
								break;
							}
							c--;
						}
						
					} else if(map[y][x].equals(">")) {
						int c = x;
						while(c<C) {
							if(map[y][c].equals("*")) {
								map[y][c] = ".";
								break;
							}
							if(map[y][c].equals("#")) {
								break;
							}
							c++;
						}
						
					}
				}
			}
			System.out.print("#"+t+" ");
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}
	}
}
