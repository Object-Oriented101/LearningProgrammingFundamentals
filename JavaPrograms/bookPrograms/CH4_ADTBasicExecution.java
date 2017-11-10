package bookPrograms;

public class CH4_ADTBasicExecution {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) throws Exception {
		CH4_ADTBasic file = new CH4_ADTBasic(5);
		file.addDataset(5);
		file.addDataset(5);
		file.addDataset(5);
		file.addDataset(111111);
		file.addDataset(111111);
		file.addDataset(121);
		file.printDataset();
	}

}
