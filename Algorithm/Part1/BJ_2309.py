#BeakJoon 2309
#2022-07-06

#일곱 난쟁이

'''
아홉 명의 난쟁이는 모두 
자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장
일곱 난쟁이의 키의 합이 100


입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 
주어지는 키는 100을 넘지 않는 자연수이며, 
아홉 난쟁이의 키는 모두 다르며, 
가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 
일곱 난쟁이를 찾을 수 없는 경우는 없다.
'''

dwrf = [int(input()) for i in range(9)]
tot = sum(dwrf)

notd1, notd2 = 0, 0
found = False
for i in range(9):
    for j in range(i+1,9):
        if tot - dwrf[i] - dwrf[j]== 100:
            notd1, notd2 = dwrf[i], dwrf[j]
            found = True

            dwrf.remove(notd1)
            dwrf.remove(notd2)
            dwrf.sort()

            for i in range(len(dwrf)):
                print(dwrf[i])
            break

            #출력 위치가 중요
    if(found):
        break





