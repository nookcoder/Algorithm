import sys
sys.setrecursionlimit(10 ** 6)


def dfs(row, col, m_board, m_visited):
    d = [(1, 0), (0, -1), (-1, 0), (0, 1)]
    m_visited[col][row] = True
    color = board[col][row]

    for (dx, dy) in d:
        x = row + dx
        y = col + dy

        if x < 0 or x >= len(m_board) or y < 0 or y >= len(board):
            continue

        if not m_visited[y][x]:
            if m_board[y][x] == color:
                dfs(x, y, m_board, m_visited)

    return


def dfs_for_eyes(row, col, m_board, m_visited):
    d = [(1, 0), (0, -1), (-1, 0), (0, 1)]
    m_visited[col][row] = True
    color = board[col][row]

    for (dx, dy) in d:
        x = row + dx
        y = col + dy

        if x < 0 or x >= len(m_board) or y < 0 or y >= len(board):
            continue

        if not m_visited[y][x]:
            if (color == 'R' or color == 'G') and (board[y][x] == 'R' or board[y][x] == 'G'):
                dfs_for_eyes(x, y, m_board, m_visited)
            elif color == "B" and color == board[y][x]:
                dfs_for_eyes(x, y, m_board, m_visited)

    return


n = int(input())

board = [list(input()) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
e_visited = [[False] * n for _ in range(n)]
count = 0
e_count = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(j,i,board,visited)
            count += 1

for i in range(n):
    for j in range(n):
        if not e_visited[i][j]:
            dfs_for_eyes(j,i,board,e_visited)
            e_count += 1


print(count, e_count)