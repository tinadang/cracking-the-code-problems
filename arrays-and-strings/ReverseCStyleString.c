// "Write code to reverse a C-Style String  (C-String means that “abcd” is represented 
//  as five characters, including the null character )"


/* Solution #1
    Assumptions:

    Complexity:

*/
void reverse(char *str) {
    char *right = str;    // Set the right (end of string) pointer to the start of the string
    char tmp;           // Create a temp variable to store the character to swap
    if (str) {
        printf("HELLO");
        /*
            Start from the start of the string and loop through until we reach
            the terminating null 
        */
        while (*right) {
            ++right;
        }
        --right;      // Backtrack one step from the terminating null to get the last char

        /*
            Ensures that reversal will not happen with empty strings;
            While the left and right pointers have not crossed each other (when str == right), 
            swap the two characters
        */
        while (str < right) {
            tmp = *str;     // Store the character we wish to swap in a temp var
            *str = *right;  // Set the left character equal to the right character
            *right = tmp;   // Set the right character equal to the temp var
            str++;          // Move the left pointer to the right (converge to center)
            right--;        // Move the right pointer to the left (converge to center)
            // *str++ = *end;
            // *end-- = tmp;
        }
    }
}

int main() {
    char str[] = "hello";

    printf("Before: %s\n", str);
    reverse(str);
    printf("After: %s\n", str);

    char str2[] = "";

    printf("Before: %s\n", str2);
    reverse(str2);
    printf("After: %s\n", str2);
}