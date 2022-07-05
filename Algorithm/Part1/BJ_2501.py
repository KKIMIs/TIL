#BeckJoon #2501
#2022-07-04

#약수 구하기

# 입력
# 첫째 줄에 N과 K가 빈칸을 사이에 두고 주어진다.
#N은 1 이상 10,000 이하이다. K는 1 이상 N 이하이다.

# 출력
# 첫째 줄에 N의 약수들 중 K번째로 작은 수를 출력한다.
#만일 N의 약수의 개수가 K개보다 적어서 K번째 약수가 존재하지 않을 경우에는
#0을 출력하시오.

n, k = map(int,input().split(" "))

list = []
# 약수 찾기
for i in range(1,n+1):
    if (n%i == 0):
        list.append(i)

if(k>len(list)):
    print(0)
else:
    print(list[k-1])

