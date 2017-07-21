/**
 * helpers.c
 *
 * Helper functions for Problem Set 3.
 */
 
#include <cs50.h>

#include "helpers.h"

/**
 * Returns true if value is in array of n values, else false.
 */
bool search(int value, int values[], int n)
{ // value = number trying to find, values = number in haystack, n = number of numbers
    
   int low = 0;
   int high = n;
   int currentIndex;
    
    while(n > 0){
        
        
        currentIndex = (high-low)/2;
        
        
        if(values[currentIndex] == value){
            return true;
            
        }else if(values[currentIndex] < value){
        
            low = currentIndex + 1;
        }else if( values[currentIndex] > value){
            
            high = currentIndex - 1;
        }
        
    }
    
    return false;
    
    // TODO: implement a searching algorithm
    
}

/**
 * Sorts array of n values.
 */
void sort(int values[], int n){
    
    for(int i = 0; i < n - 2; i++){
        
        int min = i;
        
        
        for(int y = i + 1; y < n; y++){
            
            if(values[min] > values[y]){
                
            min = y;   
            
        }
        
        if(min != i){
            
            int temp = values[min];
            values[min] = values[i];
            temp = values[i];
        }
        
        
        }
        
    }
    
    
    
    
    
    
}










