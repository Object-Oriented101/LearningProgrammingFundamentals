package bookPrograms;

public interface CH7_QueueInterface {

	public boolean isEmpty();
	public void enqueue(Object newItem);
	public Object dequeue();
	public void dequeueAll();
	public Object peek();
}
