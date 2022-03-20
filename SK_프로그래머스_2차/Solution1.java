package SK_프로그래머스_2차;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 {
	
    public String[] solution(String[] goods) {
        String[] answer = new String[goods.length];
        
        for(int i=0; i<goods.length; i++) {
        	
        	String now = goods[i];
        	String search = "";
        	
        	Set<String> list = new HashSet<>();
        	
        	for(int j=1; j<now.length()+1; j++) {
        		for(int m=0; m<now.length(); m++) {
        			if(j+m > now.length()) {
        				continue;
        			}
	        		String a = now.substring(m, j+m);
	        		int count = 0;
	        		for(int k=0; k<goods.length; k++) {
	        			if(goods[k].equals(now)){
	        				continue;
	        			}
	        			if(goods[k].contains(a)) {
	        				count++;
	        				break;
	        			}
	        		}
	        		
	        		if(count==0) {
	        			list.add(a);
	        		}
        		}
        		
        		if(list.size()!=0) {
        			break;
        		}
        		
        	}
        	
        	List<String> targetList = new ArrayList<>(list);
        	
        	Collections.sort(targetList);
        	
        	for(int m=0; m<targetList.size(); m++) {
        		if(m==0) {
        			search+=targetList.get(m);
        		}
        		else {
        			search+= " ";
        			search+=targetList.get(m);
        		}
        	}
        	
        	
        	if(search=="") {
        		search = "None";
        	}
        	
        	answer[i] = search;
        	
        }
        
        
        return answer;
    }
    
    
    
    
}
