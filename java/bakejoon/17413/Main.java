import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        String st;
        boolean inTag = false;

        st = br.readLine();

        for(int i=0; i<st.length(); i++) {
            char c = st.charAt(i);
            switch(c) {
                case ' ':
                    if(!inTag) { // 태그 밖인데 공백을 만나면 stack 에 있는 거 출력
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(" ");
                    } else { // 태그 안이면 바꾸지 않고 그대로 넣기
                        sb.append(c);
                    }
                    break;
                case '<':
                    inTag = true;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                    break;
                case '>':
                    inTag = false;
                    sb.append(c);
                    break;
                default:
                    if(!inTag) {
                        stack.push(c);
                    } else { // 공백일 때와 동일
                        sb.append(c);
                    }
                    break;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
        br.close();
    }
}
