kro_alpha = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
value = input()
# value = "nljj"
count = 0
all_cro = 0
original_length = len(value)

for ch in kro_alpha:
    cro = value.count(ch)
    count += cro
    all_cro += cro * len(ch)
    value = value.replace(ch, "")

print(count + len(value))


s = input()
a = len(s)
idx = 0
cro_alpha = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

for i in cro_alpha:
    if i in s:
        s = s.replace(i, "*")

print(len(s))
