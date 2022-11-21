문제 출처 :  [동전 0(백준 11047번)](https://www.acmicpc.net/problem/11047)

## 작성한 코드 
```python
import sys

N, K = map(int, input().split())
coin_list = [int(sys.stdin.readline()) for _ in range(N)]
count = 0
coin = coin_list.pop()

while K > 0:
    if K >= coin:
        count += K // coin
        K %= coin
    else:
        coin = coin_list.pop()

print(count)



```
## 문제풀이 
- 문제 조건에 Ai는 Ai-1의 배수라는 조건이 있었다. 
- 문제에서는 최선의 방법을 찾아야 하고 위의 조건때문에 최선의 방법을 찾을 때 반례가 발생하지 않기 때문에 __그리디__ 알고리즘을 사용해서 풀기로 결정

## 작성했던 코드
```python
import sys

N, K = map(int, input().split())
coin_list = [int(sys.stdin.readline()) for _ in range(N)]
count = 0
coin = coin_list.pop()

while K != 0:
    if K >= coin:
        K -= coin
        count += 1

    elif K < coin:
        coin = coin_list.pop()

print(count)

```
- 동전의 갯수를 구할 때 빼기를 사용하여 시간초과 발생.
- 다하기 빼기만 사용하지말고 곱하기 나누기도 고려해 볼 것.

```python
import sys
sys.setrecursionlimit(10000)

def count_coin(current_total, coin, current_list,count):
    if current_total >= coin:
        current_total -= coin
        count += 1
        return count_coin(current_total, coin, current_list,count)

    elif current_total < coin and current_total != 0:
        coin = current_list.pop()
        return count_coin(current_total, coin, current_list, count)
    else:
        return count

 
N, K = map(int, input().split())
coin_list = [int(input()) for _ in range(N)]

_count = count_coin(K, coin_list.pop(), coin_list, 0)
print(_count)

```

- 재귀함수를 사용해서 RecursionError 발생 
- 백준 채점 서버는 Recursionlimit 이 1,000 이기 때문에 설정된 depth 를 초과했기 때문.
- sys.setrecursionlimit() 를 사용하면 해결할 수 있지만 실제 운영하는 컴퓨터라고 생각하면 설정값을 바꿔야 한다는 것 자체가 알고리즘을 잘못 선택했다고 생각한다. 
- 따라서 꼭 재귀함수를 사용해야하는 상황이 아니면 다른 방법을 고안해 볼 것 