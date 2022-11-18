문제 출처 : [일곱 난쟁이/백준2309](https://www.acmicpc.net/problem/2309)

## 작성한 코드

```python
from itertools import combinations
import sys

arr = []
for _ in range(0,9):
    arr.append(int(sys.stdin.readline()))

# 9명의 난쟁이 키의 총합
total = sum(arr)

# 제외할 난장이 2명 선택 
arr_comb = combinations(arr, 2)
arr.sort()

# 난장이 2명의 키를 뺐을 때 100이 되면 출력
for one, two in list(arr_comb):
    if total - (one + two) == 100:
        arr.remove(one)
        arr.remove(two)
        break

for v in arr:
    print(v)



```

```python
from itertools import combinations as cb 
arr = [int(input()) for _ in range(9)]

# 난장이 7명 무작위 선택 
for values in cb(arr, 7):
    # 난쟁이 키가 100이면 출력 및 반복문 탈출
    if sum(values) == 100: 
        for value in sorted(values):
            print(value)
        break
```

## 문제 풀이 

경우의 수가 9C2 로 총 36가지 밖에 되지 않았기 때문에 완전 탐색으로 풀이했다.  

총 2가지 방법으로 풀어봤다.
- 총 합에서  2개의 수를 빼는 방법 
- 7개의 수를 뽑아서 더하는 방법 

파이썬은 조합, 순열 등이 내장함수로 구현 되어있기 때문에 combinations 함수를 사용해서 풀이를 진행했다. 
