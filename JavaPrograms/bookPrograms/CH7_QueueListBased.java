package bookPrograms;

public class CH7_QueueListBased implements CH7_QueueInterface {

	CH4_ListInterface list;

	public CH7_QueueListBased(){
		list = new CH4_ListReferenceBased();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}


	public void enqueue(Object newItem) {
		list.add(list.size()+1,newItem); //size not the length of the list, but how many are currently taken(not an array but linked list(
	}
	public Object dequeue() {
		if(!isEmpty()){
			Object queueFront = list.get(1);
			list.remove(1);
			return queueFront;
		}else{
			return "List is empty";
		}
	}
	public void dequeueAll() {
		list.removeAll();
	}
	public Object peek() {
		if(!isEmpty()){
			return list.get(list.size());
		}else{
			return "List is already empty";
		}
	}

}
