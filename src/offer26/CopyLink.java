package offer26;

/**
 * 题目：请复制一个复杂链表。每个结点除了有一个next指针指向下一个结点外，还有一个sibling指向链表中的任意一个结点。
 * @author 大闲人柴毛毛
 * @date 2016年3月16日
 */
public class CopyLink {
	/**
	 * 分析：复制单链表较为简单，只需遍历单链表，创建结点，同时将前后连个结点相继连起来即可。
	 * 本题的难点在于：每个结点还有一个sibling域，指向链表的任意一个结点。
	 * 本题最直观的思路有两种：
	 * 1.先复制单链表，然后再复制sibling域；
	 * 2.在复制单链表的同时确定sibling域名。
	 * 第一种方法较为简单，复制完单链表后需再次遍历原链表，
	 * 若当前结点的sibling域不为空，则从当前结点开始依次向后查找sibling域指向的位置，
	 * 我们可以用一个计数器count记录当前结点与sibling域指向的结点直接的距离，
	 * 然后在新链表中，以该结点为起点，向后走count步即为sibling域指向的结点。
	 * 这种方式由于每个结点都要依次向后查找sibling指向的结点，因此时间复杂度为O(n^2)。
	 */
	
	/**
	 * 下面介绍一种巧妙的方法：
	 * 首先复制每个结点，并将他们插入在原结点的后面，从而形成一条新的链表；
	 * 然后遍历链表，若当前结点a的sibling不为空，则将a的下一个结点b的sibling指向a.sibling的下一个结点；
	 * 最后拆分链表：将奇数位连起来，偶数位连起来即可。
	 * 代码如下：
	 */
	
	/**
	 * 复制复杂链表
	 * @param first 复杂链表的头结点
	 * @return 返回复制后的复杂链表
	 */
	static boolean result = true;//copyLink执行结果
	public static <T> Node<T> copyLink(Node<T> first){
		//若链表为空
		if(first==null){
			System.out.println("链表为空！");
			result = false;
			return null;
		}
		
		//复制每个结点，并插入原结点之后
		Node<T> p = first;
		while(p!=null){
			//创建新结点
			Node<T> node = new Node<T>();
			node.data = p.data;
			//将新结点插入p之后
			node.next = p.next;
			p.next = node;
		}
		
		//复制每个结点的sibling域
		p = first;
		while(p!=null){
			p.next.sibling = p.sibling.next;
		}
		
		//拆分链表
		p = first;
		Node<T> q = p.next;
		Node<T> first_copy = q;//被复制链表的头结点
		while(q!=null){
			p.next = q.next;
			p = q;
			q = q.next;
		}
		
		return first_copy;
	}
	
	
	/**
	 * 综上所述：上述方法只需扫描链表3次：
	 * 1.第一遍复制每个结点，并依次插入结点的后面；
	 * 2.第二遍复制每个结点的sibling域；
	 * 3.第三次拆分链表。
	 * 因此，上述方式的时间复杂度为O(n)
	 */
}



/**
 * 复杂链表的一个结点
 */
class Node<T>{
	T data;
	Node<T> next;
	Node<T> sibling;
}