package 코테_11번가;

public class Solution1 {
	
	public static int solution(int A, int B) {
		
		if(A > B) {
			return -1;
		} else {
			
			String compareA = Integer.toString(A);
			String compareB = Integer.toString(B);
			
			for(int i=0; i<compareB.length()-compareA.length(); i++) {
				
				String compare = compareB.substring(i, i+compareA.length());
				if(compare.equals(compareA)) {
					return i;
				}
				
			}
			
			
			return -1;
			
		}
		
	}
	
	public static void main(String[] args) {
		int answer = solution(57, 153786);
		
		System.out.println(answer);
	}

}
