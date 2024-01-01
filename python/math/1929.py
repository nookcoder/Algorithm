import math

## 에라토스테네스의 체
## 1 * 16, 2 * 8 , 4 * 4, 8 * 2 => 곱은 서로 대칭을 이루고 있다
## 따라서 특정 수의 절반까지만 확인하면 알 수 있다. 
def isDecimal(number):
    for i in range(2, int(math.sqrt(number)) + 1):
        if number % i == 0:
            return False

    return True


a, b = map(int, input().split())
for i in range(a,b+1):
    if i > 2:
        if isDecimal(i):
            print(i)
    elif i == 2:
        print(i)

