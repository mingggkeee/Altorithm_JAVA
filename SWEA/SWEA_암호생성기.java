package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_암호생성기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		while(true) {
			try {
				int T = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int i=0; i<8; i++) {
					queue.offer(Integer.parseInt(st.nextToken()));
				}
				int sub = 1;
				int cycle = 0;
				while(true) {
					if(cycle == 5) {
						sub = 1;
						cycle = 0;
					}
					
					int temp = queue.poll();
					
					if(temp-sub <= 0) {
						queue.offer(0);
						break;
					}
					else {
						queue.offer(temp-sub);
						sub++;
						cycle++;
					}
				}
				
				System.out.print("#"+T+" ");
				while(!queue.isEmpty()) {
					System.out.print(queue.poll()+" ");
				}
				System.out.println();
				
			} catch (NumberFormatException e){
				break;
			}
			
		}
	}

}
