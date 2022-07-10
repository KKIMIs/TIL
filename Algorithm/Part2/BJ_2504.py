#BeakJoon 2504
#2022-07-10

#괄호의 값
#참고 링크: https://hongcoding.tistory.com/114

'''
- 올바른 괄호열:
1. 한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다. 
2. 만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다. 
3. X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.

- 괄호값 구하기
1. ‘()’ 인 괄호열의 값은 2이다.
2. ‘[]’ 인 괄호열의 값은 3이다.
3. ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
4. ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
5. 올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.

'''



'''
열리는 괄호가 생기면 -> 닫히는 괄호 검사
괄호 사이에는 올바른 괄호값/none

'''
brc = list(input())
result = 0
chck = []
val = 1

for i in range(len(brc)):
    if (brc[i] == "("):
        val *= 2
        chck.append(brc[i]) 
    elif (brc[i] == "["):
        val *= 3
        chck.append(brc[i]) 


    elif (brc[i] == ")"):
        if (chck and chck[-1]=="("):
            if (brc[i-1]=="("):
                result += val
            chck.pop()
            val //=2
        else:
            result = 0
            break   
    else:
        if (chck and chck[-1]=="["):
            if (brc[i-1]=="["):
                result += val
            chck.pop()
            val //=3
            
        else:
            result = 0
            break     
    #print("중간",result, "/", val)

if (chck):
    print(0)  
else:         
    print(result)



