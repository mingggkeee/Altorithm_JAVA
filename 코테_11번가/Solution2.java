package 코테_11번가;

public class Solution2 {
	
	public static int solution(int[] A) {
		int count = 0;
		
		boolean[] isVisited = new boolean[A.length+1];
		
		for(int num : A) {
			
			isVisited[num] = true;
			boolean check = true;
			
			for(int i=1; i<=num; i++) {
				if(!isVisited[i]) {
					check = false;
					break;
				}
			}
			
			if(check) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int[] test = {5, 2, 1, 3, 4, 10, 8, 7, 9, 6};
		
		System.out.println(solution(test));
		
	}

}
