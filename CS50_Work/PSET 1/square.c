#include <cs50.h>
#include <stdio.h>

int square(int r);

int main(void){
    
    printf("Enter a number to square");
    int s = get_int();
    printf("That number squared is %i/n",square(s));
}

int square(int r){
    
  return r*r; 
}