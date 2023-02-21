# import sys
# from sys import stdin
# sys.setrecursionlimit(10 ** 6)
#
#
# def dfs(v):
#     visited[v] = True
#     for e in adj[v]:
#         if not visited[e]:
#             dfs(e)
#
#
# n, m = map(int, stdin.readline().split())
# adj = [[] for _ in range(n)]
# visited = [False] * n
# answer = 0
#
# for _ in range(m):
#     u, v = map(int, input().split())
#     adj[u - 1].append(v - 1)
#     adj[v - 1].append(u - 1)
#
#
# for j in range(0,n):
#     if not visited[j]:
#         dfs(j)
#         answer += 1
#
# print(answer)
#

# import sys
#
# sys.setrecursionlimit(10 ** 6)
#
# n, m = map(int, input().split())
#
# board = [[0] * n for _ in range(n)]
#
# for _ in range(m):
#     a, b = map(int, input().split())
#     board[a-1][b-1] = 1
#     board[b-1][a-1] = 1
#
#
# def dfs(x, y):
#     board[y][x] = 0
#     board[x][y] = 0
#
#     for k in range(n):
#         if board[x][k] == 1:
#             dfs(k, x)
#     return
#
#
# answer = 0
# for i in range(n):
#     for j in range(n):
#         if board[i][j] == 1:
#             dfs(j, i)
#             answer += 1
#
# print(answer)

import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(v):
    visited[v] = True
    for i in graph[v]:
        if visited[i] == False:
            visited[i] = True
            dfs(i)

count = 0
for i in range(1, n+1):
    if visited[i] == False:
        count+=1
        dfs(i)

print(count)