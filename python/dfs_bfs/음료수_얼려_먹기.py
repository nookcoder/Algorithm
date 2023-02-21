dx = [1,-1,0,0]
dy = [0,0,1,-1]

N, M = map(int, input().split())
visited = [[False] * M for _ in range(N)]
graph = []
for _ in range(N):
    graph.append(list(map(int, input())))
count = 0


def dfs(node_x, node_y):
    visited[node_y][node_x] = True
    for i in range(4):
        nx = node_x + dx[i]
        ny = node_y + dy[i]

        if nx < 0 or nx >= M or ny < 0 or ny >= N:
            continue

        if graph[ny][nx] == 0 and not visited[ny][nx]:
            dfs(nx, ny)


for i in range(N):
    for j in range(M):
        if not visited[i][j] and graph[i][j] == 0:
            dfs(j, i)
            count += 1

print(count)


