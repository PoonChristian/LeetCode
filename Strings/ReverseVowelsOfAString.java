// LeetCode 345: Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/

public class ReverseVowelsOfAString {
    private boolean isVowel(char letter) {
        char c = Character.toLowerCase(letter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public String reverseVowels(String s) {
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = sArray.length - 1;
        
        while (i < j) {
            while (i < j && !isVowel(sArray[i])) {
                i++;
            }
            
            while (i < j && !isVowel(sArray[j])) {
                j--;
            }
            
            swap(sArray, i++, j--);
        }
        
        return new String(sArray);
    }
}
