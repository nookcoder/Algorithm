import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int answer = bfs(S);
        System.out.println(answer);
    }

    public static int bfs(int S) {
        int answer = 0;
        boolean[][] visited = new boolean[1001][1001];
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, 1, 0); // 노드 초기화
        queue.add(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // 답
            if(currentNode.value == S) {
                answer = currentNode.count;
                break;
            // 클립보드 붙여넣기
            if(currentNode.clipboard != 0 && !visited[currentNode.clipboard][currentNode.value + currentNode.clipboard] && currentNode.value + currentNode.clipboard <= 1000) {
                Node pasteNode = new Node( currentNode.clipboard, currentNode.value + currentNode.clipboard, currentNode.count + 1);
                visited[currentNode.clipboard][currentNode.value + currentNode.clipboard] = true;
                queue.add(pasteNode);
            }

            // 클립보드에 복사하기
            Node copyNode = new Node(currentNode.value, currentNode.value, currentNode.count + 1);
            queue.add(copyNode);

            // 화면 이모지 1개 없애기
            if(currentNode.value - 1 > 0 && !visited[currentNode.clipboard][currentNode.value - 1]) {
                Node minusNode = new Node( currentNode.clipboard, currentNode.value -1, currentNode.count+1);
                visited[currentNode.clipboard][currentNode.value - 1] = true;
                queue.add(minusNode);
            }
        }

        return answer;
    }

    public static class Node {
        int clipboard; // 클립보드에 담겨있는 이모지 갯수
        int count; // 횟수
        int value; // 화면상에 있는 이모티콘 갯수

        public Node(int clipboard, int value, int count) {
            this.clipboard = clipboard;
            this.value = value;
            this.count = count;
        }
    }
}