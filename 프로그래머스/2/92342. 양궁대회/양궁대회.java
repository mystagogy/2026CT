import java.util.*;

class Solution {
    static int[] apeach;
    static int[] ryan;
    static int[] answer;
    static int maxDiff = 0;
    static int n;

    public int[] solution(int n, int[] info) {
        this.n = n;
        apeach = info;
        ryan = new int[11];
        answer = new int[11];

        dfs(0, n);

        if (maxDiff == 0) {
            return new int[]{-1};
        }

        return answer;
    }

    static void dfs(int index, int arrowsLeft) {
        // 10점부터 0점까지 모두 판단한 경우
        if (index == 11) {
            // 남은 화살은 0점에 몰아준다
            ryan[10] += arrowsLeft;

            checkScore();

            // 원복
            ryan[10] -= arrowsLeft;
            return;
        }

        // 선택 1. 해당 점수를 이긴다
        int need = apeach[index] + 1;

        if (arrowsLeft >= need) {
            ryan[index] = need;
            dfs(index + 1, arrowsLeft - need);
            ryan[index] = 0;
        }

        // 선택 2. 해당 점수를 포기한다
        dfs(index + 1, arrowsLeft);
    }

    static void checkScore() {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) {
                continue;
            }

            int score = 10 - i;

            if (ryan[i] > apeach[i]) {
                ryanScore += score;
            } else {
                apeachScore += score;
            }
        }

        int diff = ryanScore - apeachScore;

        if (diff <= 0) {
            return;
        }

        if (diff > maxDiff) {
            maxDiff = diff;
            answer = ryan.clone();
        } else if (diff == maxDiff) {
            if (isBetterLowScore()) {
                answer = ryan.clone();
            }
        }
    }

    static boolean isBetterLowScore() {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > answer[i]) {
                return true;
            } else if (ryan[i] < answer[i]) {
                return false;
            }
        }

        return false;
    }
}