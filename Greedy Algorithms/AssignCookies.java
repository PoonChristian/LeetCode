// LeetCode 455: Assign Cookies
// https://leetcode.com/problems/assign-cookies/

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both arrays in ascending order to easily get the greediest child and biggest cookie
        Arrays.sort(s);
        Arrays.sort(g);
        
        // Initialize an int variable to store the number of content children
        int contentChildren = 0;
        // Initialize pointers to the end of both arrays (starting from the greediest child and biggest cookie)
        int i = g.length - 1;
        int j = s.length - 1;
        
        // Iterate while both of the pointers are greater than 0
        while (i >= 0 && j >= 0) {
            // If the cookie at the jth index is big enough to satisfy child at the ith index, then increment the number of content children and decrement j
            // No matter what, we want to decrement i because only 1 cookie can be assigned to 1 child
            // i.e. If the child can't take the jth cookie, then we just see if the next child can take it (decrement i)
            if (s[j] >= g[i--]) {
                contentChildren++;
                j--;
            }
        }
        
        // Return the number of content children
        return contentChildren;
    }
}
