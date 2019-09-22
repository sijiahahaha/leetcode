class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' ||
                input.charAt(i) == '-' ||
                input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for (int num1 : part1Res) {
                    for (int num2 : part2Res) {
                        if (input.charAt(i) == '+') 
                            res.add(num1 + num2);
                        else if (input.charAt(i) == '-') 
                            res.add(num1 - num2);
                        else if (input.charAt(i) == '*') 
                            res.add(num1 * num2);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}