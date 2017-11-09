package bookPrograms;

public class CH4_ListReferenceBased implements CH4_ListInterface{

	private CH4_Node head;
	private int numItems; //number of items in the list

	public CH4_ListReferenceBased(){
		numItems = 0;
		head = null;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public int size() {
		return numItems;
	}

	private CH4_Node find(int index){
		CH4_Node curr = head;
		for(int skip = 1; skip < index; skip++){// not less than equal to because considers 0 indexed
			curr = curr.getNext();
		}
		return curr;
	}
	public void add(int index, Object item) throws Exception {

		if(index >= 1 && index <= numItems+1){ //not zero indexed
			if(index == 1){
				CH4_Node newNode = new CH4_Node(item, head);
				head = newNode;
			}else{
				CH4_Node prev = find(index -1);
				CH4_Node newNode = new CH4_Node(item, prev.getNext());
				prev.setNext(newNode);
			}
			numItems++;
		}else{
			throw new Exception("List index out of bounds");
		}

	}

	public void remove(int index) {

		if(index >= 1 && index <= numItems+1){
			if(index == 1){
				head = head.getNext();//references to null
			}else{
				CH4_Node currprevious = find(index - 1);
				CH4_Node curr = currprevious.getNext();
				currprevious.setNext(curr.getNext());
			}numItems--;
		}else{
			System.out.println("Index is out of range");
		}

	}

	public Object get(int index) {
		if(index >=1 && index <= numItems){
			CH4_Node curr = find(index);
			Object dataItem = curr.getValue();
			return dataItem;
		}else{
			return "List index out of bounds";
		}
	}

	public void removeAll() {
		head = null;
		numItems = 0;
	}


}
