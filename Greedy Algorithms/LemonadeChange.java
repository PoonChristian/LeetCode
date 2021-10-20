// LeetCode 860: Lemonade Change
// https://leetcode.com/problems/lemonade-change/

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        // Keep track of the number of fives and tens you have for change
        int fives = 0;
        int tens = 0;
        
        // Iterate through all the bills
        for (int bill: bills) {
            // If the bill is a 5, then we can add this to our collection of fives
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                // If the bill is 10, then we must give out a 5 before we can take the 10
                fives--;
                tens++;
            } else if (tens > 0) {
                // If the above two cases don't hit, then this case will handle when the bill is 20
                // So if we have more than one 10, then we can give back a 10 and a 5 as change for a 20
                fives--;
                tens--;
            } else {
                // If we don't have any 10's, then we have to give out three 5's as change for a 20
                fives -= 3;
            }
            
            // If there are no more fives after performing the above calculations, then we can't give out change, so return false
            if (fives < 0) {
                return false;
            }
        }
        
        // Return true if we can make it all the way to the end of the loop
        return true;
    }
}
