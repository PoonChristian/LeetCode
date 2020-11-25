public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // Initialize our xor result variable
        int xor = 0;
        
        // Calculate the xor of all the nums
        for (int num : nums) {
            xor ^= num;
        }

        /*
          The XOR result will be equal to x ^ y, where x and y are the two single numbers
          Since x and y are unique, the XOR result is guaranteed to have at least one bit set to 1
          What this means is that either x or y has this bit, not both, since only 1 ^ 0 or 1 ^ 0 will yield 1.
          
          We use the following formula: (xor & -xor) to grab the rightmost bit that is set to 1.
          Partition all the numbers into two groups
            Group 1: The bit is set to 0
            Group 2: The bit is set to 1
          Check which partition a number belongs to by ANDing it with the xor value containing the rightmost bit set to 1
          Perform a XOR operation on all the numbers in their respective partitions
          Result: Duplicates in both partitions will cancel out, leaving the two single numbers left in their respective partitions
        */        
        xor &= -xor;
        
        int[] singleNums = new int[2];
        
        for (int num : nums) {
            // If the number belongs in group 1 (corresponding (num & xor) == 0), XOR it in group 1
            // Else, XOR it in group 2
            if ((num & xor) == 0) {
                singleNums[0] ^= num;
            } else {
                singleNums[1] ^= num;
            }
        }
        
        return singleNums;
    }
}
