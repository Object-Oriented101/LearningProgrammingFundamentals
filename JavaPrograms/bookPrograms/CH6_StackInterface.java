package bookPrograms;

public interface CH6_StackInterface {

	public boolean isEmpty(); //returns true if empty or else false
	public void push(Object newItem);//puts a new object into the top of the stack
	public Object pop();//takes out the top most object FIFO
	public void popAll(); //empties the stack by creating a new object
	public Object peek();//retrieves the top object
}
