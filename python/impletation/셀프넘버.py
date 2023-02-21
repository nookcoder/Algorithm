def d(n):
    value = n
    while n:
        value += n % 10
        n //= 10
    return value


for i in range(10000):
    check = False
    for j in range(i):
        if d(j+1) == i+1:
            check = True
            break

    if not check:
        print(i+1)
