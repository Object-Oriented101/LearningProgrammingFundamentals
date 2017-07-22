#Guessing Number Game

n = int(10)


for i in range(101):
    x = input("Guess a number")
    x = int(x)

      
    if x > n:
        print("Too high")
          
    
    if x < n:
            print("Too Low")
            

    if x == n:
            print("Correctly Guessed")
            break;

  


                 
        



        
        
