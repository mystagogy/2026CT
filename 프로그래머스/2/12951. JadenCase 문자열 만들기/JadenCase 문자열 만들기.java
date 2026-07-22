class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ", -1);

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].isEmpty()) {
                continue;
            }

            StringBuilder sb = new StringBuilder(strs[i]);

            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

            for (int j = 1; j < sb.length(); j++) {
                sb.setCharAt(j, Character.toLowerCase(sb.charAt(j)));
            }

            strs[i] = sb.toString();
        }

        return String.join(" ", strs);
    }
}