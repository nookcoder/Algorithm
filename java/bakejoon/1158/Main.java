import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N;
        int K;
        Deque<Integer> queue = new LinkedList<>();

        sb.append("<");
        String[] commands = br.readLine().split("\\s+");
        N = Integer.parseInt(commands[0]);
        K = Integer.parseInt(commands[1]);

        for(int i=1; i <= N; i++) {
            queue.addLast(i);
        }

        while(queue.size() > 1) {
            for(int i=0; i<K-1; i++) {
                Integer temp = queue.pollFirst();
                queue.addLast(temp);
            }
            sb.append(queue.pollFirst()).append(", ");
        }

        sb.append(queue.pollFirst()).append(">");
        System.out.println(sb);
        br.close();
    }
}
