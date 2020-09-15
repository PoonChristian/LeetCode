// LeetCode 771: Jewels and Stones
// https://leetcode.com/problems/jewels-and-stones/

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        int numJewelsOwned = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                numJewelsOwned++;
            }
        }

        return numJewelsOwned;
    }
}
