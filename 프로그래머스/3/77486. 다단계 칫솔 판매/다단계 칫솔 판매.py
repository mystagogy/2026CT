def solution(enroll, referral, seller, amount):
    parent = {}
    profit = {}
    
    for i in range(len(enroll)) :
        parent[enroll[i]] = referral[i]
        profit[enroll[i]] = 0
        
    for i in range(len(seller)) :
        person = seller[i]
        money = amount[i] * 100
        
        while person != "-" and money > 0:
            give = money //10
            keep = money - give
            
            profit[person] += keep
            person = parent[person]
            money = give
    answer = []
    for name in enroll :
        answer.append(profit[name])
        
    return answer