    #include <cs50.h>
    #include <stdio.h>
    
    
    int convertor(int min);
    
    int main(void){
        
        printf("How many minutes does it take for you to shower?");
        int min = get_int(); 
        printf("The amount of water bottles you consume is: %i\n", convertor(min));
  
    }
    
    int convertor(int min){
      
      return min*12;  
        
    }