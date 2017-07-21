#include <cs50.h>
#include <stdio.h>


void height(int y);

int main(void){
    
    printf("How tall do you want the pyramid to be?\n");
    int x = get_int();
    while(x < 0 || x == 0 || x > 23){
        printf("Please pick a number between 1 and 23 only. Retry:");
        x = get_int();
    };
    
    height(x);
}


void height(int y){
    
    for(int i = 0; i<y;i++){

        
        for(int m = 0; m < (y-i-1); m++){
            
            printf(" ");
        }
        for(int z = 0; z < i; z++){
          printf("#");
          }
     printf("\n");
}
}


   
