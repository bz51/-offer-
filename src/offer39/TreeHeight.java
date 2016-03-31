package offer39;

/**
 * 题目：输入一颗二叉树的根结点，求该树的深度。从根结点到叶结点一次经过的结点形成树的一条路径，最长路径的长度为树的深度。
 * @author 大闲人柴毛毛
 * @date 2016年3月31日
 */
public class TreeHeight {
	/**
	 * 分析：本题是一道典型的“分治法”。要求一棵二叉树的高度，我们可以将问题分解，先分别求左右子树的高度，然后取较大值加一即为整棵二叉树的高度。
	 * 接下来按照这种思路继续求左右子树的高度，直到子树为叶子结点时，此时树(即叶子结点)的高度为1。
	 */
	
	/**
	 * 计算二叉树的深度
	 * @param root 二叉树的根结点
	 * @return 返回深度(返回－1表示程序出错)
	 */
	public static <T> int getTreeHeight(Node<T> root){
		//健壮性判断：若树为空
		if(root==null){
			System.out.println("树为空！");
			return -1;
		}
		
		//若当前结点为叶子结点
		if(root.left==null && root.right==null)
			//返回树的高度
			return 1;
		
		// 如果当前结点只有左子树
		else if (root.right == null) 
			// 计算右子树的高度＋1
			return getTreeHeight(root.right) + 1;
		
		// 若当前结点只有右子树
		else if (root.left == null) 
			return getTreeHeight(root.left) + 1;
		
		// 若当前结点有左右子树
		else {
			// 从左右子树中挑选出较高的那一棵，再把高度＋1
			int left_height = getTreeHeight(root.left);
			int right_height = getTreeHeight(root.right);
			return (left_height > right_height ? left_height : right_height) + 1;
		}
		
	}
	
}

/**
 * 二叉树的结点 
 */
class Node<T>{
	Node<T> left;
	Node<T> right;
	T data;
}