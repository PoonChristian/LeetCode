// LeetCode 11: Container With Most Water
// https://leetcode.com/problems/container-with-most-water/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        
        while (i < j) {
            int leftHeight = height[i];
            int rightHeight = height[j];

            // Area is equal to the minimum between the left and right height multiplied by the width (j - i)
            // The reason we take the minimum is because we don't want water to overflow
            int area = Math.min(leftHeight, rightHeight) * (j - i);

            max = Math.max(max, area);
            
            /*
              In all three cases, we want to maximize our area
              Move whatever pointer has the shorter height, if both heights are the same, then move both of them
            */
            if (leftHeight < rightHeight) {
                i++;
            } else if (leftHeight > rightHeight) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        
        return max;
    }
}
