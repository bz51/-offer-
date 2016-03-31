package offer37;

import java.util.Stack;

/**
 * 题目：输入两个链表，找出他们的第一个公共结点
 * @author 大闲人柴毛毛
 * @date 2016年3月25日
 */
public class FirstCommonNode {
	/**
	 * 分析：本题最直观的思路就是：顺序遍历第一个链表，每遍历第一个结点的时候，再顺序遍历第二个链表，寻找相同的结点。
	 * 假设两个链表的长度分别为n和m，那么这种方法的时间复杂度为O(n*m)。
	 * 下面我们寻找更为高效的方法。
	 */
	
	/**
	 * 根据单链表的特性，我们可以得出以下结论：
	 * 两个链表具有公共结点，也就是两个链表在公共结点处发生交汇。并且公共结点以后的所有结点均重合。
	 * 
	 * 根据上述结论，我们进一步可以推断：
	 * 如果两个链表有公共结点，那么两个链表的尾结点一定相同。我们从两条链表的尾结点开始向前遍历，直到发现两个结点不一样为止。
	 * 但由于单链表无法从后向前遍历，因此我们可以用两个栈来存放两条链表的所有结点，然后分别比较栈顶的结点是否相同。
	 * 这种方式采用“空间换时间”的思想，空间复杂度为O(m+n)，时间复杂度为O(m+n)
	 * 代码如下：
	 */
	
	/**
	 * 获取两条链表的第一个公共结点
	 * @param first1
	 * @param first2
	 * @return
	 */
	public static <T> Node<T> getFirstCommonNode_1(Node<T> first1,Node<T> first2){
		//若链表为空
		if(first1==null || first2==null){
			System.out.println("链表为空！");
			return null;
		}
		
		//创建两个栈，存储链表的结点
		Stack<Node<T>> stack1 = new Stack<Node<T>>();
		Stack<Node<T>> stack2 = new Stack<Node<T>>();
		
		//将第一条链表的结点存入stack1中
		Node<T> p = first1;
		while(p!=null){
			stack1.push(p);
			p = p.next;
		}
		//将第二条链表的结点存入stack2中
		p = first2;
		while(p!=null){
			stack2.push(p);
			p = p.next;
		}
		
		//比较栈顶结点是否相同
		Node<T> commonNode = null;//用于存储公共结点
		while(stack1.peek() == stack2.peek()){
			commonNode = stack1.peek();
			stack1.pop();
			stack2.pop();
		}
		
		return commonNode;
	}
	
	
	
	/**
	 * 上述方法时间复杂度有所提升，但需要额外的存储空间，是否有鱼和熊掌兼得的方法呢？
	 * 
	 * 上述方式使用了栈，因此需要额外的存储空间；而使用栈是因为需要从后向前遍历；之所以要从后向前遍历是因为两条单链表的长度不一样，而发生重合的部分是在链表的尾部。
	 * 因此，如果我们把两条长度不等的单链表中长的那部分头切掉，使得两条链表一样长，然后从前向后遍历，只要发现哪个结点相同，该结点就是我们要找的第一个公共结点。
	 * 代码如下：
	 */
	public static <T> Node<T> getFirstCommonNode_2(Node<T> first1,Node<T> first2){
		//链表为空
		if(first1==null || first2==null){
			System.out.println("链表为空！");
			return null;
		}
		
		//遍历单链表1，统计其长度
		int len1 = 0;
		Node<T> p = first1;
		while(p!=null){
			len1++;
			p = p.next;
		}
		
		//遍历单链表1，统计其长度
		int len2 = 0;
		p = first2;
		while(p!=null){
			len2++;
			p = p.next;
		}

		//计算长度差
		int diff = len1 - len2;
		
		//若第一条链表长，则将第一条链表头上多出来的部分截掉
		if(diff > 0)
			for(int i=0;i<diff;i++)
				first1 = first1.next;
		//若第2条链表长，则将第2条链表头上多出来的部分截掉
		else
			for(int i=0;i<diff;i++)
				first2 = first2.next;
		
		//同时从前向后扫描两个链表，寻找相同的结点
		Node<T> p1 = first1;
		Node<T> p2 = first2;
		while(p1 != p2 && p1!=null && p2!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		//创建两个链表
		Node<Integer> first1 = new Node<Integer>();
		Node<Integer> node2 = new Node<Integer>();
		Node<Integer> node3 = new Node<Integer>();
		Node<Integer> first2 = new Node<Integer>();
		Node<Integer> node4 = new Node<Integer>();
		Node<Integer> node5 = new Node<Integer>();
		
		first1.data = 111;
		node2.data = 2;
		node3.data = 3;
		node4.data = 4;
		node5.data = 5;
		first2.data = 222;
		
		//使公共结点为node3
		first1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		first2.next = node3;
		
		System.out.println(getFirstCommonNode_2(first1, first2).data);
	}
	
}



/**
 * 链表结点
 */
class Node<T>{
	public T data;
	public Node<T> next;
}