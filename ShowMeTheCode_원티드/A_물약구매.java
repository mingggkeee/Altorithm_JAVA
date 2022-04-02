package ShowMeTheCode_원티드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class A_물약구매 {
	
	static class Sales {
		int idx;
		int price;
		
		public Sales(int idx, int price) {
			this.idx = idx;
			this.price = price;
		}

		@Override
		public String toString() {
			return "Sales [idx=" + idx + ", price=" + price + "]";
		}
		
		
	}
	
	static int N, K;
	static int[] prices;
	static List<Sales[]> list;
	static int answer = Integer.MAX_VALUE;
	static boolean[] isVisited;
	static int[] selected;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		prices = new int[N];
		isVisited = new boolean[N];
		selected = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			K = Integer.parseInt(br.readLine());
			
			if(K==0) {
				Sales[] temp = new Sales[1];
				temp[0] = new Sales(i,0);
				list.add(temp);
				continue;
			}
			
			Sales[] temp = new Sales[K];
			
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				temp[k] = new Sales(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			}
			
			list.add(temp);
			
		}
		
		permu(0);
		
		System.out.println(answer);
	}
	
	static void permu(int cnt) {
		
		if(cnt == N) {
			Calc(selected);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				selected[cnt] = i;
				permu(cnt+1);
				isVisited[i] = false;
			}
		}
		
	}
	
	static void Calc(int[] selected) {
		
		int compare = 0;
		
		int[] salePrices = new int[N];
		for(int i=0; i<N; i++) {
			salePrices[i] = prices[i];
		}
		
		for(int i=0; i<N; i++) {
			
			int num = selected[i];
			
			compare += salePrices[num];
			
			Sales[] temp = list.get(num);
			
			for(int k=0; k<temp.length; k++) {
				int idx = temp[k].idx;
				int sub = temp[k].price;
				salePrices[idx] -= sub;
				if(salePrices[idx] <= 0) {
					salePrices[idx] = 1;
				}
			}
			
		}
		
		
		answer = Math.min(answer, compare);
		
	}

}
