package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            stringTokenizer = new StringTokenizer(br.readLine());
            String input = stringTokenizer.nextToken();
            
            if(input.equals("push")){
                int x = Integer.parseInt(stringTokenizer.nextToken());
                stack.add(x);
            }
            else if(input.equals("pop"))
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            else if(input.equals("size"))
                System.out.println(stack.size());
            else if(input.equals("empty"))
                System.out.println(stack.isEmpty() ? 1 : 0);
            else    
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
        }
        br.close();
    }
}