// LeetCode 350: Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> intersectionList = new ArrayList<Integer>();
         
        for (int num : nums2) {
            if (map.containsKey(num)) {
                intersectionList.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        
        int[] intersectionArray = new int[intersectionList.size()];
        
        for (int i = 0; i < intersectionArray.length; i++) {
            intersectionArray[i] = intersectionList.get(i);
        }
        
        return intersectionArray;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // The commented lines below will sort the arrays
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        
        List<Integer> intersect = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
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
        
        return intersect.stream().mapToInt(k -> k).toArray();
    }
}
