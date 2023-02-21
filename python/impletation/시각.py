N = int(input())

hour = 0  # max = N
minute = 0  # max = 59
second = 0  # max= 59

count = 0


def detect_three(value):
    if value % 10 == 3 or value // 10 == 3:
        return True
    return False


while hour <= N:
    if detect_three(hour):
        count += 3600
    else:
        for i in range(60):
            if detect_three(i):
                count += 60
                continue

            for j in range(60):
                if detect_three(j):
                    count += 1
    hour += 1

print(count)