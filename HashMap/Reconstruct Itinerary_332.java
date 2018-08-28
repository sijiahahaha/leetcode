/**
dfs+hashmap
HashMap存<起点城市， {到达城市1， 到达城市2， 。。。}>
从JFK开始dfs，一直往下找

**/
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return result;
        }
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        
        dfs(map, "JFK", result);
        Collections.reverse(result);
        return result;
            
    }
    
    private void dfs(HashMap<String, PriorityQueue<String>> map, String curr, List<String> result) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            String next = map.get(curr).poll();
            dfs(map, next, result);
        }
        result.add(curr);
    }
}