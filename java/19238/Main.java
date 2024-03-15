import java.util.*; 
import java.io.*; 

class Main { 
  static int N,M;
  static int[][] board;
  static Taxi taxi = new Taxi();
  static Queue<Person> people = new LinkedList<>();
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,1,0,-1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st;
    st = new StringTokenizer(br.readLine()); 
    N = Integer.parseInt(st.nextToken()); 
    M = Integer.parseInt(st.nextToken()); 
    taxi.fuel = Integer.parseInt(st.nextToken()); 
    board = new int[N+1][N+1]; 
    for(int i=1; i<N+1; i++) {
      st = new StringTokenizer(br.readLine()); 
      for(int j=1; j<N+1; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine()); 
    taxi.currentY = Integer.parseInt(st.nextToken());
    taxi.currentX = Integer.parseInt(st.nextToken());
    
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine()); 
      int currentY = Integer.parseInt(st.nextToken());
      int currentX = Integer.parseInt(st.nextToken());
      int targetY = Integer.parseInt(st.nextToken());
      int targetX = Integer.parseInt(st.nextToken());
      int distance = getDistanceFromTaxi(currentX, currentY);
      people.add(new Person(currentX, currentY, targetX, targetY, distance));
    }

    for(int i=0; i<M; i++) {
      List<Person> list = new ArrayList(people);
      Collections.sort(list, new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
          if(p1.distance != p2.distance) {
            return p1.distance - p2.distance;
          } else {
            if(p1.currentY != p2.currentY) {
              return p1.currentY - p2.currentY;
            } else {
              return p1.currentX - p2.currentX;
            }
          }
        }
      });
      people.clear();
      people.addAll(list);

      Person p = people.poll();
      if(p.distance < 0) { // 승객을 태울 수 없을 때
        System.out.println(-1);
        return;
      }
      taxi.fuel -= p.distance; // 택시가 손님을 태울 때까지
      if(taxi.fuel <= 0) {
        System.out.println(-1);
        return;
      }
      int distance = getDistance(p.currentX, p.currentY, p.targetX, p.targetY); // 손님을 목적지까지 이동
      taxi.fuel -= distance;
      if(taxi.fuel < 0) { // 도착하지 못할 때
        System.out.println(-1);
        return;
      }
      taxi.fuel += distance * 2; // 이동거리의 2배만큼
      taxi.currentX = p.targetX;
      taxi.currentY = p.targetY;
      // 남은 사람들 갱신
      int size = people.size();
      for(int j=0; j<size; j++) {
        Person rp = people.poll();
        rp.distance = getDistanceFromTaxi(rp.currentX, rp.currentY);
        people.add(rp);
      }
    }

    System.out.println(taxi.fuel);
  }

  public static int getDistance(int cX, int cY, int tX, int tY) {
    Node c = new Node(cX, cY, 0);
    Node t = new Node(tX, tY, 0);
    boolean[][] visited = new boolean[N + 1][N + 1];
    Queue<Node> q = new LinkedList<>();
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    q.add(c);
    while (!q.isEmpty()) {
      Node temp = q.poll();
      for (int i = 0; i < 4; i++) {
        int x = temp.x + dx[i];
        int y = temp.y + dy[i];
        if (isIn(x,y) && x == t.x && y == t.y && board[y][x] == 0) {
          return temp.d + 1;
        }

        if(isIn(x,y) && !visited[y][x] && board[y][x] == 0) {
          visited[y][x] = true;
          Node node = new Node(x,y,temp.d+1);
          q.add(node);
        }
      }
    }
    return -1;
  }

  public static Person getPerson() {
    Node taxiNode = new Node(taxi.currentX, taxi.currentY);
    boolean[][] visited = new boolean[N+1][N+1];
    Queue<Node> q = new LinkedList<>();

    q.add(taxiNode);

    while(!q.isEmpty()) {
      Node temp = q.poll();

      for(int i=0; i<4; i++) {
        int x = temp.x + dx[i];
        int y = temp.y + dy[i];
        if(isIn(x,y) && board[y][x] > 1) {

        }

        if(isIn(x,y) && !visited[y][x] && board[y][x] == 0) {
          visited[y][x] = true;
          q.add(new Node(x,y,0))
        }
      }
    }
  }

  public static int getDistanceFromTaxi(int currentX, int currentY) {
    if(currentX == taxi.currentX && currentY == taxi.currentY) {
      return 0;
    }
    Node taxiNode = new Node(taxi.currentX, taxi.currentY, 0); 
    Node personNode = new Node(currentX, currentY, 0);
    boolean[][] visited = new boolean[N+1][N+1];
    Queue<Node> q = new LinkedList<>(); 
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int dis = -1; 
    q.add(taxiNode); 
    visited[taxi.currentY][taxi.currentX] = true;
    while(!q.isEmpty()) {
      Node tempNode = q.poll();
      for(int i=0; i<4; i++) {
        int x = tempNode.x + dx[i];
        int y = tempNode.y + dy[i];
        if(isIn(x,y) && x == personNode.x && y == personNode.y && board[y][x] == 0) {
          return tempNode.d + 1;
        }

        if(isIn(x,y) && !visited[y][x] && board[y][x] == 0) {
          visited[y][x] = true; 
          Node node = new Node(x,y,tempNode.d+1); 
          q.add(node);
        }
      }
    }

    return -1;
  }

  public static boolean isIn(int x, int y) {
    if(x>=1 && x<=N && y >= 1 && y <= N) {
      return true; 
    }

    return false;
  }
}

class Person {
  public int currentX; 
  public int currentY; 
  public int targetX;
  public int targetY; 
  public int distance; 

  public Person(int currentX, int currentY, int targetX, int targetY) {
    this.currentY = currentY;
    this.currentX = currentX; 
    this.targetX = targetX;
    this.targetY = targetY; 
  }

  public Person(int currentX, int currentY, int targetX, int targetY, int distance) {
    this.currentY = currentY;
    this.currentX = currentX;
    this.targetX = targetX;
    this.targetY = targetY;
    this.distance = distance;
  }
}

class Taxi { 
  public int currentX; 
  public int currentY; 
  public int fuel;
  
  public Taxi(int currentX, int currentY, int fuel) {
    this.currentX = currentX; 
    this.currentY = currentY; 
    this.fuel = fuel;
  }

  public Taxi() {}
}

class Node { 
  public int x; 
  public int y; 
  public int d;

  public Node(int x, int y, int d) {
    this.x = x; 
    this.y = y; 
    this.d = d; 
  }
}
