import sys
sys.setrecursionlimit(10 ** 6)

def dfs(nx, ny, num):
    global area
    global visited
    d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for (dx, dy) in d:
        x = nx + dx
        y = ny + dy
        if x < 0 or x >= n or y < 0 or y >= n:
            continue

        # print(f"area{area[y][x]} visited :  {visited}")
        if area[y][x] > num and not visited[y][x]:
            visited[y][x] = True
            dfs(x, y, num)


n = int(input())


def is_safe(value):
    if int(value) > n:
        return int(value)
    else:
        return 0


area = []
maxNum = -1
maxCount = 0

for i in range(n):
    row = list(map(int, input().split()))
    temp_max = max(row)
    if maxNum < temp_max:
        maxNum = temp_max
    area.append(row)

for a in range(maxNum):
    count = 0
    visited = [[False] * n for _ in range(n)]
    for j in range(n):
        for k in range(n):
            if area[j][k] > a and not visited[j][k]:
                visited[j][k] = True
                dfs(k, j, a)
                count += 1
    if maxCount < count:
        maxCount = count
print(maxCount)
