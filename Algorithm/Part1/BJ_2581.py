#BeakJoon 2581
#2022-07-09

#소수
'''
자연수 M과 N이 주어질 때 
M이상 N이하의 자연수 중 소수인 것을 모두 골라 
이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

입력
입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

출력
M이상 N이하의 자연수 중 소수인 것을 모두 찾아 
첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 

단, M이상 N이하의 자연수 중 소수가 없을 경우는 
첫째 줄에 -1을 출력한다.
'''
m = int(input())
n = int(input())

dec = []
for i in range (m, n+1):
    found = False
    if (i>1):
        for j in range(2, i):
            if (i%j==0):
                found = True
                break
    if (not found and i != 1):
        dec.append(i)

if (len(dec)>0):
    print(sum(dec))
    print(min(dec))
else:
    print(-1)


