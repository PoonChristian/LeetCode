// LeetCode 500: Keyboard Row
// https://leetcode.com/problems/keyboard-row/

public class KeyboardRow {
    public String[] findWords(String[] words) {
        // Initialize a map containing the character-row pairs
        Map<Character, Integer> keyboard = Map.ofEntries(
            Map.entry('q', 1),
            Map.entry('w', 1),
            Map.entry('e', 1),
            Map.entry('r', 1),
            Map.entry('t', 1),
            Map.entry('y', 1),
            Map.entry('u', 1),
            Map.entry('i', 1),
            Map.entry('o', 1),
            Map.entry('p', 1),
            Map.entry('a', 2),
            Map.entry('s', 2),
            Map.entry('d', 2),
            Map.entry('f', 2),
            Map.entry('g', 2),
            Map.entry('h', 2),
            Map.entry('j', 2),
            Map.entry('k', 2),
            Map.entry('l', 2),
            Map.entry('z', 3),
            Map.entry('x', 3),
            Map.entry('c', 3),
            Map.entry('v', 3),
            Map.entry('b', 3),
            Map.entry('n', 3),
            Map.entry('m', 3)
        ); 
        
        List<String> oneRowWords = new ArrayList<String>();
        
        for (String word : words) {
            if (isWordOnOneLine(word, keyboard)) {
                oneRowWords.add(word);
            }
        }
        
        return oneRowWords.toArray(new String[oneRowWords.size()]);
    }
    
    public boolean isWordOnOneLine(String word, Map<Character, Integer> keyboard) {
        // Initialize row to be -1 because we don't know what row the word should belong in yet
        int row = -1;
        
        for (int i = 0; i < word.length(); i++) {
            // Set a temp variable to get the row of the current character
            int temp = keyboard.get(Character.toLowerCase(word.charAt(i)));
            
            // From the 2nd character onwards, if the current character doesn't match the previous character's row then return false immediately
            if (i > 0 && temp != row) {
                return false;
            }
            
            // Update the row variable to be the row of the current character
            row = temp;
        }
        
        // Return true if we were able to iterate through the entire word
        return true;
    }
}