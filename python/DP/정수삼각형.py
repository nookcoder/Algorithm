layer = int(input())
triangle = []
for _ in range(layer):
    arr = list(map(int, input().split()))
    triangle.append(arr)

answer = 0
current_index = 0
for i in range(1, layer):
    for j in range(len(triangle[i])):
        if j == 0:
            triangle[i][j] += triangle[i - 1][j]
        elif j == len(triangle[i]) - 1:
            triangle[i][j] += triangle[i - 1][j - 1]
        else:
            triangle[i][j] = max(triangle[i][j] + triangle[i - 1][j - 1], triangle[i][j] + triangle[i - 1][j])
print(max(triangle[layer - 1]))