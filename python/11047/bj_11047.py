import sys

N, K = map(int, input().split())
coin_list = [int(sys.stdin.readline()) for _ in range(N)]
count = 0
coin = coin_list.pop()

while K > 0:
    if K >= coin:
        count += K // coin
        K %= coin
    else:
        coin = coin_list.pop()

print(count)


