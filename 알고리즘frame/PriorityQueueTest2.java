package 알고리즘frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest2 {
	
	public static void main(String[] args) {
		byList();
		pqTest();
	}
	
	private static void byList() {
		List<Person> list = new ArrayList<>();
		for(int i=0; i<persons.length; i++) {
			list.add(persons[i]);
		}
		
		// 이름의 오름 차순 정렬
		Collections.sort(list, (p1, p2) -> p1.name.compareTo(p2.name));
		System.out.println(list);
		// 나이 오름차순
		Collections.sort(list, (p1, p2) -> Integer.compare(p1.age, p2.age));
		System.out.println(list);
		// 홍길동 회춘
		persons[0].age = 5;
		Collections.sort(list, (p1, p2) -> Integer.compare(p1.age, p2.age));
		System.out.println(list);
		
	}
	
	private static void pqTest() {
		// 3. 방문 여부 확인해주기
		boolean [] visited = new boolean[persons.length];
		
		PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.age, p2.age));
		for(int i=0; i<persons.length; i++) {
			pq.offer(persons[i]);
		}
		
		// 홍길동 회춘
		persons[0].age = 5;
		// 2. 데이터 추가해보기
		pq.offer(persons[0]);
		
		// 1. PriorityQueue는 언제 reordering하나 : 큐에 삭제, 추가 연산이 있는 시점에서!
		while(!pq.isEmpty()) {
			Person head = pq.poll();
			if(visited[head.idx]) {
				continue;
			}
			visited[head.idx] = true; 
			System.out.println(head);
		}
	}
	
	static Person [] persons = {
			new Person(0, "홍길동", 50),
			new Person(1, "장길산", 20),
			new Person(2, "임꺽정", 30),
			new Person(3, "이몽룡", 10)
	};
	
	static class Person{
		int idx;
		String name;
		int age;
		
		public Person(int idx, String name, int age) {
			super();
			this.idx = idx;
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return " [i=" + idx + ", n=" + name + ", a=" + age + "]";
		}
		
		
	}
}
