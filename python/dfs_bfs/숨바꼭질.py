# from collections import deque
#
# MAX = 10 ** 5
# dist = [0] * (MAX + 1)
# start, target = map(int,input().split())
# is_find = False
#
#
# if start == target:
#     print(0)
#
# else:
#     queue = deque([start])
#
#     while not is_find:
#         new_start = queue.popleft()
#         if new_start == target:
#             print(dist[new_start] + 1)
#             is_find = True
#
#         else:
#             for v in [new_start + 1, new_start -1, new_start * 2]:
#                 if 0 <= v <= MAX and dist[v] == 0:
#                     dist[v] += dist[new_start] + 1
#                     queue.append(v)

import sys
from collections import deque
input = sys.stdin.readline()

def bfs():
    q = deque()
    q.append(n)
    while q:
        x = q.popleft()
        if x == k:
            print(dist[x])
            break

        for j in (x-1,x+1,x*2):
            if 0<= j <= MAX and not dist[j]:
                print(dist[j])
                dist[j] = dist[x] +1
                q.append(j)
        print(dist)
MAX = 20
n,k = map(int,input.split())
dist = [0] * (MAX+1)

bfs()