#BeakJoon 11729
#2022-07-14

#하노이 탑 이동 순서

'''
1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.

입력
첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 옮긴 횟수 K를 출력한다.

두 번째 줄부터 수행 과정을 출력한다. 
두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 
출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 
가장 위로 옮긴다는 뜻이다.
'''

plt = int(input())

def hanoi(plt, start, mid,  end):
    if (plt==1):
        print(start, end)
        return
    else:
        hanoi(plt-1, start, end, mid )
        print(start, end)
        hanoi(plt-1, mid, start, end)

sum=1
for i in range(plt - 1):
    sum = sum * 2 + 1
print(sum)
hanoi(plt,1,2,3)
