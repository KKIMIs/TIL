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

참고링크: https://lute3r.tistory.com/266
유클리드 호제법:https://myjamong.tistory.com/138
'''

a, b = map(int, input().split())



div = []
for i in range(1, min(a,b)+1):
    if a%i==0 and b%i==0:
        div.append(i)

gcf = div[-1]
lcm = div[-1] * (a//div[-1]) * (b//div[-1])
print(gcf)
print(lcm)

# print(div)
