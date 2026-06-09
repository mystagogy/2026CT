from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    start = lever = exit = None
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'S':
                start = (i, j)
            elif maps[i][j] == 'L':
                lever = (i, j)
            elif maps[i][j] == 'E':
                exit = (i, j)
                
    def bfs(start, target):
        visited = [[False] * m for _ in range(n)]
        q = deque()
        
        sx, sy = start
        q.append((sx, sy, 0))
        visited[sx][sy] = True
        
        dx = [-1, 1, 0, 0]
        dy = [0, 0, 1, -1]
        
        while q:
            x, y, dist = q.popleft()
            
            if (x, y) == target:
                return dist
            
            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]
                
                if 0 <= nx < n and 0 <= ny < m:
                    if not visited[nx][ny] and maps[nx][ny] != 'X':
                        visited[nx][ny] = True
                        q.append((nx, ny, dist + 1))
                        
        return -1
    
    dist1 = bfs(start, lever)
    if dist1 == -1:
        return -1
    
    dist2 = bfs(lever, exit)
    if dist2 == -1:
        return -1
    
    return dist1 + dist2