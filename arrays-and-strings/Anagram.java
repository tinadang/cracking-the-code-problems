public class Anagram {
    public static void main(String[] args) {
        System.out.println("abcd vs. cdea " + anagram("abcd", "cdba"));

    }

    public static boolean anagram(String s, String t) {
        /* If the two strings are different lengths, they are not anagrams. */
        if (s.length() != t.length()){
            return false;
        }
        
        /* Create an int array where each index represents the letter place in the alphabet 
            **only account for lowercase ASCII letters */
        int[] table = new int[26];
        for (int i=0; i < s.length(); i++) {
            /* Count the number of times a letter appears in this string */
            table[s.charAt(i) - 'a']++;
        }
        
        /* Do the same for the second string */
        for (int j=0; j < t.length(); j++) {
            /* Subtract the number of times a letter appears in this string */
            table[t.charAt(j) - 'a']--;
            /* If the number of times a letter appears is less than 0, there are more occurrences 
            of this letter in the second string than the first --> Not an anagram. */
            if (table[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    
    }
}
