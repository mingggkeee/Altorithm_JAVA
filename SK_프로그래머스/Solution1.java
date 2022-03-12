package SK_프로그래머스;

import java.util.Arrays;

class Solution1 {
	
	static class Coin implements Comparable<Coin>{
		int unit;
		int cost;
		
		public Coin(int unit, int cost) {
			super();
			this.unit = unit;
			this.cost = cost;
		}

		@Override
		public int compareTo(Coin o) {
			// TODO Auto-generated method stub
			return o.unit-this.unit;
		}	
		
	}
	
    public int solution(int money, int[] costs) {
        int answer = 0;
        int[] unit = {1,5,10,50,100,500};
        Coin[] cargo = new Coin[6];
        
        for(int i=0; i<6; i++) {
        	cargo[i] = new Coin(unit[i], costs[i]);
        }
        
        Arrays.sort(cargo);
        
        while(true) {
        	if(money == 0) {
        		break;
        	}
        	
        	int compare = 0;
        	int num = 0;
        	int idx = 0;
        	
        	for(int i=0; i<6; i++) {
        		if(money > cargo[i].unit) {
        			compare = money / cargo[i].unit * cargo[i].cost;
        			num = money / cargo[i].unit;
        			num = num * cargo[i].unit;
        			idx = i;
        			break;
        		}
        	}
        	
        	for(int i=idx; i<6; i++) {
        		int temp = num / cargo[i].unit * cargo[i].cost;
        		if(compare > temp) {
        			compare = temp;
        		}
        	}
        	
        	answer += compare;
        	money = money % num;
        	
        }
        
        return answer;
    }
    
}