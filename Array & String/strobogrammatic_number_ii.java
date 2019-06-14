/**
given len n, return all possible strobogrammtic number with length n

dfs, from inside to outside
0 cannot be the first digit
**/
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static List<String> findStrobogrammatic(int n) {
        HashMap<String, String>  map = new HashMap<>();
        map.put("1", "1");
        map.put("6", "9");
        map.put("8", "8");
        map.put("9", "6");

        // char[][] pair = {{"0", "0"}, {"1", "1"}, {"8", "8"},{"6", "9"}, {"9", "6"}};
        return dfs(n, n, map);
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
        List<String> result = Solution.findStrobogrammatic(2);
        System.out.println(result);
    }
}
~
