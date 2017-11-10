package bookPrograms;

public class CH6_PostfixImplementation {

	String input;
	CH6_StackADTList stack = new CH6_StackADTList();


	public CH6_PostfixImplementation(String input){
		this.input = input;
	}

	public Object solve(){
	
		for(int i = 0; i < input.length(); i++){
			if(input.substring(i,i+1).matches("\\d+")){
				stack.push(input.substring(i,i+1));
			}else{

				String operand2 = (String)stack.pop();
				String operand1 = (String)stack.pop();

				int result = 0;
				if(input.substring(i,i+1).equals("+")){
					result = Integer.parseInt(operand1)+Integer.parseInt(operand2);
				}if(input.substring(i,i+1).equals("-")){
					result = Integer.parseInt(operand1)-Integer.parseInt(operand2);
				}if(input.substring(i,i+1).equals("*")){
					result = Integer.parseInt(operand1)*Integer.parseInt(operand2);
				}if(input.substring(i,i+1).equals("/")){
					result = Integer.parseInt(operand1)/Integer.parseInt(operand2);
				}
				stack.push(Integer.toString(result));//this will add it to the top of the stack, but the counter is based on the string not the stack so doesn't affect anything
			}
		}

		return stack.peek();
	}
}
