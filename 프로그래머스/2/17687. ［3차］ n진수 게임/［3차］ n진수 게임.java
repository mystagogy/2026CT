class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        while (sb.length() < t * m) {
            String converted = Integer.toString(num, n).toUpperCase();

            sb.append(converted);
            num++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int seq = (p - 1) + i * m;
            answer.append(sb.charAt(seq));
        }

        return answer.toString();
    }
}