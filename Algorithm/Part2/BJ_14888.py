#BeakJoon 14888
#2022-07-10

#연산자 끼워넣기/DFS/재귀함수

'''
입력
첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 
둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 
셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 
차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 
곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 

출력
첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 
둘째 줄에는 최솟값을 출력한다. 
연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 
10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 
또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 
항상 -10억보다 크거나 같고, 10억보다 작거나 같다.

=> 재귀 함수를 이용한 풀이
https://chul2-ing.tistory.com/67, https://hbj0209.tistory.com/102
'''

t = int(input())
nums = list(map(int, input().split()))
opers = list(map(int, input().split()))

max_ans = -1000000000
min_ans = 1000000000

def cal(val, idx, add, sub, mul, div):
    global max_ans, min_ans
    if idx == t:
        max_ans = max(max_ans, val)
        min_ans = min(min_ans, val)
        return 

    
    if add>0:
        cal(val + nums[idx], idx+1, add-1, sub, mul, div)
    if sub>0:
        cal(val - nums[idx], idx+1, add, sub-1, mul, div)
    if mul>0:
        cal(val * nums[idx], idx+1, add, sub, mul-1, div)
    if div>0:
        cal(int(val/nums[idx]), idx+1, add, sub, mul, div-1)

cal(nums[0], 1, opers[0],opers[1],opers[2],opers[3])
print(max_ans)
print(min_ans)