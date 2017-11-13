package bookPrograms;

public class CH7_QueueArrayBased implements CH7_QueueInterface{

	private final int MAX_QUEUE = 50;
	private Object[] items;
	public int front, back, count;

	public CH7_QueueArrayBased(){
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE -1;
		count = 0;
	}
	public boolean isEmpty() {
		return count == 0;

	}	
	public boolean isFull(){
		return count == MAX_QUEUE;
	}

	public void enqueue(Object newItem) {
		if(!isFull()){
			back = (back+1)%(MAX_QUEUE);
			items[back] = newItem;
			++count;		
		}else{
			System.out.println("Queue is full");
		}
	}


	public Object dequeue() {
		if(!isEmpty()){
			Object queueFront = items[front];
			front = (front+1)%(MAX_QUEUE);
			--count;
			return queueFront;
		}else{
			return "Queue is empty";
		}
	}
	public void dequeueAll() {
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE - 1;
		count = 0;

	}
	public Object peek() {
		if(!isEmpty()){
			return items[front];
		}else{
			return "Queue is empty";
		}
	}

}
