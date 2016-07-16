package TestJava;

import java.util.HashMap;
import java.util.Map;

/**
 * SimpleBinaryTree Implementation 04-21-2003
 * 
 * @author mramos
 *
 */
public class SimpleBinaryTree {

	public static class BNode {
		BNode left;
		BNode right;
		int value;

		public BNode(int value) {
			this.value = value;
		}
	}

	public static void main(String args[]) {
		new SimpleBinaryTree().go();
	}

	public void go() {
		BNode root = new BNode(6);
		insert(root, 9);
		insert(root, 5);
		insert(root, 3);
		insert(root, 2);
		insert(root, 12);
		insert(root, 8);
		System.out.println("Printing inOrder");
		printInOrder(root);
		System.out.println("Printing postOrder");
		printPostOrder(root);
		System.out.println("Printing preOrder");
		printPreOrder(root);
		System.out.println("Printing left height");
		Map height = new HashMap();
		findTheHeight(root, height, true);
		System.out.println("Height from left side =" + height.get("L"));
		findTheHeight(root, height, false);
		System.out.println("Height from right side =" + height.get("R"));
	}

	public SimpleBinaryTree() {
	}

	public void insert(BNode node, int value) {
		if (node.value < value) {
			if (node.right == null) {
				node.right = new BNode(value);
			} else
				insert(node.right, value);
		} else if (node.value > value) {
			if (node.left == null)
				node.left = new BNode(value);
			else
				insert(node.left, value);
		}
	}

	public void findTheHeight(BNode no, Map theHeight, boolean isLeft) {
		try {
			if (isLeft) {
				if (no != null) {
					if (no.left == null) {
						Integer o = (Integer) theHeight.get("L");
						if (o == null) {
							o = new Integer(0);
							theHeight.put("L", o);
						} else
							o++;
					} else
						findTheHeight(no.left, theHeight, isLeft);
					Integer o = (Integer) theHeight.get("L");
					theHeight.put("L", ++o);
				}
			} else {
				if (no != null) {
					if (no.right == null) {
						Integer o = (Integer) theHeight.get("R");
						if (o == null) {
							o = new Integer(0);
							theHeight.put("R", o);
						} else
							o++;
					} else
						findTheHeight(no.right, theHeight, isLeft);
					Integer o = (Integer) theHeight.get("R");
					theHeight.put("R", ++o);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void printInOrder(BNode no) {
		if (no != null) {
			printInOrder(no.left);
			System.out.println("Printing ... " + no.value);
			printInOrder(no.right);
		}
	}

	public void printPreOrder(BNode no) {
		if (no != null) {
			System.out.println("Printing ..." + no.value);
			printPreOrder(no.left);
			printPreOrder(no.right);
		}
	}

	public void printPostOrder(BNode no) {
		if (no != null) {
			printPostOrder(no.left);
			printPostOrder(no.right);
			System.out.println("Printing ..." + no.value);
		}
	}
}
