def solution(p_nums):
    for i in range(1,len(p_nums)):
        p_nums[i] = max(p_nums[i], p_nums[i-1] + p_nums[i])
    return max(p_nums)


n = int(input())
nums = list(map(int, input().split()))
print(solution(nums))