package bookPrograms;

public class CZ10_BinaryTree {

	CZ10_TreeNode root;

	public void add(int data) {
		CZ10_TreeNode nodeToAdd = new CZ10_TreeNode(data);

		if(root == null) { //there is no root
			root = nodeToAdd;
			return;
		}

		traverseAndAddNode(root, nodeToAdd);
	}


	private void traverseAndAddNode(CZ10_TreeNode node, CZ10_TreeNode nodeToAdd) {

		if(nodeToAdd.data < node.data) {
			if(node.leftChild == null) {
				nodeToAdd.parent = node;
				node.leftChild = nodeToAdd;

			}else {
				traverseAndAddNode(node.leftChild, nodeToAdd);
			}
		}else if(nodeToAdd.data > node.data){
			if(node.rightChild == null) {
				nodeToAdd.parent = node; 
				node.rightChild = nodeToAdd;
			}else {
				traverseAndAddNode(node.rightChild, nodeToAdd);
			}
		}

	}

	public boolean delete(int val) {

		CZ10_TreeNode NodeToBeDeleted = find(val);
		if(NodeToBeDeleted != null) {
			//CASE 1: If the deleted node has no children
			if(NodeToBeDeleted.leftChild == null && NodeToBeDeleted.rightChild == null) {
				deleteCase1(NodeToBeDeleted);
			}//CASE 3: Node has both children present
			else if(NodeToBeDeleted.leftChild != null && NodeToBeDeleted.rightChild != null){
				deleteCase3(NodeToBeDeleted);

			}
			//CASE 2: Node has 1 child
			else if(NodeToBeDeleted.leftChild != null) {
				deleteCase2(NodeToBeDeleted);
			}
			else if(NodeToBeDeleted.rightChild != null) {
				deleteCase2(NodeToBeDeleted);
			}


		}


		return false;
	}

	private void deleteCase2(CZ10_TreeNode nodeToBeDeleted) {
		if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {

			if(nodeToBeDeleted.leftChild != null) {	
				nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
			}else if(nodeToBeDeleted.rightChild != null) {
				nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
			}

		}else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
			if(nodeToBeDeleted.leftChild != null) {	
				nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
			}else if(nodeToBeDeleted.rightChild != null) {
				nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
			}
		}

	}
	private CZ10_TreeNode minLeftTraversal(CZ10_TreeNode node) {
		if(node.leftChild == null) {
			return node;
		}
		return minLeftTraversal(node.leftChild);
	}

	private void deleteCase3(CZ10_TreeNode nodeToBeDeleted) {

		CZ10_TreeNode minNode = minLeftTraversal(nodeToBeDeleted.rightChild);

		deleteCase1(minNode);

		minNode.parent = nodeToBeDeleted.parent;
		minNode.leftChild = nodeToBeDeleted.leftChild;
		minNode.rightChild = nodeToBeDeleted.rightChild;

		if(nodeToBeDeleted.parent == null) {
			root = minNode;
		}else {

			if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
				nodeToBeDeleted.parent.leftChild = minNode;

			}else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {

				nodeToBeDeleted.parent.rightChild = minNode;
			}

		}

	}
	public void deleteCase1(CZ10_TreeNode NodeToBeDeleted) {
		if(NodeToBeDeleted.parent.leftChild == NodeToBeDeleted) {
			NodeToBeDeleted.parent.leftChild = null;
		}else if(NodeToBeDeleted.parent.rightChild == NodeToBeDeleted) {
			NodeToBeDeleted.parent.rightChild = null;
		}
	}

	public CZ10_TreeNode find(int val) {
		if(root != null) {
			return findNode(root, new CZ10_TreeNode(val));
		}
		return null;
	}

	public CZ10_TreeNode findNode(CZ10_TreeNode search, CZ10_TreeNode node) {
		if(search == null) {
			return null;
		}

		if(search.data == node.data) {
			return search;
		}

		else {
			CZ10_TreeNode returnNode = findNode(search.leftChild, node);

			if(returnNode == null) {
				returnNode = findNode(search.rightChild, node);
			}
			return returnNode;
		}
	}

	public void traverse() {
		//prints out the data in the tree
		if(root != null) {
			//THIS IS IN ORDER TRAVERSAL
			CZ10_TreeNode nodeToTraverse = root;
			if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null) {

				System.out.println(nodeToTraverse.data);

			}else{
				if(nodeToTraverse.leftChild != null) {
					inOrdertraverse(nodeToTraverse.leftChild);
				}if(nodeToTraverse.rightChild != null) {
					inOrdertraverse(nodeToTraverse.rightChild);
				}
			}

		}
	}

	private void inOrdertraverse(CZ10_TreeNode node) {
		//prints out the data in the tree


		if(node.leftChild != null) {
			inOrdertraverse(node.leftChild);
		}

		System.out.println(node.data);

		if(node.rightChild != null) {
			inOrdertraverse(node.rightChild);
		}
	}

}
