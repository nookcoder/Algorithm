import heapq

def best_meeting_time(meeting_times):
    count = 0
    before_end_time = 0
    meeting_times = sorted(meeting_times, key=lambda x: (x[1], x[0]))
    for time in meeting_times:
        start, end = time[0], time[1]

        if start >= before_end_time:
            count += 1
            before_end_time = end

    return count


def best_meeting_time_by_heap(meeting_times):
    room = []
    heapq.heappush(room,meeting_times[0][1])
    answer = 1

    for i in range(1, len(meeting_times)):
        if room[0] > meeting_times[i][0]: # 종료시간보다 다음 시작 시간이 빠를 때
            continue
        else:
            heapq.heappop(room)
            heapq.heappush(room, meeting_times[i][1])
            answer += 1
    return answer


n = int(input())

times = []
for _ in range(n):
    a, b = map(int, input().split())
    times.append([a, b])

cnt = best_meeting_time_by_heap(times)
print(cnt)
