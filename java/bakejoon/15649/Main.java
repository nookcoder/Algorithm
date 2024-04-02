import java.util.*; 
import java.io.*; 

public class Main { 
  public static int N, M; 
  public static boolean[] visited; 
  public static StringBuffer sb;
  public static int[] arr;  
  public static void main(String[] args) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st = new StringTokenizer(br.readLine()); 
    sb = new StringBuffer(); 
    N = Integer.parseInt(st.nextToken()); // 최대 숫자 
    M = Integer.parseInt(st.nextToken()); // 수열 갯수 
    visited = new boolean[N+1];
    arr = new int[M+1]; 
    permutation(0); 
  }

  public static void permutation(int size) {
    if(size == M) {
      for(int i=0; i<M; i++) {
        sb.append(arr[i]).append(" ");
      }
      System.out.println(sb); 
      sb.delete(0, sb.length()); 
      return; 
    }

    for(int i=1; i<N+1; i++) {
      if(visited[i]) {
        continue; 
      }
      visited[i] = true; 
      arr[size] = i; 
      permutation(size + 1);
      visited[i] = false; 
    }
  }
  
}
