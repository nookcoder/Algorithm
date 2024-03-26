import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    int[][] cities;
    int[] targets; 
    boolean[][] visited; 
    int start, end; 
    byte isAllowed = 1; 
    Queue<Integer> queue = new LinkedList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 도시 수
    int M = Integer.parseInt(br.readLine());; // 여행할 도시 수
    cities = new int[N+1][N+1];
    targets = new int[M];
    for(int i=1; i<N+1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1; j<N+1; j++) {
        cities[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    StringTokenizer st2 = new StringTokenizer(br.readLine()); 
    for(int i=0; i<M; i++) {
      targets[i] = Integer.parseInt(st2.nextToken()); 
    }

    if(M == 1) {
      if(cities[1][1] == 1) {
        System.out.print("YES");
      } else {
        System.out.print("NO");
      }
      return;
    }
    for(int j=0; j<M-1; j++) {
      if(isAllowed == 0) {
        break;
      } else {
        start = targets[j];
        end = targets[j+1];
        if(start == end) {
          isAllowed = 1; 
          continue;
        }
        isAllowed = 0; 
        visited = new boolean[N+1][N+1];
        queue.add(start);
        while(!queue.isEmpty()){
          int target = queue.poll(); 
          for(int i=1; i<N+1; i++) {
            if(i == target) {
              continue; 
            }

            if(i==end && cities[target][i] == 1) {
              isAllowed = 1;
              queue.clear(); 
              break;
            }

            if(cities[target][i] == 1 && !visited[target][i]) {
              queue.add(i);
              visited[target][i] = true; 
            }
          }
        }
      }
    }
    if(isAllowed == 1) {
      System.out.print("YES");
    } else { 
      System.out.print("NO");
    }
    return;   
  }
}
