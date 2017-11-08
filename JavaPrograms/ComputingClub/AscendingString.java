package ComputingClub;

//import java.util.ArrayList;
/*
	Name: Prajeet Sangamnerkar
	Problem: Ascending Strings(Senior Division)

 */
public class AscendingString {
	public static void main(String args[]){
		sort("314159265");
	}

	public static void sort(String input){
		boolean check = false; 
		boolean check1 = false;
		int subtract = 1; 
		int constant = 1;
		int add = 0; 
		String left = input.substring(0,1);
		String right = input.substring(input.length()-1,input.length());

		input = input.substring(1,input.length()); 
		System.out.print(left+" ");

		while(input.length() != 0){
			check = false;
			check1 = false;
			subtract = 1;
			add = 0;
			constant = 1;

			if(input.length() < left.length()){ 
				break;
			}

			right = input.substring(input.length()-1,input.length()); 

			while(!check){

				if(Integer.parseInt(left) < Integer.parseInt(right)){
					input = input.substring(0, input.length()-constant);
					System.out.print(right+" ");
					check = true;
				}else{ 
					subtract++;
					constant++;
					right = right+input.substring(input.length()-subtract, input.length()-subtract+1);
				}
			}
			left = input.substring(0,1);

			while(!check1){
				if(Integer.parseInt(right) < Integer.parseInt(left)){ 
					System.out.print(left+" ");
					input= input.substring(left.length(), input.length());
					check1 = true;
				}else{
					add++;
					left =left+input.substring(add,add+1);				
				}
			}
		}
	}

}
