import java.util.Scanner;
import java.util.Stack;

class Main {
  private static int N;

  public static void main(String[] args) {
    Integer number;
    String command;
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    Stack<Integer> st = new Stack<>();
    N = sc.nextInt();

    for(int i=0; i<N; i++) {
      command = sc.next();
      switch(command) {
        case "push":
          number = sc.nextInt();
          st.push(number);
          break;

        case "pop":
          if(!st.empty()){
            number = st.pop();
            sb.append(number).append('\n');
          } else {
            sb.append(-1).append('\n');
          }
          break;

        case "size":
          number = st.size();
          sb.append(number).append('\n');
          break;

        case "empty":
          if(st.empty()) {
            sb.append(1).append('\n');
          } else {
            sb.append(0).append('\n');
          }
          break;

        case "top":
          if(!st.isEmpty()) {
            number = st.peek();
            sb.append(number).append('\n');
          } else {
            sb.append(-1).append('\n');
          }
          break;
      }
    }

    System.out.println(sb);

  }

}