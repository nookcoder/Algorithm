from itertools import combinations
# def combinations(m_arr, n):
#     if n == 0:
#         return [[]]
#
#     l = []
#     for i in range(0, len(m_arr)):
#         m = m_arr[i]
#         remain = m_arr[i+1:]
#
#         remain_arr = combinations(remain, n-1)
#         for p in remain_arr:
#             l.append([m, *p])
#
#     return l


n = int(input())
arr = []
min_count = 0
for i in range(n):
    a, b = map(int, input().split())
    arr.append((a,b))

    # 1개만 뽑았을 때
    if i == 0:
        min_count = abs(a - b)
    else:
        if min_count > abs(a-b):
            min_count = abs(a-b)

for j in range(2, n+1):
    comb_arr = list(combinations(arr,j))
    for c in comb_arr:
        multi = 0
        add = 0
        for (x, y) in c:
            if multi == 0:
                multi = x
            else:
                multi *= x

            add += y
        if min_count > abs(multi - add):
            min_count = abs(multi - add)

print(min_count)