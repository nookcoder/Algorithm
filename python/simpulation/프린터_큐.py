from collections import deque
import sys


input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    answer = 0
    count, find_index = map(int, input().split())
    arr = list(map(int, input().split()))
    file_input = deque([])

    for i in range(len(arr)):
        file_input.append((arr[i], i))

    while file_input:
        is_pop = True
        for i in range(len(file_input)):
            if file_input[0][0] < file_input[i][0]:
                temp_num, temp_index = file_input.popleft()
                file_input.append((temp_num, temp_index))
                is_pop = False
                break

        if is_pop:
            target, target_index = file_input.popleft()
            answer += 1
            if target_index == find_index:
                print(answer)
                file_input = []



