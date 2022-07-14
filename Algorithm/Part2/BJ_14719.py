#BeakJoon 14719
#2022-07-12

#빗물


'''
입력
첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)

두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.

따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.

출력
2차원 세계에서는 한 칸의 용량은 1이다. 고이는 빗물의 총량을 출력하여라.

빗물이 전혀 고이지 않을 경우 0을 출력하여라.

~~~~ 다른 코드 ~~~~
브루스포트와 투포인터를 이용해보기
https://devyuseon.github.io/boj/boj-14719/
'''


y, x = map(int, input().split())

#빈칸
layer = [[0 for _ in range(x)] for _ in range(y)]

#블럭
blck = list(map(int, input().split()))

#빈칸에 블럭 넣기 (상하반전)
for i in range(y):
    for j in range(x):
        if (blck[j]>0):
            layer[i][j] = 1
            blck[j] -= 1

#물 채우기
cnt = 0



for i in range(y):
    found_wall_1 = False
    temp = 0
    for j in range(x):
        #1 과 1 사이에 0 이 있으면 물 채우기 가능
        if (layer[i][j]==1):
            found_wall_1 = True
        if(found_wall_1): #벽_1 찾은 상태에서 
            if(layer[i][j]==0): # 물 채울 공간
                temp += 1
            else:          #벽_2 찾음 (물 확보)
                cnt += temp
                temp = 0

print(cnt)
# print(layer)