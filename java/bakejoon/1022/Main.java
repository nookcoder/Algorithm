import java.util.*;
import java.io.*;

public class Main {
    private static int squareSize = 1;
    private static int squareValue = 1;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        int squareCount = 1;
        int r1,c1,r2,c2;
        int startX = 5000, startY = 5000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken()) + 5000;
        c1 = Integer.parseInt(st.nextToken()) + 5000;
        r2 = Integer.parseInt(st.nextToken()) + 5000;
        c2 = Integer.parseInt(st.nextToken()) + 5000;
        map = new int[10001][100001];
        // init
        map[startY][startX] = squareValue++;
        squareSize += 2;
        // 1 2(+1) 11(+9) 28(+17) 53(+25)
        while(true) {
            if(startY > r2 && startX > c2) {
                break;
            }
            map[startY][++startX] = squareValue++; // 오른쪽으로 1번
            for(int i=0; i<squareSize-2; i++) { // 위로 가기
                map[--startY][startX] = squareValue++;
            }
            for(int i=0; i<squareSize-1; i++) { // 왼쪽으로 가기
                map[startY][--startX] = squareValue++;
            }
            for(int i=0; i<squareSize-1; i++) { // 아래로 가기
                map[++startY][startX] = squareValue++;
            }
            for(int i=0; i<squareSize-1; i++) {
                map[startY][++startX] = squareValue++;
            }
            squareSize += 2;
        }
        // 제일 큰 수가 몇 자리 수 인지 (최대 \)
        int count = getMaxPosition(squareValue - 1);
        for(int i=r1; i<r2+1;i++) {
            for(int j=c1; j<c2+1; j++) {
                for(int k=0; k < count - getMaxPosition(map[i][j]); k++) {
                    sb.append(" ");
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int getMaxPosition(int n) {
        int count = 0;
        while(n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
}
