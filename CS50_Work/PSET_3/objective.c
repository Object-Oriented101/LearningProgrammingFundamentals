#include <cs50.h>
#include <stdio.h>

void sort(int values[], int n);
void find(int target,int values[], int n);
int main(void){
    
    int test[6] = {5,4,3,2,1,0};
     printf("Before:");
     
    for(int i = 0; i < 6; i++){ // creates test array with decending order in order to sort
         printf("%i", test[i]);
       
         }
         printf("\n");
      sort(test, 6);
       printf("\nAfter:");
       
   
     for(int i = 0; i < 6; i++){ // creates test array with decending order in order to sort
         printf("%i", test[i]);
       
         }
    printf("\n");
    find(8,test, 6);
    
   }
   
   
   //SORTER
   void sort(int values[], int n){
    
    for(int i = 0; i < n; i++){
        int min = i;      
        
        for(int y = i + 1; y < n; y++){
            if(values[min] > values[y]){
            min = y;   
            }
        
            if(min != i){
            int temp = values[min];
            values[min] = values[i];
            values[i] = temp;
           
            }
        
        }
        }
        
    };
   
   //FINDER
   
    void find(int target,int values[], int n){
        
        int low = 0;
        int high = n;
        int middle = (high-low)/2;
        
        while(n > 0){
        if(values[middle] == target){
            
            printf("This number is in the data set");
            break;
        }else if(values[middle] > target){
            
            low = middle - 1;
        }else if(values[middle] < target){
            
            high = middle + 1;
        }else{
            printf("This number isn't in the dataset");
            
        }
    }
            
            
};