import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static String command;
    private static String[] commands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer st = new StringBuffer();

        Deque<Integer> queue = new LinkedList<>();

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            command = br.readLine();
            commands  = command.split("\\s+");
            switch (commands[0]) {
                case "push":
                    queue.add(Integer.parseInt(commands[1]));
                    break;
                case "pop":
                    if(!queue.isEmpty()) {
                        Integer poll = queue.poll();
                        st.append(poll).append("\n");
                    } else {
                        st.append(-1).append("\n");
                    }
                    break;
                case "size":
                    st.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(!queue.isEmpty()) {
                        st.append(0).append("\n");
                    } else {
                        st.append(1).append("\n");
                    }
                    break;
                case "front":
                    if(!queue.isEmpty()) {
                        st.append(queue.peekFirst()).append("\n");
                    } else {
                        st.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!queue.isEmpty()) {
                        st.append(queue.peekLast()).append("\n");
                    } else {
                        st.append(-1).append("\n");
                    }
                    break;
            }
        }

        System.out.println(st);
        br.close();
    }
}
