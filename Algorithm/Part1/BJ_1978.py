#BeakJoon 1987
#2022-07-08

#소수찾기

'''
입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 
다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

'''

num = int(input())
case = list(map(int,input().split()))
cnt = 0

for i in range (len(case)):
    found = False
    if (case[i]==1):
        pass
    elif (case[i]==2):
        cnt += 1
    else:
        for j in range(2, case[i]):
            if (case[i]%j==0):
                found=True
                break
        if (not found):
            cnt += 1

print(cnt)