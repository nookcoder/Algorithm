# 8 * 8 로 먼저 자른다 -> 비교할 원소의 갯수가 항상 8게 이다
# 가로 모두 확인, 세로 모두 확인 -> 가장 적은 결우의 수?
# target 은 리스트 형태
def find(board):
    a = 0
    b = 0
    # 첫번째 원소를 바꾸지 않았을 때
    for i in range(8):
        for j in range(8):
            if i == 0 and j == 0:
                continue

            if i != 0 and j == 0:
                if board[i-1][j] == board[i][j]:
                    a += 1
                    if board[i-1][j] == "B":
                        board[i][j] = "W"
                    elif board[i-1][j] == "W":
                        board[i][j] = "B"

            if board[i][j-1] == board[i][j]:
                a += 1
                if board[i][j-1] == 'W':
                    board[i][j] = 'B'
                elif board[i][j-1] == 'B':
                    board[i][j] = 'W'

    for i in range(8):
        for j in range(8):
            if i == 0 and j == 0:
                b += 1
                if board[i][j] == 'W':
                    board[i][j] = 'B'
                else:
                    board[i][j] = 'W'
                continue

            if i != 0 and j == 0:
                if board[i-1][j] == board[i][j]:
                    b += 1
                    if board[i-1][j] == "B":
                        board[i][j] = "W"
                    elif board[i-1][j] == "W":
                        board[i][j] = "B"

            if board[i][j-1] == board[i][j]:
                b += 1
                if board[i][j-1] == 'W':
                    board[i][j] = 'B'
                elif board[i][j-1] == 'B':
                    board[i][j] = 'W'
    print(a,b)
    return min(a,b)


N, M = map(int, input().split())

all_board = []

for _ in range(N):
    all_board.append(list(input()))

min_num = []

for col in range(N - 7):
    for row in range(M - 7):
        board = []
        for index in range(8):
            board.append(all_board[col + index][row:row+8])
        print(board)
        min_num.append(find(board))

print(min_num)