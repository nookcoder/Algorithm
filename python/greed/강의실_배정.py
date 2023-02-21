from collections import deque
import sys

def arrange_class(arr):
    end, start = arr.popleft()
    for i in range(len(arr)):
        m_end, m_start = arr.popleft()
        if end <= m_end and end <= m_start:
            end = m_end
            start = m_start
        else:
            arr.append([m_end, m_start])
    return arr


n = int(input())

answer = 0
time_tables = []

for _ in range(n):
    a, b = map(int, input().split())
    time_tables.append([b,a])

time_tables = sorted(time_tables, key=lambda x: [x[0], x[1]])
time_tables = deque(time_tables)
while time_tables:
    time_tables = arrange_class(time_tables)
    answer += 1

print(answer)

