# from collections import deque
#
# city_count = int(input())
# distance = deque(list(map(int, input().split())))
# city_price = deque(list(map(int, input().split())))
# distance_index = 0
# answer = 0
#
# queue = city_price.popleft()
# m_distance = distance.popleft()
# answer += queue * m_distance
# while distance:
#     m_distance = distance.popleft()
#     next_queue = city_price.popleft()
#
#     if queue <= next_queue:
#         answer += queue * m_distance
#         print("current_city : ", queue, "answer : ", answer)
#
#     else:
#         answer += next_queue * m_distance
#         queue = next_queue
#         print("current_city : ", queue, "answer : ", answer)
#

city_count = int(input())
distance = list(map(int, input().split()))
city_price = list(map(int, input().split()))
answer = 0
dis_index = 1

price = city_price[0]
answer += price * distance[0]

for i in range(len(city_price) - 2):
    if city_price[i] >= city_price[i+1]:
        price = city_price[i+1]
    answer += price * distance[dis_index]
    dis_index += 1
print(answer)
