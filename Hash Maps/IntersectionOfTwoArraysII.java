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
}
