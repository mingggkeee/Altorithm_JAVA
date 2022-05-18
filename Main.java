import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int P = sc.nextInt();
		
		int lp = L * P;
		
		int[] per = new int[5];
		
		for(int i=0; i<5; i++) {
			per[i] = sc.nextInt();
			per[i] = per[i] - lp;
		}
		
		for(int i : per) {
			System.out.print(i+" ");
		}
		
		sc.close();
	}
		

	
	
}
