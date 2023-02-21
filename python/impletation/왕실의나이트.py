board_x = ['a','b','c','d','e','f','g','h']
board_y = ['1','2','3','4','5','6','7','8']

dx = [2,2,1,-1,-2,-2,1,-1]
dy = [1,-1,-2,-2,1,-1,2,2]

start = input()

start_x = start[0]
start_y = start[1]

x = board_x.index(start_x)
y = board_y.index(start_y)

count = 0

for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]

    if nx < 0 or nx > 7 or ny < 0 or ny > 7:
        continue

    count += 1

print(count)
