from collections import deque

N, M, v = map(int,input().split())
graph = [[0] * N for _ in range(N)]
dfs_visited = [False] * N
bfs_visited = [False] * N

for _ in range(M):
    a, b = map(int, input().split())
    graph[a-1][b-1] = graph[b-1][a-1] = 1


def dfs(start):
    dfs_visited[start] = True
    print(start+1, end=' ')
    for i in range(N):
        if not dfs_visited[i] and graph[start][i] == 1:
            dfs(i)


def bfs(start):
    bfs_visited[start] = True
    queue = deque()
    queue.append((start, 0))
    while queue:
        x, y = queue.popleft()
        print(x+1, end=' ')

        for i in range(N):
            if not bfs_visited[i] and graph[x][i] == 1:
                bfs_visited[i] = True
                queue.append((i, 0))


dfs(v-1)
print()
bfs(v-1)