/*
    Assume  you  have  a  method  isSubstring  which  checks  if  one  word  is  
    a  substring  of another   Given two strings, s1 and s2, write code to check 
    if s2 is a rotation of s1 using only one call to isSubstring 
    (i e , “waterbottle” is a rotation of “erbottlewat”) 
*/

public class CheckStringRotation {
    public static void main(String[] args) {
        // Rotation exists
        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        // Strings are empty
        String str3 = "";
        String str4 = "";

        // Strings are same length, but not a substring
        String str5 = "apple";
        String str6 = "snowy";

        System.out.println(isRotation(str1, str2));     // True
        System.out.println(isRotation(str3, str4));     // False
        System.out.println(isRotation(str5, str6));     // False

        // Two of the same strings
        System.out.println(isRotation(str5, str5));     // True

        // Two different length strings
        System.out.println(isRotation(str1, str5));     // False
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() + s2.length() == 0) {
            return false;
        } else {
            String temp = s1 + s1;
            return isSubstring(temp, s2);
        }
    }

    public static boolean isSubstring(String s1, String s2) {
        /* Get the first index from the original string that matches 
        the first letter of the substring */ 
        int index = s1.indexOf(s2.charAt(0));

        if (index < 0) {
            return false;
        }
        
        // Scan the entire substring and check that it exists within the original string
        for (int i=0; i < s2.length(); i++) {
            // System.out.println("i: " + i);
            // System.out.println("s1: " + s1.charAt(index+i));
            // System.out.println("s2: " + s2.charAt(i));
            if (s1.charAt(index+i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}