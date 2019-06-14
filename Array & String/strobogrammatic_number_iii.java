/**
given a range [lower, higher], return number of all possible strobogrammtic number in range

same as II, find all with the len between [lower, higher], then count for value in range

dfs, from inside to outside
0 cannot be the first digit
**/
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null || low.length() == 0|| high.length() == 0
         || low.length() > high.length() || (low.length() == high.length() && low.compareTo(high) > 0)) {
            throw new IllegalArgumentException("Invalid Input");
        }
        HashMap<String, String>  map = new HashMap<>();
        map.put("1", "1");
        map.put("6", "9");
        map.put("8", "8");
        map.put("9", "6");
        // char[][] pair = {{"0", "0"}, {"1", "1"}, {"8", "8"},{"6", "9"}, {"9", "6"}};

        int count = 0;
        for (int n = low.length(); n < high.length(); n++) {
            List<String> list = dfs(n, n, map);
            for (String str : list) {
                if ((str.length() == low.length() && str.compareTo(low) < 0)
                     || (str.length() == high.length() && str.compareTo(high) > 0) ) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    private static List<String> dfs(int cur, int max, HashMap<String, String> map) {
        List<String> curList = new ArrayList<>();
        if (cur <= 0) {
            curList.add("");
            return curList;
        }
        if (cur == 1) {
            curList.addAll(Arrays.asList("0", "1", "8"));
            return curList;
        }

        List<String> subList = dfs(cur - 2, max, map);
        for (String str : subList) {
            if (cur != max) {
                curList.add("0" + str + "0");
            }
            for (HashMap.Entry<String, String> entry : map.entrySet()) {
                curList.add(entry.getKey() + str + entry.getValue());
            }
        }
        return curList;
    }
}
class strobogrammatic_number {
    public static void main (String[] args) {
        int result = Solution.strobogrammaticInRange("500", "100");
        System.out.println(result);
    }
}
~
~
