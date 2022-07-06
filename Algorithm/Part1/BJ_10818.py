#BeakJoon 10818
#2022-07-05

# #최소, 최대

# 입력
# 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
# 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
# 모든 정수는 -1,000,000보다 크거나 같고, 
# 1,000,000보다 작거나 같은 정수이다.

# 출력
# 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 
# 공백으로 구분해 출력한다.

n = int(input())

case = list(map(int,input().split()))

max = case[0]
min = case[0]

for i in range(1,n):
    if max < case[i]:
        max = case[i]
    if min > case[i]:
        min = case[i]

print(min,max)