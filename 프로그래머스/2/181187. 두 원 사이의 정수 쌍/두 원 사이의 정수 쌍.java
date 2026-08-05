class Solution {

    public long solution(int r1, int r2) {
        long count = 0;

        long innerRadiusSquared = (long) r1 * r1;
        long outerRadiusSquared = (long) r2 * r2;

        for (long x = 1; x <= r2; x++) {
            long xSquared = x * x;

            long maxY = (long) Math.floor(
                    Math.sqrt(outerRadiusSquared - xSquared)
            );

            long minY;

            if (xSquared >= innerRadiusSquared) {
                minY = 0;
            } else {
                minY = (long) Math.ceil(
                        Math.sqrt(innerRadiusSquared - xSquared)
                );
            }

            count += maxY - minY + 1;
        }

        return count * 4;
    }
}