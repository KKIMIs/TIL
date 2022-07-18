# BeakJoon 1062
# 2022-07-14

# 가르침
# 브루스포트, dp, 비트 마스킹

'''
김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는
단어의 개수가 최대가 되는지 고민에 빠졌다.

남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다.
남극언어에 단어는 N개 밖에 없다고 가정한다.
학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N과 K가 주어진다.
N은 50보다 작거나 같은 자연수이고,
K는 26보다 작거나 같은 자연수 또는 0이다.
둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다.
단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고,
15보다 작거나 같다. 모든 단어는 중복되지 않는다.

출력
첫째 줄에 김지민이 K개의 글자를 가르칠 때,
학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.
'''

import sys
n, k = map(int, input().split())

words = [set(sys.stdin.readline().rstrip()) for _ in range(n)]
basic = ['a', 'n', 't', 'i', 'c']
learned = [0]*26
aCode = 97
result = 0

# 'a' 아스키 코드 97
for b in basic:
    learned[ord(b)-aCode] = True


def find(idx, cnt, learned, words):
    global result

    # 최대 탐색
    if cnt == k-5:
        tmp = 0
        for w in words:
            hasLearned = True
            for l in w:
                if not learned[ord(l)-aCode]:
                    hasLearned = False
                    break
            if hasLearned:
                tmp += 1
        result = max(tmp, result)
        return

    for i in range(idx, 26):
        if not learned[i]:
            learned[i] = True
            find(i, cnt+1, learned, words)
            learned[i] = False


if (k < 5):
    print(0)
    sys.exit()
elif (k == 26):
    print(n)
    sys.exit()

find(0, 0, learned, words)
print(result)
