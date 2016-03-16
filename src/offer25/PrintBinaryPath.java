package offer25;

import java.util.Iterator;
import java.util.Stack;

/**
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * PS：从根结点开始，一直到叶子结点形式一条路径。
 * @author 大闲人柴毛毛
 * @date 2016年3月15日
 */
public class PrintBinaryPath {
	/**
	 * 分析：要找出路径之和为指定整数的路径，就需要遍历二叉树的所有路径。
	 * 此外，由于路径是指根结点到叶子结点的线段，因此我们想到采用深度优先的方式遍历二叉树。
	 * 深度优先算法又分为：先序遍历、中序遍历、后序遍历，其中先序遍历符合我们的要求。
	 */
	
	/**
	 * 首先需要创建一个栈，用来保存当前路径的结点。
	 * 采用先序遍历算法遍历结点时，先将途中经过的结点均存入栈中，然后判断当前结点是否为叶子结点，若不是叶子结点的话，则递归遍历该结点的左孩子和右孩子；
	 * 若是叶子结点的话，计算下当前栈中所有结点之和是否为指定的整数，若是的话打印栈中所有元素。
	 * 然后这个函数在返回之前，将当前叶子结点从栈中删除。
	 */
	
	/**
	 * 打印二叉树中路径之和为n的路径
	 * @param root 二叉树
	 * @param n 路径之和
	 * @return 返回函数能否正确执行
	 */
	public static boolean printBinaryPath(BinaryTreeNode<Integer> root,int n){
		//树为空
		if(root==null){
			System.out.println("树为空！");
			return false;
		}
		
		//n小于0
		if(n<=0){
			System.out.println("n小于等于0！");
			return false;
		}
		
		//创建栈
		Stack<Integer> stack = new Stack<Integer>();
		//开始递归查找路径
		printBinaryPath(root,n,stack);
		
		return true;
	}

	
	
	/**
	 * 递归寻找路径之和为n的路径
	 * @param root 二叉树根结点
	 * @param n 指定整数
	 * @param stack 用于保存当前路径的栈
	 */
	private static void printBinaryPath(BinaryTreeNode<Integer> root, int n, Stack<Integer> stack) {
		//若当前根结点为叶子结点
		if(root.left==null && root.right==null){
			//将叶子结点入栈
			stack.add(root.data);
			
			//计算当前路径之和
			int sum = 0;
			Iterator<Integer> it = stack.iterator();
			while(it.hasNext())
				sum += it.next();
			
			//若当前路径之和＝＝n，则打印这条路径
			if(sum==n){
				Iterator<Integer> it2 = stack.iterator();
				while(it2.hasNext())
					System.out.print(it2.next()+",");
				System.out.println("\n-------------------");
			}
			
			//将当前叶子结点出栈
			stack.pop();
			
			//返回上层结点
			return;
		}
		
		//若当前结点为非叶子结点
		else{
			//将根结点入栈
			stack.add(root.data);
			
			//若左孩子存在，递归左孩子
			if(root.left!=null)
				printBinaryPath(root.left,n,stack);
			
			//若右孩子存在，递归右孩子
			if(root.right!=null)
				printBinaryPath(root.right,n,stack);
			
			//将当前叶子结点出栈
			stack.pop();
			
			//返回上层结点
			return;
		}
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		//构建二叉树
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>();
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>();
		
		node1.data = 10;
		node2.data = 5;
		node3.data = 12;
		node4.data = 4;
		node5.data = 7;
		
		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;
		
		printBinaryPath(node1,19);
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