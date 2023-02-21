value = list(input())
m_list = []
temp = ""
for i in range(len(value)):
    if value[i] != "+" and value[i] != "-":
        temp += value[i]

        # 마지막 입력값 일 때
        if i == len(value) - 1:
            m_list.append(int(temp))

    else:
        m_list.append(int(temp))
        temp = ""
        m_list.append(value[i])

answer = 0
temp_sum = 0
minus_chk = False
plus_chk = False

for m in m_list:
    if m == "-":
        minus_chk = True

    elif m == "+":
        continue

    else:
        if minus_chk:
            answer -= m
        else:
            answer += m
print(answer)

