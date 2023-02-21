# import heapq
# from collections import deque, Counter
# import sys
#
#
# def get_most_frequency(numbers):
#     cnt = Counter(numbers).most_common(2)
#     if len(numbers) > 1:
#         if cnt[0][1] == cnt[1][1]:
#             return cnt[1][0]
#         else:
#             return cnt[0][0]
#     else:
#         return cnt[0][0]
#
#
# n = int(input())
# num_arr = []
# frequency = []
# sum_num = 0
#
# max_num = 0
# min_num = 0
#
# for i in range(n):
#     num = int(sys.stdin.readline())
#     num_arr.append(num)
#
#     if i == 0:
#         min_num = num
#         max_num = num
#     else:
#         if min_num > num:
#             min_num = num
#         elif max_num < num:
#             max_num = num
#
#     sum_num += num
#
# average = round(sum_num / n)
#
#
# heapq.heapify(num_arr)
# max_fre = get_most_frequency(num_arr)
# center = 0
# for _ in range(n//2 + 1):
#     center = heapq.heappop(num_arr)
#
# range_num = max_num - min_num
#
# print(average)
# print(center)
# print(max_fre)
# print(range_num)

from collections import Counter
import sys

numbers = []
for _ in range(int(input())):
    num = int(sys.stdin.readline())
    numbers.append(num)

numbers.sort()

cnt = Counter(numbers).most_common(2)

print(round(sum(numbers) / len(numbers)))
print(numbers[len(numbers) // 2])
if len(numbers) > 1:
    if cnt[0][1] == cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])
print(max(numbers) - min(numbers))