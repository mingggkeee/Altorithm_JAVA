package 스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * BOJ_7662_G5_이중 우선순위 큐
 * @author mingggkeee
 * 우선순위 큐
 */

public class BOJ_7662 {
	
	static int T;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				switch(command) {
	            case "I" :
	                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
	                break;
	            case "D" :
	                if(treeMap.isEmpty()) 
	                	break;
	                if(num == -1) {
	                    int minKey = treeMap.firstKey();
	                    if(treeMap.get(minKey) == 1) {
	                        treeMap.remove(minKey);
	                    }else {
	                        treeMap.put(minKey, treeMap.get(minKey) - 1);
	                    }
	                }else {
	                    int maxKey = treeMap.lastKey();
	                    if(treeMap.get(maxKey) == 1) {
	                        treeMap.remove(maxKey);
	                    }else {
	                        treeMap.put(maxKey, treeMap.get(maxKey) - 1);
	                    }
	                }
	                break;
	        }
			}
			
			if(treeMap.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
