    #include <cs50.h>
    #include <stdio.h>

void print_name(string name);//declaring the function so to speak because if do not put this this function isn't recognized, which will give error

int main(void){

    string s = get_string();
    print_name(s);


}

void print_name(string name){
    
    printf("hello %s/n", name);
}
//order does make a difference here 