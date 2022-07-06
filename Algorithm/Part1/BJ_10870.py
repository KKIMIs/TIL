#BeakJoon 10870
#2022-07-06

#피보나치 수열5

'''
입력
첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 n번째 피보나치 수를 출력한다.
'''

fibo = [0 for i in range(21)]
fibo[0], fibo[1] = 0, 1

for i in range (2,21):
    fibo[i] = fibo[i-1] + fibo[i-2]

print(fibo[int(input())])

'''
재귀함수 코드
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

n = int(input())
print(fibonacci(n))

'''