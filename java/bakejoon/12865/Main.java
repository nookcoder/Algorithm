import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
  public static void main(final String[] args) {
    int N, K, w, v; 
    int[][] dp; 
    final ArrayList<Integer> W = new ArrayList<>(); 
    final ArrayList<Integer> V = new ArrayList<>(); 

    // input values 
    final Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    K = scanner.nextInt();
    dp = new int[N][K+1];

    // Big-O = O(1)
    for(int i=0; i<N; i++) {
      w = scanner.nextInt(); 
      v = scanner.nextInt(); 
      W.add(w); 
      V.add(v); 
    }

    // initialize dp Big-O = O(K+1 * N) 10,000,000
    for(int i=1; i<K+1; i++) {
      for(int j=0; j<N; j++) {
        final int a = W.get(j); 
        if(i == a) {
          dp[j][i] = V.get(j);
        }
      }
    }



    for(int i=0; i<N; i++) {
      for(int k=1; k<K+1; k++) {
        System.out.print(dp[i][k] + " ");
      }
      System.out.println("");
    }
 }
}
