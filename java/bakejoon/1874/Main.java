import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer currentValue = 1;
        int n, target;
        int isSuccess = 1;
        stack.push(currentValue++);
        sb.append("+").append("\n");
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            if (isSuccess > 0) {
                while (true) {
                    if (!stack.empty()) {
                        if (target == stack.lastElement()) {
                            stack.pop();
                            sb.append("-").append("\n");
                            break;
                        } else if (target > stack.lastElement()) {
                            if (currentValue <= n) {
                                stack.push(currentValue++);
                                sb.append("+").append("\n");
                            } else {
                                System.out.println("NO");
                                isSuccess = 0;
                                break;
                            }
                        } else {
                            stack.pop();
                            sb.append("-").append("\n");
                        }
                    } else {
                        if(currentValue <= n) {
                            stack.push(currentValue++);
                            sb.append("+").append("\n");
                        } else {
                            System.out.println("NO");
                            isSuccess = 0;
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }

        if (isSuccess > 0) {
            System.out.print(sb);
        }
    }
}
