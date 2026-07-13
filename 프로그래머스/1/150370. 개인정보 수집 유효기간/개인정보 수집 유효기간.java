import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> info = new HashMap<>();

        for (String term : terms) {
            String[] str = term.split(" ");
            info.put(str[0], Integer.parseInt(str[1]));
        }

        int todayDate = convertToDays(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");

            String privacyDate = str[0];
            String type = str[1];

            int period = info.get(type);

            int startDate = convertToDays(privacyDate);
            int expireDate = startDate + 28 * period;

            if (todayDate >= expireDate) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    int convertToDays(String date) {
        String[] dateInfo = date.split("\\.");

        int year = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int day = Integer.parseInt(dateInfo[2]);

        return year * 12 * 28
                + month * 28
                + day;
    }
}