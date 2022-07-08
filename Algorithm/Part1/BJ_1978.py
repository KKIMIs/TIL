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
    if (case[i]!=1)
    for j in (2,case[0]):
        if (case[i]%j==0):
            found=True
            print("확인=",case[i], "j=",j)
            break
    if (not found):
        cnt += 1
   