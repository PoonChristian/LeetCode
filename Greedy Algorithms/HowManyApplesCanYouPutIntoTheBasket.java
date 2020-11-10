// LeetCode 1196: How Many Apples Can You Put into the Basket
// https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/

public class HowManyApplesCanYouPutIntoTheBasket {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int weight = 5000;
        
        for (int i = 0; i < arr.length; i++) {
            weight -= arr[i];
            if (weight < 0) {
                return i;
            }
        }
        
        return arr.length;
    }
}
