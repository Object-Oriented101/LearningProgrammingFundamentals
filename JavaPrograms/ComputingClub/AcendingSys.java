package ComputingClub;

public class AcendingSys {
	public static void main(String args[]){
		sort("31415926538");
	}


	public static void sort(String input){

		//--------------------------Variables declared--------------------------------------------------------
		boolean check = false;
		boolean check1 = false;
		int subtract = 1;
		int add = 0;
		int constant = 1;


		String left = input.substring(0,1);
		String right = input.substring(input.length()-1,input.length());

		input = input.substring(1,input.length());
		System.out.println("Put in first:"+left);
		
		//---------------------Main code
		while(input.length() != 0){

			System.out.println("Start:left is "+ left+" right is "+right);

			check = false;
			check1 = false;
			subtract = 1;
			add = 0;
			constant = 1;
			if(input.length() < left.length()){
				System.out.println("break occured");
				break;
			}

			//--------------------------------------Compares Number on the left with the number on the right----------------------------------------
			right = input.substring(input.length()-1,input.length());
			while(!check){

				if(Integer.parseInt(left) < Integer.parseInt(right)){ //if the right number in one digit is greater than the left number
					input = input.substring(0, input.length()-constant);
					System.out.println("Put in right:"+ right);
					System.out.println("Array is:"+input);
					check = true;
				}else{
					subtract++;
					constant++;
					right = right+input.substring(input.length()-subtract, input.length()-subtract+1);
					System.out.println("New Right is:"+ right);
				}
				//--------------------------------------Compares Number on the right with the new number on the left---------------------------------------

			}
			System.out.println();

			left = input.substring(0,1);
			System.out.println("left is "+ left+" right is "+right);

			while(!check1){
				if(Integer.parseInt(right) < Integer.parseInt(left)){
					System.out.println("Put in left:"+left);
					input= input.substring(left.length(), input.length());
					System.out.println("Array is:"+input);
					check1 = true;
				}else{
					add++;
					//constant++;
					left =left+input.substring(add,add+1);
					System.out.println("New left is:"+ left);
				}
			}
			System.out.println("At the end, left is "+ left+" and right is "+ right);
			System.out.println();


		}
	}

}
