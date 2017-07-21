#include <cs50.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>
int main(void){
    

    string input = get_string();
    
    printf("%c", input[0]);
    
    for(int i = 0; i < strlen(input); i++){
        
        if(input[i] == ' '){
            
            printf("%c", toupper(input[i+1]));
        }
     
   
    }

}
