/**
array is cheaper then hashmap

**/

class Solution {
    public static String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0 || secret.length() != guess.length()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        int[] s = new int[10];
        int[] g = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                bulls++;
            } else {
                s[cs - '0']++;
                g[cg - '0']++;
            }
        }

        for (int j = 0; j < 10; j++) {
            cows += Math.min(s[j], g[j]);
        }

        return bulls + "A" + cows + "B";
    }


}
class bulls_and_cows {
    public static void main (String[] args) {
        String secret = args[0];
        String guess = args[1];
        String result = Solution.getHint(secret, guess);
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(result);
        assert result.equals(args[2]) : "Wrong! expect: " + args[2] + ", get: " + result;

    }
}
~
