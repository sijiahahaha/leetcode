/**
give a num as string, check if it is same after 180 degree
two point, check if the digits are pair
 **/
import java.util.HashMap;
class Solution {
    public static boolean isStrobogrammatic(String num) {
        if (num == null | num.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        HashMap<Character, Character>  map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(right) != map.get(num.charAt(left))) {
                return false;
            }
            left++;
            right--;
        }
        if (num.length() % 2 == 1) {
            return map.containsKey(num.charAt(left)) && num.charAt(left) == map.get(num.charAt(left));
        }
        return true;
    }
}
class strobogrammatic_number {
    public static void main (String[] args) {
        String num = args[0];
        boolean result = Solution.isStrobogrammatic(num);
        System.out.println(num);
        System.out.println(result);
        assert result==Boolean.parseBoolean(args[1]) : "Wrong! expect: " + args[1] + ", get: " + result;

    }
}
~
~
