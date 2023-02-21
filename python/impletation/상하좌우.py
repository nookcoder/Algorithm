# N = int(input())
# arr = input().split()
#
# v_point = 1
# h_point = 1
#
# for value in arr:
#     if value == 'R' and h_point < N:
#         h_point += 1
#     elif value == 'L' and h_point > 1:
#         h_point -= 1
#     elif value == 'U' and v_point > 1:
#         v_point -= 1
#     elif value == 'D' and h_point < N:
#         v_point += 1
#
# print("{0} {1}".format(v_point, h_point))

N = int(input())
plans = input().split()
x,y = 1,1
dx = [0,0,-1,1]
dy = [1,-1,0,0]
motion_type = ["U", "D", "L", "R"]

for plan in plans:
    for i in range(len(motion_type)):
        if plan == motion_type[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    if nx < 1 or nx > N or ny < 1 or ny > N:
        continue
    x = nx
    y = ny

print(x,y)