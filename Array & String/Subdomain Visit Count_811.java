/**
先找到“ ”， 分割出数字和s，将s放入map
再对于s，一次找到'.'，后面部分存入map
**/


class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
            int index = cp.indexOf(' ');
            int n = Integer.valueOf(cp.substring(0, index));
            String s = cp.substring(index+1);
            if (!map.containsKey(s)) {
                map.put(s, n);
            } else {
                map.put(s, map.get(s) + n);
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    String temp = s.substring(i+1);
                    if (!map.containsKey(temp)) {
                        map.put(temp, n);
                    } else {
                        map.put(temp, map.get(temp) + n);
                    }
                }
            } 
        }
        
        for (String d : map.keySet()) {
            result.add(map.get(d) + " " + d);
        }
        return result;
    }
}


    