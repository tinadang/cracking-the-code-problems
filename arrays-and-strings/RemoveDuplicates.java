/*
    Design  an  algorithm  and  write  code  to  remove  the  duplicate  characters  
    in a string without using any additional buffer.
    NOTE: One or two additional variables are fine. An extra copy of the array is not
*/

public class RemoveDuplicates {
    public static void main(String[] args) {
        char[] test1 = {'a', 'b', 'c', 'd', 'e', 'e'};

        removeDuplicates(test1);
        System.out.println(test1);
    }

    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        int len = str.length;      
        if (len < 2) return;        // If string only contains one char, there are no duplicates.

        int tail = 1;
        for (int i=1; i < len; ++i) {
            int j;
            for (j=0; j < tail; ++j) {
                System.out.println("[Before Inc] i: " + i + " j: " + j);
                if (str[i] == str[j]) break;
            }
            System.out.println("[After Inc] i: " + i + " j: " + j);
            System.out.println("Tail: " + tail);
            if (j == tail) {
                System.out.println("Updating tail...");
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }
}
