king, queen, rook, bishop, knight,pawn = map(int, input().split())

KING_COUNT = 1
QUEEN_COUNT = 1
ROOK_COUNT = 2
BISHOP_COUNT = 2
KNIGHT_COUNT = 2
PAWN_COUNT = 8

print("{0} {1} {2} {3} {4} {5} {a}".format(KING_COUNT - king, QUEEN_COUNT - queen, ROOK_COUNT - rook, BISHOP_COUNT - bishop, KNIGHT_COUNT - knight ,PAWN_COUNT - pawn, a="2"))
print("hello world", king)


