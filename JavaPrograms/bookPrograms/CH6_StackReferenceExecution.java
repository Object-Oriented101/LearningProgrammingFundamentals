package bookPrograms;

public class CH6_StackReferenceExecution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CH6_StackReference dataset = new CH6_StackReference();
		
		dataset.push(5);
		dataset.push(6);
		dataset.push(5);
		System.out.println(dataset.pop());
		//System.out.println(dataset.peek());

	}

}
