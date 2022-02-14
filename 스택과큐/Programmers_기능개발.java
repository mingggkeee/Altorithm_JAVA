package 스택과큐;

import java.util.*;

public class Programmers_기능개발 {
	
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++) {
        	// ceil이 소수점 올림
        	// 배열마다 각자 걸리는 일수 큐에 저장
        	queue.add((int)(Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }
        
        while(!queue.isEmpty()) {
        	int day = queue.poll();
        	int cnt = 1;
        	
        	// peek으로 확인해서 조건에 맞으면 큐에서 제거해주기
        	while(!queue.isEmpty() && day >= queue.peek()) {
        		cnt++;
        		queue.poll();
        	}
        	answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
        		
    }
    
    public static void main(String[] args) {
		Programmers_기능개발 a = new Programmers_기능개발();
		int [] aa = {93, 30, 55};
		int [] bb = {1, 30, 5};
		int [] result = a.solution(aa, bb);
		System.out.println(Arrays.toString(result));
	}

}
