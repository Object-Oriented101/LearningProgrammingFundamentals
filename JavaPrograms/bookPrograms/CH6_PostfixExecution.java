package bookPrograms;

public class CH6_PostfixExecution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CH6_PostfixImplementation program = new CH6_PostfixImplementation("11*2*");
		System.out.println(program.solve());

	}

}
