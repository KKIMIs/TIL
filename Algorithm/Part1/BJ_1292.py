#BeakJoon 1292
#2022-07-09

#쉽게 푸는 문제

'''
 1을 한 번, 2를 두 번, 3을 세 번, 
 이런 식으로 1 2 2 3 3 3 4 4 4 4 5 .. 
 이러한 수열을 만들고 
 어느 일정한 구간을 주면 
 그 구간의 합을 구하는 것


입력
첫째 줄에 구간의 시작과 끝을 나타내는 정수
 A, B(1 ≤ A ≤ B ≤ 1,000)가 주어진다. 
즉, 수열에서 A번째 숫자부터 B번째 숫자까지 합을 구하면 된다.

출력
첫 줄에 구간에 속하는 숫자의 합을 출력한다.
'''

a, b = map(int, input().split())
nums = []
for i in range (b+1):
    for _ in range(i):
        nums.append(i)
    if (len(nums)>b):
        break
result = sum(nums[:b]) - sum(nums[:a-1])
print(result)


