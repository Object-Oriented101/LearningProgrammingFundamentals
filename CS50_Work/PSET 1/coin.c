#include <cs50.h>
#include <stdio.h>




int main(void){
    
    
    void calculator(float x);
    printf("How much change do you owe?\n");
    float x = get_float();
    while(x < 0 ){
        printf("Pick a non-negative number");
        x = get_int();
    };
    
    calculator(x);
    

}


void calculator(float x){
  
  int counter = 0;
  while(x >= .25){
    counter = counter + 1;
    x = x-0.25;
  };

  
  while(x >= .1){
    counter = counter + 1;
    x = x-0.1;
  };
  
    while(x >= .05){
    counter = counter + 1;
    x = x-0.05;
  };
  
    while(x >= .01){
    counter = counter + 1;
    x = x-0.01;
  };
  
    printf("Amount of coins needed: %i\n", counter);
  
}


   
