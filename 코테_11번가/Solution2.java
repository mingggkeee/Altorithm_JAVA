package 코테_11번가;

public class Solution2 {
	
	public static int solution(int[] A) {
		int count = 0;
		int maxLight = -1;
		
		for(int i=0; i<A.length; i++) {
			maxLight = Integer.max(maxLight, A[i]);
			if(i+1 == maxLight) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int[] test = {5,1,2,3,4};
		
		System.out.println(solution(test));
		
	}

}
