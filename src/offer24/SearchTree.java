package offer24;

/**
 * 题目：输入一个整数数组，判断该数组书不是某二叉搜索数的后序遍历的结果。如果是返回true，否则返回false。假设输入的数组的任意两个数字都互不重复。
 * @author 大闲人柴毛毛
 * @date 2016年3月15日
 */
public class SearchTree {
	/**
	 * 分析：看过题目后本题最直观的思路就是通过后序遍历序列还原这棵二叉树，然后判断该二叉树是否为二叉搜索树。
	 * 然而学过数据结构就会知道，如果给一棵二叉树的中序遍历和后序遍历序列，就能唯一确定一棵二叉树。
	 * 但本题只给了后序遍历序列，因此无法唯一确定这棵树。
	 * 那么，我们能否通过后序遍历序列把所有可能的二叉树都罗列出来，然后从中寻找是否有二叉搜索树存在。
	 * 这种穷举的方法需要时间、空间的开销都很大，这显然不是种好方法。
	 * 下面，我们从二叉搜索树和后序遍历这两个条件入手，探寻二叉搜索树的后序遍历序列的特点。
	 */
	
	/**
	 * 后序遍历的特点：由于后序遍历先访问左子树，再访问右子树，最后访问根结点，因此根结点一定在序列的末尾。
	 * 二叉搜索树的特点：二叉搜索树的左子树上所有结点均小于根结点，右子树上所有结点均大于根结点。
	 * 把这两个特点结合起来我们可以得出以下结论：在二叉搜索树的后序遍历序列中，根结点一定在序列末尾，且前半段的所有结点均小于根结点，后半段的所有结点均大于根结点。
	 * 因此，可以采用递归。按照上述方法不断划分序列，直到序列长度小于等于3时不再划分，且作如下判断：
	 * 1.若当前序列长度等于3，则表示当前序列为一棵具有三个结点的二叉搜索树，因此第一个结点必小于第三个结点，第二个结点必大于第三个结点。若不满足这个条件则无法组成一棵二叉搜索树。
	 * 2.若当前序列长度等于2，则表示当前序列为一棵具有两个结点的二叉搜索树，因此第二个结点为根结点，第一个结点可能是左子树，也可能是右子树，因此这两个结点不管谁大谁小都可以组成一棵二叉搜索树。
	 */
	
	/**
	 * 判断输入的后序遍历序列能否构成一棵二叉搜索树
	 * @param a 后序遍历序列
	 * @param start 序列起始下标
	 * @param end 序列结束下标
	 * @return 返回判断的结果
	 */
	public static boolean isSearchTree(int[] a,int start,int end){
		//若数组为空
		if(a==null || a.length<=0){
			System.out.println("后序遍历序列为空！");
			return false;
		}
		
		//若下标越界
		if(start<0 || end>=a.length){
			System.out.println("start、end越界！");
			return false;
		}
		
		//若当前序列长度为3
		if(end-start==2){
			System.out.println("当前序列长度=3……");
			//第一个结点必需要小于第三个结点，第二个结点必须要大于第三个结点，否则就无法构成二叉搜索树
			if(a[start]>a[end] || a[start+1]<a[end])
				return false;
			else
				return true;
		}
		
		//若整棵树只有一个结点、当前序列长度为2直接返回true
		else if(end-start<=1){
			System.out.print("当前序列长度<3……");
			for(int x=start;x<=end;x++)
				System.out.println(a[x]+",");
			return true;
		}
		
		//若当前序列长度超过3，则继续分隔本序列
		else{
			System.out.print("当前序列长度>3……");
			for(int x=start;x<=end;x++)
				System.out.println(a[x]+",");
			//获取末尾的根结点
			int root = a[end];
			//寻找根的左子树与右子树的分界点
			int i=start;
			while(i<end && a[i]<root)
				i++;//i停止时得到的是后半段的起点
			//判断后半段结点是否都大于根结点
			for(int j=i;j<end;j++){
				if(a[j]<root)
					return false;
			}
			//若后半段的结点均大于根结点，则进行进入递归
			//判断前半段是否为二叉搜索树的后序遍历序列
			//若当前序列均大于根结点
			boolean result_tail = true;
			boolean result_pre = true;
			if(start>end)
				result_tail = isSearchTree(a,start,end-1);
			else{
				result_pre = isSearchTree(a,start,i-1);
				//判断后半段是否为二叉搜索树的后序遍历序列
				result_tail = isSearchTree(a,i,end);
			}
			if(result_pre && result_tail)
				return true;
			return false;
		}
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		int[] a = {5,7,6,9,11,10,8};
		System.out.println("5,7,6,9,11,10,8:"+isSearchTree(a,0,a.length-1));
	}
}
