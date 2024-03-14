import java.util.Scanner; 
import java.util.Stack;

class Main {
  public static StringBuffer sb = new StringBuffer(); 
  public static void main(String[] args) {
    int N; 
    String temp; 
    String[] words; 
    Scanner sc = new Scanner(System.in); 
    
    N = sc.nextInt();
    sc.nextLine();

    for(int i=0; i<N; i++) { // N번 반복하기 O(n)
      temp = sc.nextLine(); 
      words = temp.split("\\s+");
      reverse(words);
    }
    
    System.out.println(sb);
    sc.close(); 
  }

  public static void reverse(String[] _words) {
    Stack<Character> st = new Stack<>(); 
    for(String word: _words) { // O(k) k <= 1000
      for(int i=0; i<word.length(); i++) { // O(m) m <= 20
        st.push(word.charAt(i));
      }

      while (!st.empty()) {
        sb.append(st.pop()); 
      }

      sb.append(" ");
    } 

    sb.append("\n");
  }
}
