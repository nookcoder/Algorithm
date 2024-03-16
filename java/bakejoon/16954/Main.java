import java.util.*; 
import java.io.*; 

class Main { 
  public static void main(String[] args) throws IOException {
    boolean isAllowed = false;
    char[][] tempboard = new char[8][8];
    int[][] values = {{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {0, 0}};
    Queue<Pos> queue = new LinkedList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < 8; i++) {
      tempboard[i] = br.readLine().toCharArray();
    }
    br.close();

    queue.add(new Pos(0, 7, tempboard));

    while (!queue.isEmpty()) {
      Pos currentPot = queue.poll();
      char[][] board = currentPot.board;
      // 현재 위치에 벽이 있는 지 검사
      if (board[currentPot.y][currentPot.x] == '#') {
        continue;
      }

      isAllowed = isApproachedDes(board, currentPot);
      if (isAllowed) {
        bw.write("1");
        bw.flush();
        bw.close();
        break;
      }

      // move person 
      for (int i = 0; i < 9; i++) {
        int x = values[i][0];
        int y = values[i][1];
        int nextX = currentPot.x + x;
        int nextY = currentPot.y + y;

        if (nextY >= 0 && nextY <= 7 && nextX >= 0 && nextX <= 7) {
          if (board[nextY][nextX] != '#') {
            Pos newPot = new Pos(nextX, nextY);
            newPot.setMovedBoard(board);
            queue.add(newPot);
          }
        }
      }
    }

    if (!isAllowed) {
      bw.write("0");
      bw.flush();
      bw.close();
    }
    return;
  }

  public static boolean isApproachedDes(char[][] board, Pos currentPos) {
    int x = currentPos.x; 
    int y = currentPos.y;
    for(int i=0; i<=y; i++) {
      for(int j=7; j>=x; j--) {
        if(board[i][j] == '#'){
          return false; 
        }
      }
    }

    return true; 
  }

  public static void printBoard(char[][] board) {
    System.out.print("\n");
    for(int i=0; i<8; i++) {
      for(int j=0; j<8; j++) {
        System.out.print(board[i][j]);
      }
      System.out.print("\n");
    }
  }
} 

class Pos { 
  public int x; 
  public int y;
  public char[][] board;
  public Pos(int x, int y, char[][] board) {
    this.x = x; 
    this.y = y;
    this.board = board;
  }

  public Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setMovedBoard(char[][] _board) {
    board = new char[8][8];
    for (int i = 0; i < _board.length; i++) {
      for (int j = 0; j < _board[i].length; j++) {
        board[i][j] = _board[i][j];
      }
    }

    for(int i=7; i > 0; i--) {
      for(int j=0; j<8; j++) {
        board[i][j] = board[i-1][j];
      }
    }

    for(int i=0; i<8; i++) { // 맨 윗줄 초기화
      board[0][i] = '.';
    }
  }
}
