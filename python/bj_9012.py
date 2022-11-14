def isVPS(vps):
  stack = [] 
  for element in vps: 
    stack.append(element)
    length = len(stack)
    if length > 1: 
      if stack[length -1] == ")" and stack[length - 2] == "(":
        stack.pop()
        stack.pop()
  if len(stack) == 0 :
    return print("YES")
  else : 
    return print("NO")

N = int(input())
vps_list = [input() for _ in range(N)]

for vps in vps_list:
  isVPS(vps)
