/**  
Given a digit string excluded 01, return all possible letter combinations that the number could represent.

Given "23"
Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

dfs
**/
public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        
        StringBuilder curr = new StringBuilder();
        helper(digits, map, curr, result);
        return result;
    }
    
    private void helper(String digits, Map<Character, char[]> map, StringBuilder curr, List<String> result) {
        if (curr.length() == digits.length()) {
            result.add(curr.toString());
            return;
        }
        
        for (char c : map.get(digits.charAt(curr.length()))) {
            curr.append(c);
            helper(digits, map, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}