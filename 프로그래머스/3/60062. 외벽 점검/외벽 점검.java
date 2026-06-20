import java.util.*;

class Solution {
    static int answer;
    static int[] weakArr;
    static int[] distArr;
    static boolean[] visited;
    static List<int[]> permutations;

    public int solution(int n, int[] weak, int[] dist) {
        answer = dist.length + 1;

        int len = weak.length;
        weakArr = new int[len * 2];

        for (int i = 0; i < len; i++) {
            weakArr[i] = weak[i];
            weakArr[i + len] = weak[i] + n;
        }

        distArr = dist;
        visited = new boolean[dist.length];
        permutations = new ArrayList<>();

        makePermutation(new int[dist.length], 0);

        for (int start = 0; start < len; start++) {
            for (int[] friends : permutations) {
                check(start, len, friends);
            }
        }

        if (answer == dist.length + 1) {
            return -1;
        }

        return answer;
    }

    static void makePermutation(int[] result, int depth) {
        if (depth == distArr.length) {
            permutations.add(result.clone());
            return;
        }

        for (int i = 0; i < distArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = distArr[i];
                makePermutation(result, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void check(int start, int weakCount, int[] friends) {
        int friendCount = 1;
        int position = weakArr[start] + friends[friendCount - 1];

        for (int i = start; i < start + weakCount; i++) {
            if (weakArr[i] > position) {
                friendCount++;

                if (friendCount > friends.length) {
                    return;
                }

                position = weakArr[i] + friends[friendCount - 1];
            }
        }

        answer = Math.min(answer, friendCount);
    }
}