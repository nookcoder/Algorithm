import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static char[][] board;
    static int R, C;
    static int[] dy = {-1,0,1};
    static int answer = 0;
    static boolean isChecked = false;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<R; i++) {
            isChecked = false;
            dfs(new Node(i, 0));
        }

        System.out.println(answer);
    }

    public static void dfs(Node node) {
        if(isChecked || !isIn(node) || board[node.y][node.x] != '.' || visited[node.y][node.x]) { // 범위 밖에 있거나 벽일 때이거나 방문했던 곳일 때
            return;
        }
        if(node.x == C - 1) { // 빵집의 열에 도착했을 때
            isChecked = true;
            answer++; // 파이프라인 설치 완료
            return;
        }

        visited[node.y][node.x] = true;
        board[node.y][node.x] = 'O';
        for(int i=0; i<3; i++) {
            dfs(new Node(node.y + dy[i], node.x + 1));
        }
    }

    public static boolean isIn(Node node) {
        if(node.y >= 0 && node.y < R && node.x >= 0 && node.x < C) {
            return true;
        }
        return false;
    }
}

class Node {
    public int y;
    public int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
