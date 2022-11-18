# from itertools import combinations
# import sys

# arr = []
# for _ in range(0,9):
#     arr.append(int(sys.stdin.readline()))
# total = sum(arr)
# arr_comb = combinations(arr, 2)
# arr.sort()
# for one, two in list(arr_comb):
#     if total - (one + two) == 100:
#         arr.remove(one)
#         arr.remove(two)
#         break
#
# for v in arr:
#     print(v)
from itertools import combinations as cb
arr = [int(input()) for _ in range(9)]

for values in cb(arr, 7):
    if sum(values) == 100:
        for value in sorted(values):
            print(value)
        break


