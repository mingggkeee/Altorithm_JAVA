package 알고리즘frame;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.offer(10);
		queue.offer(5);
		queue.offer(50);
		
		System.out.println(queue.toString());
	}
	
}
