문제 출처 : [백준11286번](https://hanium.udemy.com/course/comgong_codingtest/learn/lecture/29145830?start=15#notes)

## 작성한 코드
```
import heapq
import sys

N = int(input())

heap = []
for _ in range(0, N):
    value = int(sys.stdin.readline())
    if value != 0 :
        heapq.heappush(heap,(abs(value), value))
        continue
    if len(heap) == 0:
        print(0)
    else :
        popped = heapq.heappop(heap)
        print(popped[1])

```

## 문제 풀이 
- 우선순위 큐(heap) 을 선택한 이유 : 
  - 문제의 핵심은 배열에서 최소 값을 찾아내는 것이다. 
  - Root Node 값이 가장 중요한 우선순위 큐가 해당 문제를 푸는 데 가장 적절한 자료구조라고 생각했다.
  - 삽입/삭제의 시간복잡도 또한 log(N) 이기 때문에 실행시간 1초를 N<100000 범위에서는 넘지 않을 것이라고 판단했다.

### 참고사항 
- python 에서 기본으로 제공하는 input() 때문에 시간 초과가 발생했다. 
- sys 모듈에 있는 readline() 을 사용하면 input() 으로 인한 시간 초과를 없앨 수 있다.i11
