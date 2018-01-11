package bookPrograms;

import org.junit.Test;

public class CZ10_BinaryTreeTest {

	@Test
	public void test() {
		CZ10_BinaryTree tree = new CZ10_BinaryTree();
		tree.add(50);
		tree.add(25);
		tree.add(75);
		tree.add(10);
		tree.add(1);
		tree.add(30);
		tree.add(100);
		tree.add(105);
		
		tree.delete(75);
		tree.traverse();
		
		System.out.println("");
		
		
	}
}
