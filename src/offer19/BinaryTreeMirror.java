package offer19;

/**
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author 大闲人柴毛毛
 * @date 2016年3月14日
 */
public class BinaryTreeMirror {
	/**
	 * 分析：所谓“镜像”就是从镜子里看到的样子。我们可以画一棵二叉树，然后画出该二叉树的镜像。
	 * 画完图之后我们会发现，所谓“二叉树的镜像”就是把二叉树中所有子树的左孩子和右孩子进行交换。
	 * 因此需要遍历二叉树所有的结点，在遍历的同时交换非叶子结点的左右子树。
	 * 遍历我们可以使用先序遍历，首先判断当前根结点是否为叶子结点，若非叶子结点，则交换左右孩子，然后再分别对左右孩子进行相同的操作。
	 * 代码如下：
	 */
	
	/**
	 * 二叉树镜像函数
	 * @param root 输入二叉树的根结点
	 */
	public static <T> void binaryTreeMirror(BinaryTreeNode<T> root){
		//若二叉树为空
		if(root==null)
			return;
		
		//若二叉树只有一个结点
		if(root.left==null && root.right==null)
			return;
		
		//若二叉树为有孩子结点，则交换左右子树
		{
			//交换左右子树
			BinaryTreeNode<T> temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		
		//分别对左右重复上述操作
		{
			if(root.left!=null)
				binaryTreeMirror(root.left);
			if(root.right!=null)
				binaryTreeMirror(root.right);
		}
	}
	
	
	public static void main(String[] args){
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> root2 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> root3 = new BinaryTreeNode<Integer>();
		root.data = 0;
		root1.data = 1;
		root2.data = 2;
		root3.data = 3;
		root.left = root1;
		root1.left = root2;
		root2.left = root3;
		
		System.out.println("镜像前：");
		preOrder(root);
		System.out.println("镜像后：");
		binaryTreeMirror(root);
		preOrder(root);
		
	}
	
	

	/**
	 * 二叉树的中序遍历
	 * @param root 输入的二叉树的根
	 */
	public static <T> void preOrder(BinaryTreeNode<T> root){
		//若当前二叉树为空
		if(root==null)
			return;
		
		//中序遍历二叉树
		{
			preOrder(root.left);//中序遍历左子树
			System.out.print(root.data+",");//访问根结点
			preOrder(root.right);//中序遍历右子树
		}
	}
}



/**
 * 二叉树的结点
 */
class BinaryTreeNode<T>{
	T data;//结点的数据域
	BinaryTreeNode<T> left;//左子树
	BinaryTreeNode<T> right;//右子树
}