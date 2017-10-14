package bookPrograms;

public class CH3_ADTBasicExecution {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) throws Exception {
		CH3_ADTBasic file = new CH3_ADTBasic(5);
		file.addDataset(5);
		file.addDataset(5);
		file.addDataset(5);
		file.addDataset(111111);
		file.removeDataset(4);
		file.replaceDataset(2525,3);
		file.printDataset();
	}

}
