def solution(s):
    answer = 0
    n = len(s)
    pair = {']': '[', '}': '{', ')': '('}
    
    for i in range(n) :
        rotated = s[i:] + s[:i]
        
        stack = []
        is_valid = True
        
        for char in rotated :
            if char in pair.values():
                stack.append(char)
            elif char in pair :
                if not stack or stack[-1] != pair[char]:
                    is_valid = False
                    break
                stack.pop()
                
        if is_valid and len(stack) == 0 :
            answer += 1
    return answer
        