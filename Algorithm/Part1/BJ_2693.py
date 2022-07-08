#BeakJoon 2693
#2022-07-07
#N번째 큰 수


'''
입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있고, 
배열 A의 원소 10개가 공백으로 구분되어 주어진다.
 이 원소는 1보다 크거나 같고, 1,000보다 작거나 같은 자연수이다.

출력
각 테스트 케이스에 대해 한 줄에 하나씩 
배열 A에서 3번째 큰 값을 출력한다.
'''

num = int(input())

for i in range(num):
    case = list(map(int,input().split()))
   
    for j in range(len(case)-1):
        for k in range(0, len(case)-1-j):
            if(case[k]>case[k+1]):
                tem = case[k]
                case[k] = case[k+1]
                case[k+1] = tem
    print(case[-3])