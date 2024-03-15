import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N, n=0;
        String[] temp;
        Stack<Integer> stack = new Stack<>();
        N = Integer.parseInt(br.readLine());
        int[] answers = new int[N];
        int[] numbers = new int[N];
        temp = br.readLine().split("\\s+");
        for(String t: temp) {
            numbers[n++] = Integer.parseInt(t);
        }

        n=0;
        for(String t: temp) {
            Integer ti = Integer.parseInt(t);

            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && numbers[stack.peek()] < ti) {
                    answers[stack.pop()] = ti;
                }
                stack.push(n);
            } else {
                stack.push(n);
            }
            n++;
        }

        while(!stack.isEmpty()) {
            answers[stack.pop()] = -1;
        }
        for(int i=0; i<N; i++) {
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }
}
