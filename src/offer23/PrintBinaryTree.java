package offer23;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 题目：从上到下打印二叉树的结点，同一层的结点按照从左到右的顺序打印。
 * @author 大闲人柴毛毛
 * @date 2016年3月15日
 */
public class PrintBinaryTree {
	/**
	 * 分析：学过数据结构便可知，本题实则为宽度优先遍历二叉树。
	 * 在数据结构中，深度优先遍历一棵二叉树有三种方式：先序遍历、中序遍历、后序遍历。他们均可采用递归，代码非常简洁。
	 * 而宽度优先遍历二叉树可采用迭代，并借助一个辅助的队列来存储尚未遍历的结点，下面是详细过程。
	 */
	
	/**
	 * 首先需要创建一个队列，用于存储尚未打印的结点。
	 * 首先让根结点入队，然后重复一下操作，直到对为空为止：
	 * 从队首取出一个结点，并打印该结点，若该结点有孩子，则按照先左后右的顺序将左右孩子入队。
	 * 重复上述操作，当队为空时，遍历结束。
	 */
	
	public static boolean printBinaryTree(BinaryTreeNode<Integer> root){
		//若树为空
		if(root==null){
			System.out.println("树为空！");
			return false;
		}
		
		//创建队列
		Queue<BinaryTreeNode<Integer>> queue = new LinkedBlockingQueue<BinaryTreeNode<Integer>>();
		//将根结点入队
		queue.add(root);
		//当队不为空时
		while(!queue.isEmpty()){
			//取出队首结点
			BinaryTreeNode<Integer> first_node = queue.poll();
			System.out.println(first_node.data);
			//若该结点有孩子，则按照先左后右的顺序将孩子入队
			if(first_node.left!=null)
				queue.add(first_node.left);
			if(first_node.right!=null)
				queue.add(first_node.right);
		}
		return true;
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		//构建二叉树
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>();
		
		root.data = 1;
		node1.data = 2;
		node2.data = 3;
		node3.data = 4;
		node4.data = 5;
		node5.data = 6;
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;

		node2.right = node5;
		
		printBinaryTree(root);
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