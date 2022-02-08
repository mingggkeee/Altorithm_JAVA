package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_암호문1 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 1; // 테케
		StringTokenizer st;
		while(true) {
			
			String temp = br.readLine();
			try {
				int N = Integer.parseInt(temp); // 암호문의 길이
				List<Integer> list = new ArrayList<Integer>();
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				
				int command = Integer.parseInt(br.readLine()); // 명령어의 개수
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<command; i++) {
					String trash = st.nextToken(); // 삽입 문자
					int x = Integer.parseInt(st.nextToken()); // 인덱스
					int y = Integer.parseInt(st.nextToken()); // 삽입할 숫자
					for(int j=0; j<y; j++) {
						list.add(x, Integer.parseInt(st.nextToken()));
						x++;
					}
					
				}
				
				System.out.print("#"+count+" ");
				for(int i=0; i<6; i++) {
					System.out.print(list.get(i)+" ");
				}
				System.out.println();
				for(int i=6; i<10; i++) {
					System.out.print(list.get(i)+" ");
				}
				System.out.println();
				count++;
				
			} catch (NumberFormatException e) {
				break;
			}
			
		}
		
		br.close();
	}
}
