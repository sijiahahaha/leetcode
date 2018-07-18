/**
分开的情况只有： x1 x2 X1 X2    or  X1 X2 x1 x2
               y1 y2 Y1 Y2    or  Y1 Y2 y1 y2
                  包括>=
去掉这些就是overlap
**/


class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (!(rec2[0] >= rec1[2] || rec1[0] >= rec2[2]) && !(rec2[1] >= rec1[3] || rec1[1] >= rec2[3])){
            return true;
        } else {
            return false;
        }
    }
}