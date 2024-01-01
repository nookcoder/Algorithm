def findSigmaN(target):
    for i in range(1,4473):
        _sum = 0
        for k in range(1, i + 1):
            _sum += k
        if target <= _sum:
            return i, _sum


a = int(input())
sigNum, _sum = findSigmaN(a)
diff = _sum - a
if sigNum % 2 == 0:
    child = sigNum - diff
    parent = 1 + diff
else:
    child = 1 + diff
    parent = sigNum - diff
print(str(child) + "/" + str(parent))
