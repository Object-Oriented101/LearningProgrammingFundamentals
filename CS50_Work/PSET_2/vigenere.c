#include <cs50.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>



int main(int argc, string argv[]){

    
    printf("Test:%i\n", argc);
    string s = argv[1];
    
    
  
    for(int i = 0; i < strlen(s); i++){
      
      if(isupper(s[i])){
      s[i] = s[i] - 65;    
      
      }
      
      if(islower(s[i])){
      s[i] = s[i] - 97;    

      }
      //THIS PART IS WORKING PERFECTLY
      
      
 }
    
    // RETURNS 0 IF NOT IN CORRECT INDEX/BLANK INDEX
    
    
    string input = get_string();


    

    for(int i = 0; i < strlen(input); i++){
        
        char c = input[i]; // c is each individual character
        // printf("%i", s[i]);
        int length = strlen(argv[1]); // length is how many letters(THIS DOES WORK)
        int m = s[i] % length;
        if( m == 0){
            m = 1;

        }
        c = c + m;// problem is if i goes above 0 and there is only 1 letter then nothing happens
        printf("%c", c);
        
        
    }
    
    printf("\n");
    
        

}
    
