#include <stdbool.h>
#include <string.h>

bool isAnagram(char * s, char * t) {
    // If lengths are different, they can't be anagrams
    if (strlen(s) != strlen(t)) {
        return false;
    }
    
    int count[26] = {0}; // Frequency array for 26 letters
    
    // Count the frequency
    for (int i = 0; s[i] != '\0'; i++) {
        count[s[i] - 'a']++;
        count[t[i] - 'a']--;
    }
    
    // Check if all counts are zero
    for (int i = 0; i < 26; i++) {
        if (count[i] != 0) {
            return false;
        }
    }
    
    return true;
}

    
