## 작성한 답안 코드
```python
from collections import deque
N = int(input())
card_list = list(range(1, N + 1))
card_deque = deque(card_list)

while len(card_deque) != 1:
    card_deque.popleft()
    card = card_deque.popleft()
    card_deque.append(card)

print(card_deque[0])
```

## 시간 복잡도 분석 
- 배열을 사용해서 맨 앞의 값을 삭제, 맨 앞의 값을 삭제 후 맨 뒤에 삽입할 경우
  1. 맨 앞의 값을 삭제 : O(n)
  2. 맨 앞의 값을 삭제 후 맨 뒤에 삽입 : 2 * O(n)
  3. 총 반복 횟수 : N - 1 번 

즉 위와 같은 방법으로 코드로 짜면 시간 복잡도가 O(n^2) 이 나오게 된다. 
문제에서는 2초라는 시간 제한과 N <= 500000 이라는 조건이 있고 O(n^2)의 시간 복잡도는 통과할 수 없다. 

> 따라서 삽입/삭제 시간복잡도가 O(1) 인 queue 를 사용해 문제를 접근했다. 
ㅑ