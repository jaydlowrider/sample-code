package TestJava;


/**
 * I was asked this problem circa 2012
 * 
 * @author mramos
 *
 */

public class CommonParentProblem {
	
	public static void main(String[] args)
	{
		//Let's create a binary tree
		//  1
		// 2  3
		//4 5 6 7
		Tree myTree = new Tree(1);
		myTree.left = new Tree(2);
		myTree.right = new Tree(3);
		myTree.left.left = new Tree(4);
		myTree.left.right = new Tree(5);
		myTree.right.left = new Tree(6);
		myTree.right.right = new Tree(7);
		myTree.right.left.left = new Tree(8);
		myTree.right.left.right = new Tree(9);
		
		System.out.println(" Contains? " + myTree.contains(myTree.right));
		
		System.out.println(" Common parent? " + findCommonParent(myTree, myTree.right.right, myTree.right.left.right).value);
		
	}
	
	public static Tree findCommonParent(Tree root, Tree source1, Tree source2){
		
		if (source1 == null && source2 == null)
			return null;
		
		if (root.contains(source1) && root.contains(source2)){
			
			Tree parent = null;
			if (root.left !=null){
				parent = findCommonParent(root.left, source1, source2);
				
				if (parent != null) return parent;
			}
			
			if (root.right != null){
				parent = findCommonParent(root.right, source1, source2);
				
				if (parent != null) return parent;
			}
		}
		else
			return null;
		
		return root;
	}
	
	static class Tree {
		public int value;
		public Tree left;
		public Tree right;
		public Tree(int a)
		{
			value = a;
			left=right=null;
		}
		
		public boolean contains(Tree t){
			
			if (t == null)
				return false;
			
			if ( value == t.value || t == this ){
				//this is the same node.
				return true;
			}
			
			boolean ret = false;
			if (this.left != null){ 
				ret = this.left.contains(t);
				
				if (ret) return ret;
			}
			
			if (this.right != null){
				ret = this.right.contains(t);
				
				if (ret) return ret;
			}
			
			return ret;
		}
		
		
		
	}

}
