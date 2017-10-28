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
		file.addDataset(111111);
		file.addDataset(121);
		file.printDataset();
	}

}
