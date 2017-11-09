package bookPrograms;

public interface CH4_ListInterface {
	public boolean isEmpty();
	public int size();
	public void add(int index, Object item) throws Exception;
	public void remove(int index);
	public Object get(int index);
	public void removeAll();
}
