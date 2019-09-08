public class Solution {
    /**
     * @param flowers: the place where the flower will open in that day
     * @param k:  an integer
     * @return: in which day meet the requirements
     */
    public int kEmptySlots(int[] flowers, int k) {
        // Write your code here
        if (flowers == null || flowers.length == 0 || k < 0) {
            return -1;
        }
        int earlist = Integer.MAX_VALUE;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int slot = flowers[i];
            ts.add(slot);
            Integer lower = ts.lower(slot);
            Integer higher = ts.higher(slot);
            if ((higher != null && higher - slot - 1 == k) ||
                (lower != null && slot - lower - 1== k)) {
                earlist = Math.min(earlist, i + 1);
            }
  
        }
        
        return earlist == Integer.MAX_VALUE ? -1 : earlist;
    }
}