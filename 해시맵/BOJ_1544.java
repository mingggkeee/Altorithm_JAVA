package 해시맵;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ_1544_S4_사이클 단어
 * @Author mingggkeee
 * @Date 2022. 5. 16.
 * @Category : 
 */

public class BOJ_1544 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			boolean chk = false;
			
			for(int j=0; j<list.size(); j++) {
				if(list.get(j).length() == input.length()) {
					if(compare(list.get(j), input)) {
						chk = true;
                        break;
                    }
                }
                
            }
            if(chk == false) {
                list.add(input);
            }
        }
        System.out.println(list.size());
	}
	
	static boolean compare(String a, String b) {
		boolean equal = false;
		StringBuffer sb = new StringBuffer();
		
		sb.append(a);
		for(int i=0; i<a.length(); i++) {
			equal = true;
			for(int j=0; j<b.length(); j++) {
				if(sb.toString().charAt(j) == b.charAt(j)) {
					
				} else {
					equal = false;
				}
			}
			if(equal) {
				break;
			}
			sb = sb.append(sb.charAt(0)).deleteCharAt(0);
		}
		
		
		return equal;
	}

}
