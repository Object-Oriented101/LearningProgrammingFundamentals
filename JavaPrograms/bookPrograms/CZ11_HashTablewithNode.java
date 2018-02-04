package bookPrograms;


public class CZ11_HashTablewithNode {

	static CH4_Node[] array = new CH4_Node[10];

	private  int Hash(int input) { //This can also be a fancy algorithm. Kept simple to understand the concept
		int generator = input % array.length;
		return generator;
	}
	public  void display() {
		CH4_Node temp;
		for(int i = 0; i < array.length; i++) {
			temp = array[i];
			System.out.println("_"+i);
			if(array[i] == null) {			
				continue;
			}else {
				while(array[i] != null) {
					System.out.println(temp.getValue());
					if(temp.getNext() != null) {
						temp = temp.getNext();
					}else {
						break;
					}
				}
			}
		}
	}

	public  void add(int input) {
		int index = Hash(input);
		if(array[index] == null) {
			array[index] = new CH4_Node(input);
		}else {
			recursiveSolution(array[index], input);
		}
	}

	public void recursiveSolution(CH4_Node input, int value) {
		if(input.getNext() == null) {
			input.setNext(new CH4_Node(value));
			return;
		}
		recursiveSolution(input.getNext(), value);

	}

	public int find(int target) {
		int index = Hash(target);
		if(array[index] == null) {
			System.out.println("This element isn't present in the array");
			return -1;
		}else {

			return index;
		}


	}


}


