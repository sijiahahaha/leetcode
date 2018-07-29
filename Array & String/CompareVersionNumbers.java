/**  
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
比较版本号

用“.” split，然后一个一个比 
**/
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int c1 = 0;
            int c2 = 0;
            if (v1.length > i) {
                c1 = Integer.parseInt(v1[i]);
            }
            if (v2.length > i) {
                c2 = Integer.parseInt(v2[i]);
            }
            
            if (c1 > c2) return 1;
            if (c1 < c2) return -1;
        }
        return 0;
    }
}