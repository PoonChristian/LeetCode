// LeetCode 904: Fruit Into Baskets
// https://leetcode.com/problems/fruit-into-baskets/

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        // If the fruits array is null or empty, then return 0 immediately
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        
        // Initialize a HashMap with fruit as key and index as the value
        Map<Integer, Integer> fruitMap = new HashMap<Integer, Integer>();

        // Initialize two pointers for the sliding window and a max variable to keep track of the max amount of two different types of fruit we can take
        int i = 0;
        int j = 0;
        int maxFruit = 0;
        
        // Iterate while j is not at the end of the array
        while (j < fruits.length) {
            // If the map has less than or equal to 2 elements, then add to the map
            if (fruitMap.size() <= 2) {
                // This either adds a new fruit to the map or updates the index of a fruit that is already in the map
                fruitMap.put(fruits[j], j++);
            }
            
            // If the size of the map is ever strictly greater than 2, we must prune the oldest fruit out
            if (fruitMap.size() > 2) {
                // Set the oldest fruit index as the length of the array since we know for sure it can't be at the end of the array
                int oldestFruitIndex = fruits.length - 1;
                
                // Iterate over all the indices of the fruit map
                for (int fruitIndex : fruitMap.values()) {
                    // Update the index of the oldest fruit as we iterate through the fruit indices
                    oldestFruitIndex = Math.min(oldestFruitIndex, fruitIndex);
                }
                
                // Set i equal to the index after the oldest fruit
                i = oldestFruitIndex + 1;
                // Remove the oldest fruit from the map
                fruitMap.remove(fruits[oldestFruitIndex]);
            }
            
            // Update the maxFruit value at each iteration
            maxFruit = Math.max(maxFruit, j - i);
        }
        
        // Return the maxFruit value
        return maxFruit;
    }
}
