package offer15;

/**
 * 题目：输入一个单链表，输出该链表从后往前的第k个数。
 * PS：从后往前数时从1开始计数。
 * @author 柴毛毛大闲人
 */
public class TailK {
	
	/**
	 * 分析：要寻找倒数第k个数，很自然想到的方法是：从末尾向前找第k个数。
	 * 然而这种方法面临两个问题：1.我们无法直到单链表的末尾在哪儿，2.我们无法从后向前遍历单链表。
	 * 为了解决上述两个问题，我们首先想到的方法是：遍历两次单链表，第一次求得单链表的长度n，第二次遍历到第n-k个元素停止即可。
	 * 代码如下：
	 */

	//使用全局变量result表示函数运行结果
	static boolean result = true;
	/**
	 * @param first 单链表的首结点
	 * @param k 要找的倒数第几个元素
	 * @return 返回倒数第K个值
	 */
	public static int getTailK(Node<Integer> first,int k){
		//若链表为空
		if(first==null){
			System.out.println("链表为空！");
			result = false;
			return 0;
		}
		
		//若k<＝0
		if(k<1){
			System.out.println("k不能小于1！");
			result = false;
			return 0;
		}
		
		//计算链表长度
		int length = 1;
		Node<Integer> p = first;
		while(p.next!=null){
			length++;
			p = p.next;
		}
		
		//若k比链表还长
		if(length<k){
			System.out.println("k="+k+"超过了链表长度！");
			result = false;
			return 0;
		}
		
		//遍历链表，遍历到第n-k个元素结束
		Node<Integer> q = first;
		for(int i=0;i<length-k;i++)
			q = q.next;
		
		return q.data;
	}
	
	/**
	 * 上述方法能解决问题，但需要遍历链表两次，能否有更高效的办法？
	 * 可以使用两个指针i和j，指针i从头开始先走k步，然后j指向第一个结点，接下来保持i和j之间的距离，当j走到尾时，i指向的结点就是倒数第k个结点。
	 * 代码如下：
	 */
	public static int getTailK_modify(Node<Integer> first,int k){
		//若链表为空
		if(first==null){
			System.out.println("链表为空！");
			result = false;
			return 0;
		}
		
		//若k<＝0
		if(k<1){
			System.out.println("k不能小于1！");
			result = false;
			return 0;
		}
		
		//定义两个指针p和q，p指向头结点，q指向第k个结点
		Node<Integer> p = first;
		Node<Integer> q = first;
		//将q指向第k个结点
		for(int i=0;i<k-1;i++){
			//若q还没指向第k个结点，但q已经是最后一个结点，则说明k超过了链表长度
			if(q.next==null){
				System.out.println("k="+k+"超过了链表长度！");
				result = false;
				return 0;
			}
			q = q.next;
		}
		
		//p和q分别向后移动，直到q走到链表末尾为止
		while(q.next!=null){
			p = p.next;
			q = q.next;
		}
		
		return p.data;
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		Node<Integer> node1 = new Node<Integer>();
		Node<Integer> node2 = new Node<Integer>();
		Node<Integer> node3 = new Node<Integer>();
		Node<Integer> node4 = new Node<Integer>();
		node1.data = 1;
		node2.data = 2;
		node3.data = 3;
		node4.data = 4;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(getTailK_modify(node1,11));
	}
}

/**
 * 定义结点 
 */
class Node<T>{
	public T data;
	public Node<T> next;
}