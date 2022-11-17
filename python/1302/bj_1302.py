book = {}

for _ in range(int(input())):
    key = input()
    if key in book.keys():
        book[key] += 1
    else:
        book[key] = 1

m = max(book.values())
candi = []
for key, value in book.items():
    if value == m:
        candi.append(key)
candi.sort()
print(candi[0])




