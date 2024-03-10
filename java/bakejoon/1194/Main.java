import java.util.*;
import java.io.*; 

class Main { 
  static int N, M; 
  static int[] dy = {0,0,1,-1};
  static int[] dx = {0,0,1,-1}; 
  static char[][] board; 
  static Node start; 
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken()); 
    board = new char[N][M];  
    for(int i=0; i<N; i++) {
      board[i] = br.readLine().toCharArray();  
      for(int j=0; j<M && start == null; j++) {
        char c = board[i][j]; 
        if(c == '0') start = new Node(j, i, 0, 0);
      }
    }

    System.out.printf("%d %d", start.getX(), start.getY());
  }

  public static boolean isIn(int x, int y) {
    if(x >= 0 && x <=M && y >= 0 && y <= N) {
      return true;
    }

    return false;
  }
}

class Node { 
  private int x; 
  private int y; 
  private int count; 
  private int key; 

  public Node(int x, int y, int count, int key) {
    this.x = x; 
    this.y = y; 
    this.count = count; 
    this.key = key; 
  }

  public int getX() { 
    return this.x; 
  }

  public int getY() {
    return this.y; 
  }

  public int getCount() { 
    return this.count; 
  }

}
