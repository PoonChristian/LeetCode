// LeetCode 482: License Key Formatting
// https://leetcode.com/problems/license-key-formatting/

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (int i = S.length() - 1; i >= 0; i--) {
            char curr = Character.toUpperCase(S.charAt(i));
            if (curr != '-') {
                // This if statement must come before appending the actual uppercase character below to prevent appending an extra dash to the string
                if (count == K) {
                    sb.append('-');
                    count = 0;
                }
            
                sb.append(Character.toUpperCase(curr));
                count++;
            } 
        }
        
        return sb.reverse().toString();
    }
}