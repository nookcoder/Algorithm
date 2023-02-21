import sys
sys.setrecursionlimit(10 ** 6)

def fib(n):
    global r_count
    if n == 1 or n == 2:
        return 1
    r_count += 1
    return fib(n - 1) + fib(n - 2)


def fibonacci(n):
    dp = [0] * (n+1)
    dp[1], dp[2] = 1, 1
    cnt = 0
    for i in range(3, n+1):
        cnt += 1
        dp[i] = dp[i - 1] + dp[i - 2]
    return cnt


r_count = 1
d_count = 1

n = int(input())
fib(n)
print(r_count, fibonacci(n))











