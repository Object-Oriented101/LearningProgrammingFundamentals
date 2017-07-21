#include <cs50.h>
#include <ctype.h>
#include <stdio.h>
#include <string.h>

int main(void) {
    string s = GetString();
    printf("%c", toupper(s[0]));
   for(int i = 0, n = strlen(s); i < n; i++) {
       //check if loop encounters a space and if the index reaches 
       //the end of the string
       if(s[i] == ' ' && s[i+1] != '\0') {
        printf("%c", toupper(s[i + 1]));
        i++;
       }
   }
   printf("\n");
}