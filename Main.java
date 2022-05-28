import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] hamb = new int[3];
		int[] drink = new int[2];
		
		for(int i=0; i<3; i++) {
			hamb[i] = sc.nextInt();
		}
		
		for(int i=0; i<2; i++) {
			drink[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				int comp = hamb[i] + drink[j];
				if(comp < min) {
					min = comp;
				}
			}
		}
		
		System.out.println(min-50);
		
		sc.close();

	}
		

	
	
}
