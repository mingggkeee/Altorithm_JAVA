package 문자열;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * BOJ_5430_G5_AC
 * @author mingggkeee
 * 덱, 파싱
 */
public class BOJ_5430 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            boolean print = true;
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            arr = arr.substring(1, arr.length()-1);
            Deque<Object> deque = new ArrayDeque<>();
            if(arr.length()!=0) {
                Object[] nums = Arrays.stream(arr.split(",")).toArray();
                for (int i = 0; i < nums.length; i++) {
                    deque.add(nums[i]);
                }
            }
            // true면 첫번째 수 false면 마지막 수 추출
            boolean check = true;
            for(int i=0; i<command.length(); i++){
                char c = command.charAt(i);
                if(c=='R'){
                    if(check){
                        check = false;
                    } else{
                        check = true;
                    }
                } else if(c=='D'){
                    if(deque.size()==0){
                        bw.write("error\n");
                        print = false;
                        break;
                    }

                    if(check){
                        deque.pollFirst();
                    } else{
                        deque.pollLast();
                    }
                }
            }
            if(print) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                // count가 홀수면 뒤집어진 상태 짝수면 정상인 상태
                while(!deque.isEmpty()) {
                    if (check) {
                        sb.append(deque.pollFirst() + ",");
                    } else {
                        sb.append(deque.pollLast() + ",");
                    }
                }
                if(sb.length()!=1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]");
                bw.write(sb.toString()+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
