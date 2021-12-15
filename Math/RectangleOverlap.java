// LeetCode 836: Rectangle Overlap
// https://leetcode.com/problems/rectangle-overlap/

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
            The following condition determines whether or not two lines (1D) overlap
            
            left1 < right2 && left2 < right1
            
            -------------
            l1          r1
                  ---------------
                  l2            r2
                  
            Apply the above condition to both the x-axis and y-axis to determine whether two rectangles (2D) overlap
        */
        return
            // x-axis: 0, 2
            rec1[0] < rec2[2] && rec2[0] < rec1[2]
            &&
            // y-axis: 1, 3
            rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
