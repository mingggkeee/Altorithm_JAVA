package 알고리즘frame;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueAPITest {

	public static void main(String[] args) {

//		Queue<String> queue = new LinkedList<String>();
		Queue<String> queue = new ArrayDeque<String>();
		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		queue.offer("정여명");
		queue.offer("신용하");
		queue.offer("차다은");
		queue.offer("이상진");

		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
	}

}