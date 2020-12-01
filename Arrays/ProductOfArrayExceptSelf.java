public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // Intialize result array
        int[] products = new int[n];
        
        // Set first index of array to be 1 to represent the product left of index 0 to be 1
        products[0] = 1;
        
        // Iterate from index 1 to n and fill each index to be equal to the product to the left of the index
        for (int i = 1; i < n; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        
        // Initialize a rightProduct variable
        int rightProduct = 1;

        // Iterate from n - 1 to 0 and multiply each index with the value of rightProduct
        // Multiply rightProduct by nums[i] in order to calculate the new rightProduct as we iterate left
        for (int i = n - 1; i >= 0; i--) {
            products[i] = products[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        // Return the products array
        return products;
    }
}
