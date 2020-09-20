// LeetCode 349: Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] intersectionArray = new int[intersectionSet.size()];
        int index = 0;
        for (Integer i : intersectionSet) {
            intersectionArray[index++] = i;
        }

        return intersectionArray;
    }
}
