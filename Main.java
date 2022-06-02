import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s1 = 0;
		int s2 = 0;
		
		for(int i=0; i<4; i++) {
			s1 += sc.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			s2 += sc.nextInt();
		}
		
		if(s1>=s2) {
			System.out.println(s1);
		} else {
			System.out.println(s2);
		}
		
		sc.close();

	}
		

	
	
}
