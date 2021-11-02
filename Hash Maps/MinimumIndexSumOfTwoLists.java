// LeetCode 599: Minimum Index Sum of Two Lists
// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Initialize a HashMap to keep track of each string and its corresponding index in list1
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        // Initialize the restaurants ArrayList and a minIndexSum to keep track of
        List<String> restaurants = new ArrayList<String>();
        int minIndexSum = Integer.MAX_VALUE;
        
        // Iterate through the strings in list2
        for (int i = 0; i < list2.length; i++) {
            // If the map contains a string in list2, then there's a similarity and we must process it
            if (map.containsKey(list2[i])) {
                // Calculate the index sum by adding the list1 index from the map and the current index
                int indexSum = map.get(list2[i]) + i;
                
                // If the index sum is ever less than our minimum index sum, then set it, clear our restaurants list, and add the current string
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    restaurants.clear();
                    restaurants.add(list2[i]);
                } else if (indexSum == minIndexSum) {
                    // If it's equal, then we can simply add the string to our restaurants list
                    restaurants.add(list2[i]);
                }
            }
        }
        
        // Convert the restuarants list to a String array and return it
        return restaurants.toArray(new String[restaurants.size()]);
    }
}