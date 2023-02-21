import sys
sys.setrecursionlimit(10**6)


# 움직일 좌표 셋팅
def dfs(u_x, u_y, u_row, u_col ,u_visited, u_table):
    dx = [1, 0, -1, 0]
    dy = [0, -1, 0, 1]
    for i in range(4):
        nx = u_x + dx[i]
        ny = u_y + dy[i]
        if nx < 0 or ny < 0 or nx >= row or ny >= col:
            continue

        if u_visited[ny][nx]:
            continue

        if not u_visited[ny][nx] and u_table[ny][nx] == 0:
            u_visited[ny][nx] = True
            continue

        if not u_visited[ny][nx] and u_table[ny][nx] == 1:
            u_visited[ny][nx] = True
            dfs(nx, ny, u_row, u_col, u_visited, u_table)


N = int(input())
for _ in range(N):
    row, col, cnt = map(int, input().split())
    count = 0 # 총 지렁이 횟수

    # 배추밭 셋팅
    table = [[0] * row for _ in range(col)]
    for _ in range(cnt):
        x, y = map(int, input().split())
        table[y][x] = 1

    # 방문 확인
    visited = [[False] * row for _ in range(col)]

    for i in range(col):
        for j in range(row):
            if not visited[i][j] and table[i][j] == 1:
                dfs(j, i, row, col, visited, table)
                count += 1

    print(count)

