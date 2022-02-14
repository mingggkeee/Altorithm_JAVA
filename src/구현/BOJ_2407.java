package 구현;
import java.math.BigInteger;
import java.io.*;

/**
 * BOJ_2497_S3_조합
 * @author "mingggkeee"
 * 조합
 */

public class BOJ_2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s = br.readLine().split(" ");
        int n= Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        for(int i=0; i<m; i++){
            n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
        }

        BigInteger answer = n1.divide(n2);

        System.out.println(answer.toString());
    }
}
