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

    // Two Pointer algorithm assuming the input arrays are sorted
    public int[] intersection(int[] nums1, int[] nums2) {
        // The commented lines below will sort the arrays
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        
        List<Integer> intersect = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            // If i is not 0 and the value at i - 1 is equal to the value at i, then it's a duplicate that we already processed, so just increment i and process the next value
            if (i != 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            
            // 1. If nums1[i] == nums2[j], then we know both arrays share this common value, so add it to our intersect list and increment both pointers
            // 2. If nums1[i] < nums2[j], then we must increment i in order to potentially find a value in nums1 that will equal nums2[j]
            // 3. If nums1[i] > nums2[j], then we must increment j in order to potentially find a value in nums2 that will equal nums1[i]
            if (nums1[i] == nums2[j]) {
                intersect.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[intersect.size()];
        for (int k = 0; k < intersect.size(); k++) {
            result[k] = intersect.get(k);
        }
        
        return result;
    }
}
