# BeakJoon 2798
# 2022-07-14

# 블랙잭
# 브루스포트


'''
N장의 카드에 써져 있는 숫자가 주어졌을 때, 
M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.


입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 
M(10 ≤ M ≤ 300,000)이 주어진다. 
둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 
이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 
카드 3장의 합을 출력한다.
'''

card_num, max_num = map(int, input().split())

cards = list(map(int, input().split()))

cur = 0
sum = 0

# card_num 값만큼 카드 합 더해보기
# sum <= max_num
for i in range(card_num):
    # 카드 3장을 뽑는 법 -> 하나씩 다해보기?
    for j in range(i+1, card_num):
        for k in range(j+1, card_num):
            sum = cards[i] + cards[j] + cards[k]
            #print(max_num, " ?? ", sum)
            if (max_num >= sum):
                #print("i-", cards[i], "/j-", cards[j], "/k-", cards[k])
                cur = max(cur, sum)

print(cur)
