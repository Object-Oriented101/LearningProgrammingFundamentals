package bookPrograms;

public class CH7_QueueReferenceBased implements CH7_QueueInterface{

	private CH4_Node lastNode;
	public CH7_QueueReferenceBased(){
		lastNode = null;
	}
	public boolean isEmpty() {
		return lastNode == null;
	}


	public void enqueue(Object newItem) {
		CH4_Node newNode = new CH4_Node(newItem);

		if(isEmpty()){
			newNode.setNext(newNode);
		}
		else{
			newNode.setNext(lastNode.getNext());
			lastNode.setNext(newNode);
		}

		lastNode = newNode;
	}

	public Object dequeue() {
		if(!isEmpty()){
			CH4_Node firstNode = lastNode.getNext();
			if(firstNode == lastNode){
				lastNode = null;
			}else{
				lastNode.setNext(firstNode.getNext());
			}
			return firstNode.getValue();
		}else{
			return "Queue is empty";
		}
	}


	public void dequeueAll() {
		lastNode = null;
	}

	public Object peek() {
		if(!isEmpty()){
			CH4_Node firstNode = lastNode.getNext();
			return firstNode.getValue();
		}else{
			return "Queue is empty";
		}
	}


}
