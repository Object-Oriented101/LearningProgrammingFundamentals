#include <cs50.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>
 #include <stdlib.h>



int main(int argc, string argv[]){

  
if(isalnum(argv[1])){
    
    if(argc == 2 )  {
        
        int key = atoi(argv[1]);
        
        printf("%s\n", argv[1]); // test to make sure right value is placed in key
        
        
        string s = get_string(); // takes in the plain text
        
        for(int i = 0; i < strlen(s); i++){
            
            // if alphavet is lower case
           if(islower(s[i])){    
           int new_letter = (((s[i]-71) + key)+71);
           printf("%c", new_letter);
            }
   
            // if alphabet is upper case
            if(isupper(s[i])){
           int new_letter = (((s[i]-65) + key) % 26); // first part turns the current alphabet into the value for alphabetical index. Adds to cipher the letter. Modulu 26 as per the formula
           new_letter = new_letter +65;//brings alphabet to ascii value so that can print it
            printf("%c", new_letter);
            }
    
          
            }
             
             printf("\n");
             
    }else{
        
        printf("There can only be 2 arguments");
        return 1;
    }
    
    }else{
        
        printf("Second argument can only be a number");
        return 1;
    }
    
    
    
    
    
}