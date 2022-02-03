package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 받기
		for(int t=1; t<=T; t++) {
			int count = 0;
			String memory = br.readLine();
			String temp = "";
			for(int i=0; i<memory.length(); i++) {
				temp+="0";
			}
			char[] memory2 = memory.toCharArray();
			char[] temp2 = temp.toCharArray();
			while(true) {
				for(int i=0; i<memory.length(); i++) {
					if(memory2[i] != temp2[i]) {
						count++;
						char s = memory2[i];
						int a = i;
						while(a<memory.length()) {
							temp2[a] = s;
							a++;
						}
					}
				}
				
				memory = String.valueOf(memory2);
				temp = String.valueOf(temp2);
				if(memory.equals(temp)) {
					break;
				}
			}
			
			bw.write("#"+t+" "+count+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
