import java.util.*;
class Solution {
    static class Node{
        String word;
        int count;
        
        Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }
    static int bfs(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            String word = current.word;
            int count = current.count;
            
            if(word.equals(target)) return count;
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && compareWord(word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], count+1));
                }
            }
        }
        return 0;
    }
    static boolean compareWord(String str1, String str2){
        int cnt = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
        }
        
        if(cnt == 1) return true;
        else return false;
    }
}