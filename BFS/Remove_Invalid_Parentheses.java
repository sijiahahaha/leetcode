class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add(s);
            return result;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.offer(s);
        boolean found = false;
        while (!que.isEmpty()) {
            String curr = que.poll();
            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }
            if (found) continue;
            
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String sub = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(sub)) {
                    que.offer(sub);
                    visited.add(sub);
                }
                
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}