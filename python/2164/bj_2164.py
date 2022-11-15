from collections import deque
N = int(input())
card_list = list(range(1, N + 1))
card_deque = deque(card_list)

while len(card_deque) != 1:
    card_deque.popleft()
    card = card_deque.popleft()
    card_deque.append(card)

print(card_deque[0])
