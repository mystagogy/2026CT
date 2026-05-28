def solution(N, stages):

    arr = [0] * (N + 2)

    for stage in stages:
        arr[stage] += 1

    fails = {}
    total = len(stages)

    for i in range(1, N + 1):

        if total == 0:
            fails[i] = 0
        else:
            fails[i] = arr[i] / total

        total -= arr[i]

    answer = sorted(fails, key=lambda x: fails[x], reverse=True) #딕셔너리 키 기준 내림차순

    return answer