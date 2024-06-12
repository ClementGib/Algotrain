// Given a string s, find the length of the longest 
// substring
//  without repeating characters.

//  O(n^2)

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


// SOLUTION 1
class Solution {
    public int lengthOfLongestSubstring(String s) {
    
        int max = 0;
        List existingChar = new HashSet<String>();
        for(char letter : s.toCharArray()) {
            if (!existingChar.contains(letter)){
                existingChar.add(letter);
            } else {
                max = max < existingChar.size() ? existingChar.size() : max;
                existingChar.clear();
            }
        };

        // iterate on s
        return existingChar.size() > max ? existingChar.size() : max;
    }
}

//  chaque opération de recherche (contains) a une complexité temporelle de O(n) dans le pire des cas, où n est la taille actuelle de la liste
// using HashSet and 
// SLIDING WINDOW

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){
           
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
                
            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            }
            
        }
        return maxLength;
    }
}