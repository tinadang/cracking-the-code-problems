public class AllUniqueChars {
    public static void main(String[] args) {
        // "Implement  an  algorithm  to  determine  if  a string  has  all  unique  characters"
        String test = "abcdef89373"; // Solution 1

        String test2 = "hello";      // Solution 2

        String test3 = "maven";      // Solution 2

        System.out.println(isUniqueChars(test));
        System.out.println(isUniqueChars(test2));
        System.out.println(isUniqueChars(test3));

    }

    /* SOLUTION #1 
        Assumptions:
            - Char set is ASCII
        
        Complexity:
            Space: O(n)
            Time:  O(n)
    */

    // public static boolean isUniqueChars(String str) {
    //     boolean[] char_set = new boolean[256];
    //     for (int i=0; i < str.length(); i++) {
    //         int val = str.charAt(i);
    //         if (char_set[val]) return false;
    //         char_set[val] = true;
    //     }

    //     return true;
    // }

    /* SOLUTION #2 
        Assumptions:
            - String is only lowercase 'a' to 'z'
        
        Complexity:
            Space: O(n) (?)
            Time:  O(n)
    */

    public static boolean isUniqueChars(String str) {
        /*
        checker is the bit array, it will have a 1 on the character index that
        has appeared before and a 0 if the character has not appeared, you
        can see this number initialized as 32 0 bits:
        00000000 00000000 00000000 00000000
        */
        int checker = 0;

        for (int i = 0; i < str.length(); ++i) {
            /*
            a through z in ASCII are characters numbered 97 through 122 (26 characters total)
            you get a number between 0 and 25 to represent each character index
            0 for 'a' and 25 for 'z'
            */
            int val = str.charAt(i) - 'a';

            /* 
            (1 << val):  It is used to calculate a number that represents the bit value of having that 
            character index as a 1 and the rest as a 0, this is achieved
            by getting the single digit 1 and shifting it to the left as many
            times as the character index requires
            e.g. character 'd'
            00000000 00000000 00000000 00000001
            Shift 3 spaces to the left (<<) because 'd' index is number 3
                1 shift: 00000000 00000000 00000000 00000010
                2 shift: 00000000 00000000 00000000 00000100
                3 shift: 00000000 00000000 00000000 00001000

            Therefore the number representing 'd' is
                00000000 00000000 00000000 00001000
            
            (checker & (...)): This performs an AND between the checker, which is the bit array
            containing everything that has been found before and the number
            representing the bit that will be turned on for this particular
            character. e.g.
            if we have already seen 'a', 'b' and 'd', checker will have:
                checker = 00000000 00000000 00000000 00001011
                And if we see 'b' again:
                'b' = 00000000 00000000 00000000 00000010

            It will do the following:
                00000000 00000000 00000000 00001011
                & (AND)
                00000000 00000000 00000000 00000010
                -----------------------------------
                00000000 00000000 00000000 00000010

            Since this number is different than '0' it means that the character
            was seen before, because on that character index we already have a 
            1 bit value
            */

            if ((checker & (1 << val)) > 0) return false;

            /* 
            Remember that 
                checker |= singleBitOnPosition 
            is the same as  
                checker = checker | singleBitOnPosition
            
            Sometimes it is easier to see it expanded like that.

            What this achieves is that it builds the checker to have the new 
            value it hasnt seen, by doing an OR between checker and the value 
            representing this character index as a 1. e.g.
            If the character is 'f' and the checker has seen 'g' and 'a', the 
            following will happen
                'f' = 00000000 00000000 00000000 00100000
                checker(seen 'a' and 'g' so far) = 00000000 00000000 00000000 01000001

                00000000 00000000 00000000 00100000
                | (OR)
                00000000 00000000 00000000 01000001
                -----------------------------------
                00000000 00000000 00000000 01100001

            Therefore getting a new checker as 00000000 00000000 00000000 01100001
            */
            checker |= (1 << val);
        }

        return true;
    }
}