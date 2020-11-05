// LeetCode 860: Lemonade Change
// https://leetcode.com/problems/lemonade-change/

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        
        for (int bill: bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                fives--;
                tens++;
            } else if (tens > 0) {
                fives--;
                tens--;
            } else {
                fives -= 3;
            }
            
            if (fives < 0) {
                return false;
            }
        }

        return true;
    }
}
