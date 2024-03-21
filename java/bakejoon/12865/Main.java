import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dp;
    StringTokenizer st;

    int N, K;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dp = new int[K+1];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 무게
      int k = Integer.parseInt(st.nextToken()); // 가치
      if(n > K) {
        continue;
      }
      if(dp[K] < k) {
        dp[K] = k;
      }

      for(int j=K; j>n; j--) {
        if(dp[j-n] != 0 && dp[j] < dp[j-n] + k) {
          dp[j] = dp[j-n] + k;
          if(dp[K] < dp[j]) {
            dp[K] = dp[j];
          }
        }
      }
      if(dp[n] < k) {
        dp[n] = k;
      }
    }
    System.out.println(dp[K]);
  }
}