/*
    Write a method to replace all spaces in a string with ‘%20’
*/

public class ReplaceSpace {
    public static void main(String[] args) {
        char[] test1 =  {'h', 'i', ' ', 't', 'h', 'e', 'r', 'e'};

        replaceSpace(test1, 8);
    }

    public static void replaceSpace(char[] str, int length) {
        int spaceCount = 0;
        for (int i=0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        System.out.println(str);
        int newLength = length + (spaceCount*2);
        char[] newStr = new char[newLength];
        
        for (int i=length-1; i >= 0; i--) {
            if (str[i] == ' ') {
                newStr[newLength-1] = '0';
                newStr[newLength-2] = '2';
                newStr[newLength-3] = '%';
                newLength -= 3;
            } else {
                newStr[newLength - 1] = str[i];
                newLength -= 1;
            }
        }

        System.out.println(newStr);
        



    }
}
