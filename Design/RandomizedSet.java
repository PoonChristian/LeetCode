// LeetCode 380: Insert Delete GetRandom O(1)
// https://leetcode.com/problems/insert-delete-getrandom-o1/

public class RandomizedSet {
    private Map<Integer, Integer> numIndexMap;
    private List<Integer> nums;
    private Random random;
    
    public RandomizedSet() {
        numIndexMap = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        // If val is already in the map, then return false to denote that val could not be inserted
        if (numIndexMap.containsKey(val)) {
            return false;
        } else {
            // If val is not in the list, then add it into the list
            nums.add(val);

            // Add val and its index to the map
            // The index will be at the end of the list, so it will be (nums.size() - 1)
            numIndexMap.put(val, nums.size() - 1);

            // Return true to denote that val was successfully inserted
            return true;
        }
    }
    
    public boolean remove(int val) {
        // If val is not the map, then return false to denote that val could not be removed
        if (!numIndexMap.containsKey(val)) {
            return false;
        } else {
            // Get the index of the value we want to remove
            int index = numIndexMap.get(val);

            // Get the last element of the list
            int lastElement = nums.get(nums.size() - 1);

            // Move the last element to the index of the value we want to remove
            // This means the list will temporarily have two occurrences of the last element
            nums.set(index, lastElement);

            // Update the index of the lastElement in the map as well
            numIndexMap.put(lastElement, index);

            // Remove the value from the map
            numIndexMap.remove(val);

            // Remove the lastElement at the end of the array
            // We preserved the last element by setting it at index, so this operation will just remove the duplicate at the end
            nums.remove(nums.size() - 1);

            // Return true to denote that val was successfully removed
            return true;
        }
    }
    
    public int getRandom() {
        // To get a random index, call random.nextInt() on the size of nums
        // Pass this index to nums.get() and return the value
        return nums.get(random.nextInt(nums.size()));
    }
}
