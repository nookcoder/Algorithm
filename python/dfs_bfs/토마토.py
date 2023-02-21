from collections import deque

m, n = map(int, input().split())

board = []
visited = [[False] * m for _ in range(n)]
for i in range(n):
    board.append(list(map(int, (input().split()))))

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

queue = deque()

for k in range(n):
    for l in range(m):
        if board[k][l] == 1:
            queue.append((l, k))

while queue:
    x, y = queue.popleft()
    for j in range(4):
        nx = x + dx[j]
        ny = y + dy[j]

        if nx < 0 or nx >= m or ny < 0 or ny >= n:
            continue

        if board[ny][nx] == 0 and not visited[ny][nx]:
            board[ny][nx] = board[y][x] + 1
            visited[ny][nx] = True
            queue.append((nx, ny))

chk = False

for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            chk = True

if chk:
    print(-1)
else:
    print(board[y][x] - 1)
