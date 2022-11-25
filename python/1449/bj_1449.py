N, L = map(int, input().split())
position = list(map(int, input().split()))

if L == 1:
    print(len(position))

else:
    count = 1
    position.sort()
    allow = position[0] + L - 1
    for element in position:
        if allow < element:
            count += 1
            allow = element + L - 1
    print(count)
