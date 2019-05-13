/**
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
 **/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return summary;
        }
        int start = nums[0];
        int end = start;
        for (int curr = 1; curr < nums.length; curr++) {
            if (nums[curr] == nums[curr - 1] + 1) {
                continue;
            }
            end = curr - 1;
            summary.add(makeRange(start, end, nums));
            start = curr;

        }
        end = nums.length - 1;
        summary.add(makeRange(start, end, nums));
        return summary;
    }

    private String makeRange(int start, int end, int[] nums) {
        String str = "";
        if (start == end) {
            str = String.format("%d", nums[start]);
        } else {
            str = String.format("%d->%d", nums[start], nums[end]);
        }
        return str;
    } 
}


