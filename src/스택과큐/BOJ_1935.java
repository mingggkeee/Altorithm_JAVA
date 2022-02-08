package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * BOJ_1935_S3_후위표기식2
 * @author "mingggkeee"
 * 스택
 */

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 문자개수
        String input = br.readLine();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            if('A' <= ch && ch <= 'Z') {  // operand
                double d = arr[ch - 'A'];
                stack.push(d);
            }else {  // operator
                double num2 = stack.pop();
                double num1 = stack.pop();
                double temp = 0.0;
                switch(ch) {
                    case '+' :
                        temp = num1 + num2;
                        break;
                    case '-' :
                        temp = num1 - num2;
                        break;
                    case '*' :
                        temp = num1 * num2;
                        break;
                    case '/' :
                        temp = num1 / num2;
                        break;
                }
                stack.push(temp);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}