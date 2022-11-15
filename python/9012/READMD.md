# VPS 인지 아닌지 판단하기
문제 출처 : [백준 9012번](https://www.acmicpc.net/problem/9012)

## 작성한 답안 코드 
```
# VPS 가 맞는지 판별할 함수 
def isVPS(vps):
  stack = [] 
  for element in vps: 
    stack.append(element)
    length = len(stack)
    if length > 1: 
      if stack[length -1] == ")" and stack[length - 2] == "(":
        stack.pop()
        stack.pop()
  # VPS 문자열이 맞을 때 
  if len(stack) == 0 :
    return print("YES")
    
   # VPS 문자열이 아닐 때
  else : 
    return print("NO")

N = int(input())
vps_list = [input() for _ in range(N)]

for vps in vps_list:
  isVPS(vps)
```
## 접근 방식 
- 크게 2가지 방법을 고려했다.
1. 갯수를 단순히 비교해서 "(" 와 ")" 의 갯수가 같으면 "YES" 출력, 그렇지 않으면 "NO" 출력
     1. 해당 방법을 사용하면 짝이 맞지 않는 경우를 판단할 수 없다. (예 ")(")


2. 짝이 맞는 "(" 와 ")" 를 확인하는 방법 
   - 해당 방법을 구현하기 위해 stack 을 사용하기로 했다. 그 이유는 문자열의 앞 쪽부터 찾아나가면
      멀리 떨어진 vps 짝(ex (()()()()()()) ) 을 찾을 때 경우의 수가 너무 많아진다.
      1. stack 을 사용해서 맨 마지막에 들어오는 요소를 이용해서 vps 를 판단하면 판단해야할 조건이 1가지로 줄어들었다. 
      2. 마지막 들어온 요소가 ")" 이고 기존에 stack 쌓여있는 바로 전 요소가 "(" 이면 vps 짝을 이뤘으므로 stack 에서 제거
   - _괄호쌍 문제는 전형적인 Stack 을 이용하는 문제이다._

## 수정한 코드 
- 기존에는 모든 character 를 stack 에 넣고 비교했었는 데 ")"가 들어왔을 때는 stack 에 넣지 않고 비교 하는 방법으로 수정 
```
def isVPS(vps):
  isVPS = True
  stack = [] 
  for element in vps:
    if element == "(" :
        stack.append(element)
        
    # element == ")"
    else : 
        if stack : # stack is not empty 
            stack.pop()
        else : 
          return print("NO")
          
  # VPS 문자열이 맞을 때 
  if len(stack) == 0 :
    return print("YES")
    
   # VPS 문자열이 아닐 때
  else : 
    return print("NO")

N = int(input())
vps_list = [input() for _ in range(N)]

for vps in vps_list:
  isVPS(vps)
```



  


