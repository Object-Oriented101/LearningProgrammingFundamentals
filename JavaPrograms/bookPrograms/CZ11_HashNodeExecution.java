package bookPrograms;

public class CZ11_HashNodeExecution {

	public static void main(String[] args) {
		CZ11_HashTablewithNode hashTable = new CZ11_HashTablewithNode();
		
		hashTable.add(5);
		hashTable.add(5);
		hashTable.add(2);
		hashTable.add(3);
		hashTable.add(4);
		hashTable.add(4);
		
		System.out.println(hashTable.find(4));
		hashTable.display();

	}

}
