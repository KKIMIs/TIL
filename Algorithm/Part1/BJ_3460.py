#BeakJoon 3460
#2022-07-04

#이진수

#양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때 
#1의 위치를 모두 찾는 프로그램을 작성

caseNum = int(input())
for i in range(caseNum):
    list =[]
    val = int(input())

    #val >= 2^x -> x의 최대값 구하기
    sqr = val**(1/2)
    max = 1
    while(val>=2**max):
        max += 1
    max -= 1 

    # val 이진수로 계산
    for j in range(max,0,-1):
        if (val>=2**j):
            val = val%2**j
            list.append(str(j))

    if val==1:
        list.append(str(0))
        
    print(" ".join(list[::-1]))

'''
다른 문제 풀이 방식

T = int(input())

while T > 0:
	num = int(input())
	results = []
	cnt = 0

	while num > 0:
		if num % 2 == 1:
		results.append(cnt)

	num //= 2
	cnt += 1
	print(' '.join(map(str, results)))

	T -= 1



'''