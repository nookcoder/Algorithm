def dynamic_programming(n):
    global dp
    dp[1], dp[2], dp[3], dp[4], dp[5] = 1,1,1,2,2
    if n <= 5:
        return dp[n]

    for i in range(6, n + 1):
        if dp[i] == 0:
            dp[i] = dynamic_programming(i - 1) + dynamic_programming(i - 5)

    return dp[n]


for _ in range(int(input())):
    a = int(input())
    dp = [0] * 101
    answer = dynamic_programming(a)
    print(answer)


