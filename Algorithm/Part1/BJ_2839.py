#BeakJoon 2839
#2022-07-13

#설탕배달


'''
봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 

입력
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

출력
상근이가 배달하는 봉지의 최소 개수를 출력한다. 
만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
'''

tot = int(input())

bags = 0

while(tot>=0):
    if (tot%5==0):
        bags += tot//5
        break 
    tot -= 3
    bags +=1 
else:
    bags =-1


print(bags)