import math


def getDistance(x1,y1,x2,y2):
    x = (x1 - x2) ** 2
    y = (y1 - y2) ** 2
    return int(math.sqrt(x+y))


def getDistanceRadius(r1, r2):
    return abs(r1 - r2)


N = int(input())

for i in range(N):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    distance = getDistance(x1, y1, x2, y2)
    if distance > 0:
        radiusDistance = getDistanceRadius(r1,r2)
    else:
        if radiusDistance