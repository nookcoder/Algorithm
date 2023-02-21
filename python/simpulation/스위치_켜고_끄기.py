def change_switch(switch_state):
    if switch_state == 1:
        return 0
    else:
        return 1


def switch_changed_by_man(card_number, switch_count, switches):
    max_num = switch_count // card_number

    for i in range(1, max_num + 1):
        index = i * card_number
        index -= 1
        switches[index] = change_switch(switches[index])
    return switches


def switch_changed_by_woman(card_number, switch_count, switches):
    start_index = card_number - 1
    switches[start_index] = change_switch(switches[start_index])
    before = start_index - 1
    after = start_index + 1

    if before < 0 or after >= switch_count:
        return switches

    while before >= 0 and after < switch_count:
        if switches[before] == switches[after]:
            switches[before] = switches[after] = change_switch(switches[before])
            before -= 1
            after += 1

        else:
            before = -1
            after = switch_count

    return switches


switch_count = int(input())
switches = list(map(int, input().split()))
students_count = int(input())

for _ in range(students_count):
    gender, card_number = map(int, input().split())
    if gender == 1:
        switches = switch_changed_by_man(card_number, switch_count, switches)
    elif gender == 2:
        switches = switch_changed_by_woman(card_number, switch_count, switches)


for i in range(0, switch_count, 20):
    print(*switches[i:i+20])

