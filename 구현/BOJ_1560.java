package 구현;

import java.math.BigInteger;
import java.util.Scanner;
 
public class BOJ_1560 {
         
    public static void main(String[] args)
    {
                BigInteger num = new BigInteger("0");
         
                Scanner sc = new Scanner(System.in);
                
                num = sc.nextBigInteger();
                
                if(num.compareTo(BigInteger.ONE) == 0) {
                    System.out.println(1);
                }
                
                else if(num.compareTo(BigInteger.valueOf(2)) == 0) {
                    System.out.println(2);
                }
                
                else {
                     System.out.println(num.add(num.subtract(BigInteger.valueOf(2))));
                }
                
                sc.close();
    }
    
}

