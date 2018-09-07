/**
1. brute force
   每次增加一分钟，看newTime是否valid（只由原数字组成）如果valid就return
   O(24*60)
2. dfs
   构造出所有可能的时间，找time difference最小的一个
   O(4^4)
**/
//1
class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                set.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        
        for (int i = 0; i < 24 * 60; i++) {
            minute++;
            if (minute > 59) {
                minute = 0;
                hour++;
            }
            if (hour > 23) {
                hour = 0;
            }
            
            if (set.contains(hour % 10) && set.contains(hour / 10) && set.contains(minute % 10) && set.contains(minute / 10)) {
                break;
            }
        }
        
        return String.format("%02d:%02d", hour, minute);
    }
}


//2
class Solution {
    String result = "";
    int diff = Integer.MAX_VALUE;
    public String nextClosestTime(String time) { 
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                set.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        if (set.size() == 1) {
            return time;
        }
        List<Integer> digit = new ArrayList<>(set);
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int oldTime = hour * 60 + minute;
        String curr = "";
        dfs(digit, curr, 0, oldTime);
        return result;
    }
    
    private void dfs(List<Integer> digit, String curr, int pos, int oldTime) {
        if (pos == 4) {
            int newTime = Integer.parseInt(curr.substring(0, 2)) * 60 + Integer.parseInt(curr.substring(2, 4));
            int newDiff = newTime > oldTime ? newTime - oldTime : 24 * 60 + newTime - oldTime;
            if (newDiff < diff) {
                diff = newDiff;
                result = curr.substring(0, 2) + ":" + curr.substring(2, 4);
            }
            return;
        }
        
        for (int i = 0; i < digit.size(); i++) {
            if (pos == 0 && digit.get(i) > 2) {
                continue;
            }
            if (pos == 1 && Integer.parseInt(curr) * 10 + digit.get(i) > 23) {
                continue;
            }

            if (pos == 2 && digit.get(i) > 5) {
                continue;
            }
            if (pos == 3 && Integer.parseInt(curr.substring(2)) * 10 + digit.get(i) > 59) {
                continue;
            }
            dfs(digit, curr + digit.get(i), pos + 1, oldTime);           
        }             
    }  
}

