// LeetCode 258: Add Digits
// https://leetcode.com/problems/add-digits/

public class AddDigits {
    public int addDigitsNaive(int num) {
        // While num is greater than 9, then we have to calculate the sum of its digits
        while (num > 9) {
            int sum = 0;

            // In order to calculate the sum, do the following:
            // Get the rightmost digit with num % 10
            // Chop off the rightmost digit with num / 10
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            
            // Set num equal to the sum. If it's still two digits, then we repeat the process. If not, then we break out
            num = sum;
        }

        return num;
    }


    /*
        This function uses a formula (Digital Root) that can be found out by printing out the results of the naive solution and noticing a pattern:
        0 => 0
        1 => 1
        2 => 2
        3 => 3
        4 => 4
        5 => 5
        6 => 6
        7 => 7
        8 => 8
        9 => 9
        10 => 1
        11 => 2
        12 => 3
        13 => 4
        14 => 5
        15 => 6
        16 => 7
        17 => 8
        18 => 9
        19 => 1
        20 => 2
        21 => 3
        22 => 4
        23 => 5
        24 => 6
        25 => 7
        26 => 8
        27 => 9
        28 => 1
        29 => 2
        30 => 3
        31 => 4
        32 => 5
        33 => 6
        34 => 7
        35 => 8
        36 => 9
        37 => 1
        38 => 2
        39 => 3
        40 => 4
        .
        .
        .
    */
    public int addDigitsConstantTimeFormula(int num) {
        if (num < 10) {
            return num;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}