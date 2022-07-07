#BeakJoon 2609
#2022-07-07

#최대공약수와 최소공배수


'''
입력
첫째 줄에는 두 개의 자연수가 주어진다. 
이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,
둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
'''

a, b = map(int, input().split())
print(a,b)

# a, b 크기 비교
big = 0
if(a>b): sml = b
else: sml = a

# 소수 구하기 : 1과 자기 자신을 제외한 값으로 자신을 나눌 수 없음

#서로소 체크 함수
def checkcol(a,b):
    for i in range(2,sml+1):
        if (a%i==0 and  b%i==0):
            return False
    return True

dec = []

for i in range (2,sml+1):
    div_flag = False
    for j in range(2, i):
        if (i%j==0):
            div_flag = True
            break
    if (not div_flag):
        dec.append(i)

# a, b를 모두 나눠서 0이 되는 소수를 작은 순서대로 
val=[]
while(True):
    if (checkcol(a,b)):
        break
    else:
        
    