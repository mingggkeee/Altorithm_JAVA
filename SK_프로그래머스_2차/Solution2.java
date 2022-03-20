package SK_프로그래머스_2차;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
	
	static class Process implements Comparable<Process>{
		String name;
		int startTime;
		int durTime;
		int startIdx;
		int endIdx;
		int write;
		
		// write
		public Process(String name, int startTime, int durTime, int startIdx, int endIdx, int write) {
			this.name = name;
			this.startTime = startTime;
			this.durTime = durTime;
			this.startIdx = startIdx;
			this.endIdx = endIdx;
			this.write = write;
		}
		
		// read
		public Process(String name, int startTime, int durTime, int startIdx, int endIdx) {
			this.name = name;
			this.startTime = startTime;
			this.durTime = durTime;
			this.startIdx = startIdx;
			this.endIdx = endIdx;
		}

		@Override
		public int compareTo(Process o) {

			if(this.name.equals(o.name)) {
				return this.startTime-o.startTime;
			}
			
			return o.name.compareTo(this.name);
		}

		@Override
		public String toString() {
			return "Process [name=" + name + ", startTime=" + startTime + ", durTime=" + durTime + ", startIdx="
					+ startIdx + ", endIdx=" + endIdx + ", write=" + write + "]";
		}
		
		
		
	}
	
    public String[] solution(String[] arr, String[] processes) {
    	
    	// answer 배열 생성
    	int length = 0;
    	for(int i=0; i<processes.length; i++) {
    		String now = processes[i];
    		if(now.substring(0, 4).equals("read")) {
    			length++;
    		}
    	}
    	String[] answer = new String[length+1];
    	
    	
    	Queue<Process> queue = new LinkedList<>();
    	PriorityQueue<Process> pq = new PriorityQueue<>();

    	// 프로세스 읽기
    	for(int i=0; i<processes.length; i++) {
    		String now = processes[i];
    		String[] temp = now.split(" ");
    		String name = temp[0];
    		int startTime = Integer.parseInt(temp[1]);
    		int durTime = Integer.parseInt(temp[2]);
    		int startIdx = Integer.parseInt(temp[3]);
    		int endIdx = Integer.parseInt(temp[4]);
    		
    		if(temp[0].equals("read")) {
    			queue.offer(new Process(name, startTime, durTime, startIdx, endIdx));
    		}
    		else {
    			int write = Integer.parseInt(temp[5]);
    			queue.offer(new Process(name, startTime, durTime, startIdx, endIdx, write));
    			
    		}
    		
    	}
    	
    	boolean end = false;
    	
    	int idx = 0;
    	
    	int time = 0;
    	// 1 이면 read, 2면 write중, 0이면 아무것도 없는
    	int status = 0;
    	
    	int change = 0;
    	
    	while(!end) {
    		time++;
    		Process now;
    		boolean check = true;
    		
    		while(check && !queue.isEmpty()) {
    			now = queue.peek();
	    		if(now.startTime<=time && queue.size()>0) {
	    			pq.offer(queue.poll());
	    		}
	    		else {
	    			check = false;
	    		}
    		}
    		
    		
    		if(pq.size()==0) {
    			continue;
    		}
    		
			now = pq.peek();
			System.out.println(now.toString());
			
			if(now.name.equals("read")) {
				
				while(true) {
					
					check = true;
					while(check && !queue.isEmpty()) {
		    			now = queue.peek();
			    		if(now.startTime<=time && queue.size()>0) {
			    			pq.offer(queue.poll());
			    		}
			    		else {
			    			check = false;
			    		}
		    		}
					
					if(pq.size()==0 || pq.peek().name.equals("write")) {
						break;
					}
					else {
						now = pq.poll();
						String input = "";
						for(int i=now.startIdx; i<=now.endIdx; i++) {
		    				input += arr[i];
		    			}
						answer[idx++] = input;
					}
				}
				
				time += now.durTime-1;
				
				
    		}
			else if(now.name.equals("write")) {
				pq.poll();
				for(int i=now.startIdx; i<=now.endIdx; i++) {
    				arr[i] = Integer.toString(now.write);
    			}
				time += now.durTime-1;
			}
			
			if(pq.isEmpty() && queue.isEmpty()) {
				end = true;
			}
			
    		
    	}
    	
    	
    	while(!pq.isEmpty()) {
    		System.out.println(pq.poll().toString());
    	}
    	
    	answer[length] = Integer.toString(time);
    	
        return answer;
    }

}