# 나누기 안되면 빼기 이용하기 (그리디)
def deliver(n):
    count = 0
    while n > 0:
        if n % 5 == 0:
            count += n // 5
            n = 0
        else:
            count += 1
            n -= 3

    if n == 0:
        return count

    return -1


N = int(input())
print(deliver(N))