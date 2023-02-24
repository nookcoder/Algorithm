from collections import deque

col, row = map(int, input().split())
board = []
counts = [[1] * row for _ in range(col)]
for i in range(col):
    char_ls = list(str(input()))
    board.append(char_ls)

max_num = 0
def bfs(m_board):
    global max_num
    queue = deque([(0, 0, [m_board[0][0]])])
    d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while queue:
        x, y, chk = queue.popleft()
        for dx, dy in d:
            nx = x + dx
            ny = y + dy

            if nx < 0 or nx >= row or ny < 0 or ny >= col:
                continue

            if m_board[ny][nx] in chk:
                continue

            counts[ny][nx] = counts[y][x] + 1
            if max_num < counts[ny][nx]:
                max_num = counts[ny][nx]
            queue.append((nx, ny, [*chk, m_board[ny][nx]]))


bfs(m_board=board)
print(max_num)
import sys

# bfs 풀이
# bfs
# def bfs():
#     global cnt
#     queue = set([(0, 0, graph[0][0])]) # 시간 초과를 줄이기 위해 중복되는 곳은 제거
#
#     while queue:
#         x, y, z = queue.pop()
#
#         # 말이 지날 수 있는 최대의 칸 초기화
#         cnt = max(cnt, len(z))
#
#         # 상/하/좌/우 탐색
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#
#             # 범위 내에 있고 알파벳이 중복이 안된다면 탐색
#             if 0 <= nx < r and 0 <= ny < c and graph[nx][ny] not in z:
#                 queue.add((nx, ny, graph[nx][ny] + z))
#
#
# r, c = map(int, sys.stdin.readline().split())
#
# graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(r)]
#
# dx = [1, -1, 0, 0]
# dy = [0, 0, 1, -1]
# cnt = 1
#
# bfs()
# print(cnt)