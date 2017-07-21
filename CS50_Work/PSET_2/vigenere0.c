#include <cs50.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>
 #include <stdlib.h>



int main(int argc, string argv[]){

    
    printf("%i\n", argc);
    string s = argv[1];
    
    
  for(int i = 0; i < strlen(s); i++){
 
      
      if(isupper(s[i])){
      s[i] = s[i] - 65;    
      
      }
      
      if(islower(s[i])){
      s[i] = s[i] - 97;    

      }
      
         printf("%i\n", s[i]);
  }
   //int key = atoi(s);
     //      printf("atoi number:%i\n", key);
  
}
    