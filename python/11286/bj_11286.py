import heapq
import sys

N = int(input())

heap = []
for _ in range(0, N):
    value = int(sys.stdin.readline())
    if value != 0 :
        heapq.heappush(heap,(abs(value), value))
        continue
    if len(heap) == 0:
        print(0)
    else :
        popped = heapq.heappop(heap)
        print(popped[1])
