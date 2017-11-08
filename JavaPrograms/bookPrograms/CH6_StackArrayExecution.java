package bookPrograms;

public class CH6_StackArrayExecution {


	public static void main(String[] args) {
		
		CH6_StackArray stack = new CH6_StackArray();
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(7);
		stack.push(8);
		stack.push(7);
		stack.push(8);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push("NEW VALUE");
		stack.push("NEW VALUE");
		stack.push("NEW VALUE");
		
		stack.printStack();

	}

}
