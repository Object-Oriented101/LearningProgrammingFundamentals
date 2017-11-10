package bookPrograms;

public class CH6_StackADTList implements CH6_StackInterface{

	private CH4_ListInterface list;
	
	public CH6_StackADTList(){
		list = new CH4_ListReferenceBased();
	}
	public boolean isEmpty() {
		return list.isEmpty(); //using build in methods now
	}

	public void push(Object newItem){ 
			list.add(1, newItem);
	}

	public Object pop() {
		if(!list.isEmpty()){
			Object temp = list.get(1);
			list.remove(1);
			return temp;
		}else{
			return "List is empty";
		}
	}

	public void popAll() {
		list.removeAll();
		
	}

	public Object peek() {
		if(!list.isEmpty())
			return list.get(1);
		else
			return "List is empty";
	}

	
	
}
