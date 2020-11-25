// LeetCode 136: Single Number
// https://leetcode.com/problems/single-number/

public class SingleNumber {
    public int singleNumberHashMap(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numMap.keySet()) {
            if (numMap.get(num) == 1) {
                return num;
            }
        }

        throw new IllegalArgumentException("There is no single number");
    }

    public int singleNumberBitManipulation(int[] nums) {
        int xor = 0;
        
        for (int num : nums) {
            // x ^ x = 0 and x ^ 0 = x
            // Therefore, all duplicates will get canceled and we will be left with the single number
            xor ^= num;
        }
        
        return xor;
    }
}
