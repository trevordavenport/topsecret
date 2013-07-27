import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// This is NOT the class solution.  This is from Trevor and Sam
// and it might have bugs.


public class BinaryTree {

	protected TreeNode myRoot;

	public BinaryTree() {
		myRoot = null;
	}
	
	// preorder  ["A", "B", "C", "D", "E", "F"]
	// inorder  ["B", "A", "E", "D", "F", "C"]
	public BinaryTree(ArrayList<Object> prelist, ArrayList<Object> inlist) {
		myRoot = BinaryTreeHelper(prelist, inlist);
	}
	
	// preorder  ["A", "B", "C", "D", "E", "F"]
	// inorder  ["B", "A", "E", "D", "F", "C"]
	public TreeNode BinaryTreeHelper(ArrayList<Object> prelist, ArrayList<Object> inlist) {
		if (prelist.size() == 0 || inlist.size() == 0) {
			return null;
		}
		if (prelist.size() == 1 || inlist.size() == 1) {
			return new TreeNode(prelist.get(0));
		}
		myRoot = new TreeNode(prelist.get(0));
		ArrayList<Object> myLeftsIn = new ArrayList<Object>();
		ArrayList<Object> myLeftsPre = new ArrayList<Object>();
		ArrayList<Object> myRightsIn = new ArrayList<Object>();
		ArrayList<Object> myRightsPre = new ArrayList<Object>();
		int rootIndex = 0;
		for (int i = 0; i < inlist.size(); i++) {
			if (inlist.get(i).equals(myRoot.myItem)) {
				rootIndex = i;
			}
		}
		System.out.println("Root index:     " + rootIndex);
		for (int i = 0; i < rootIndex; i++) {
			myLeftsIn.add(inlist.get(i));
			myLeftsPre.add(prelist.get(i));
		}
		//System.out.println("Prelist after iter 1:     " + prelist);
		if (myLeftsIn.size() == 0) {
			myRoot.myLeft = null;
		}
		else if (myLeftsIn.size() == 1) {
			myRoot.myLeft = new TreeNode(myLeftsIn.get(0));
		}
		else {
			myRoot.myLeft = BinaryTreeHelper(myLeftsPre, myLeftsIn);
		}
		//System.out.println("myRightsIn list before iter:    " + myRightsIn);
		//System.out.println("Starting at index:    " + inlist.indexOf(myRoot));
		for (int i = rootIndex + 1; i < inlist.size(); i++) {
			myRightsIn.add(inlist.get(i));
			myRightsPre.add(prelist.get(i));
			//System.out.println("At iter(" + i + "), inlist:      " + myRightsIn);
			//System.out.println("At iter(" + i + "), prelist:      " + myRightsPre);
		}
		if (myRightsIn.size() == 0) {
			myRoot.myRight = null;
		}
		else if (myRightsIn.size() == 1) {
			myRoot.myRight =  new TreeNode(myRightsIn.get(myRightsIn.size()-1));
		}
		else {
			System.out.println("Prelist before right recursive:   " + myRightsPre);
			System.out.println("Inlist before right recursive:    " + myRightsIn);
			myRoot.myRight = BinaryTreeHelper(myRightsPre, myRightsIn);
		}
		return myRoot;
	}

	public BinaryTree(TreeNode t) {
		myRoot = t;
	}

	// private TreeNode fibTreeHelper(int n) {
	// if (n == 0) {
	// return new TreeNode(0);
	// }
	// if (n == 1) {
	// return new TreeNode(1);
	// }
	// else {
	// TreeNode root = new TreeNode(1);
	// root.myLeft = new TreeNode(1);
	// root.myRight = new TreeNode(0);
	// }
	// }

	// Print the values in the tree in preorder: root value first,
	// then values in the left subtree (in preorder), then values
	// in the right subtree (in preorder).
	public void printPreorder() {
		printPreorder(myRoot);
		System.out.println();
	}

	protected static void printPreorder(TreeNode t) {
		if (t != null) {
			System.out.print(t.myItem + " ");
			printPreorder(t.myLeft);
			printPreorder(t.myRight);
		}
	}

	// Print the values in the tree in inorder: values in the left
	// subtree first (in inorder), then the root value, then values
	// in the right subtree (in inorder).
	public void printInorder() {
		printInorder(myRoot);
		System.out.println();
	}

	protected static void printInorder(TreeNode t) {
		if (t != null) {
			printInorder(t.myLeft);
			System.out.print(t.myItem + " ");
			printInorder(t.myRight);
		}
	}

	public void fillSampleTree1() {
		myRoot = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
	}

	public void fillSampleTree2() {
		myRoot = new TreeNode("a", new TreeNode("b", new TreeNode("d",
				new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
	}

	public static void main(String[] args) {
		BinaryTree t;
		t = new BinaryTree();
		print(t, "the empty tree");
		t.fillSampleTree1();
		print(t, "sample tree 1");
		t.fillSampleTree2();
		print(t, "sample tree 2");
	}

	protected static void print(BinaryTree t, String description) {
		System.out.println(description + " in preorder");
		t.printPreorder();
		System.out.println(description + " in inorder");
		t.printInorder();
		System.out.println();
	}

	protected static class TreeNode {

		public Object myItem;
		public TreeNode myLeft;
		public TreeNode myRight;

		public TreeNode(Object obj) {
			myItem = obj;
			myLeft = myRight = null;
		}

		public TreeNode(Object obj, TreeNode left, TreeNode right) {
			myItem = obj;
			myLeft = left;
			myRight = right;
		}
	}

	// This code gets put inside the BinaryTree class.

	// Method for the BinaryTree class
	public Iterator iterator() {
		return new InorderIterator();
	}

	// Inner class inside of the BinaryTree class.
	// Also, it uses java.util.Iterator and java.util.Stack.
	private class InorderIterator implements Iterator {
		private Stack<TreeNode> nodeStack;
		private TreeNode currentNode;

		public InorderIterator() {
			//Each call to constructor pushes currentnode to top of stack
			nodeStack = new Stack<TreeNode>();
			currentNode = myRoot;
			// stackHelper(currentNode);
			nodeStack.push(currentNode);
			while(currentNode.myLeft != null) {
				nodeStack.push(currentNode.myLeft);
				currentNode = currentNode.myLeft;
			}
		} // end default constructor
		
		/*public void stackHelper(TreeNode t) {
			if (t == null) {
				return ;
			}
			if (t.myRight == null) {
				nodeStack.push(currentNode);
				stackHelper(t.myLeft);
			}
			else if (t.myRight != null && nodeStack.contains(t.myRight)) {
				nodeStack.push(currentNode);
				stackHelper(t.myLeft);
			}
			else {
				stackHelper(t.myRight);
			}
		}*/
			

		public boolean hasNext() {
			return !nodeStack.isEmpty(); //|| (currentNode != null);
		} // end hasNext

		public Object next() {
			//Each call to next() will push item to be returned to the top of nodeStack
			//TreeNode nextNode = null;
			TreeNode next = nodeStack.pop();
			if (next.myRight == null) {
				return next.myItem;
			}
			else {
				currentNode = next.myRight;
				nodeStack.push(currentNode);
				while (currentNode.myLeft != null) {
					nodeStack.push(currentNode.myLeft);
					currentNode = currentNode.myLeft;
				}
			}
			return next.myItem;
		}
			
			// find leftmost node with no left child
//			while (currentNode != null) {
//				nodeStack.push(currentNode);
//				currentNode = currentNode.myLeft;
//			} // end while
//			// get leftmost node, then move to its right subtree
//			if (!nodeStack.isEmpty()) {
//				nextNode = nodeStack.pop();
//				assert nextNode != null; // since nodeStack was not empty
//										 // before the pop
//				currentNode = nextNode.myRight;
//			}
//			else {
//				throw new NoSuchElementException();
//			}
//				
//			return nextNode.myItem;
//		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end InorderIterator
}
