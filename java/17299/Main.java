import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N, n=0;
        int[] numbers, answers, counts;
        String[] temp;
        Stack<Integer> stack = new Stack<>();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        answers = new int[N+1];
        counts = new int[1000001];

        temp = br.readLine().split("\\s+");
        for(int i=0; i<temp.length; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
            counts[numbers[i]]++;
        }

        for(int i=N-1; i >= 0; i--) {
            while(!stack.isEmpty() && counts[stack.peek()] <= counts[numbers[i]]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                answers[i] = -1;
            } else {
                answers[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }

        for(int i=0; i<N; i++) {
            if(i != N-1) {
                sb.append(answers[i]).append(" ");
            } else {
                sb.append(answers[i]);
            }
        }

        System.out.println(sb);
    }
}
