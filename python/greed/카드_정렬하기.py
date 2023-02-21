# from collections import deque
# n = int(input())
# number = deque([])
# answer = 0
#
# for _ in range(n):
#     number.append(int(input()))
#
# while len(number) != 1:
#     number = deque(sorted(number))
#     x = number.popleft()
#     y = number.popleft()
#     answer += x + y
#     number.appendleft(x+y)
#
# print(answer)

import heapq
n = int(input())
number = []
answer = 0

for _ in range(n):
    heapq.heappush(number, int(input()))

while len(number) > 1:
    x = heapq.heappop(number)
    y = heapq.heappop(number)
    answer += x + y
    number.append(x+y)

print(answer)