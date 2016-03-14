package offer13;

/**
 * 给一个单链表，头指针为first，请用O(1)时间删除其中节点p
 * @author chibozhou
 */
public class DeleteNode {

	/**
	 * 分析：
	 * 删除单链表中的某一节点常规做法是：
	 * 从头开始扫描单链表，找到p节点的前一个节点q，然后做以下操作：
	 * 	q.next = p.next;
	 * 	p = null;
	 * 
	 * 这种方法扫描了单链表，因此时间复杂度是O(n)。
	 * 下面我们寻找时间复杂度O(1)的方法。
	 */
	
	/**
	 * 方法一之所以耗时，是因为它在寻找p的前一个结点采用了遍历，
	 * 因此，只要提升寻找前一个结点的效率，就能提升整个算法的效率。
	 * 那么，是否有办法能够在O(1)时间内找到前一个结点呢？
	 */
	
	/**
	 * 厉害的方法如下：
	 * 将p后继结点的数据复制到p中，再删除p的后继结点即可！代码如下：
	 */
	public static <T> boolean deleteNode(Node<T> first, Node<T> p){
		//若链表为空
		if(first==null){
			System.out.println("链表为空！");
			return false;
		}
		
		//若p是最后一个结点，则只能遍历寻找p的前一个结点
		//解析：上述复制后继结点删除p的方法，在删除过程中，需要用到p.next=p.next.next;
		//若p已经是最后一个结点，则上述语句就会出现空指针异常，因此p为最后一个结点的情况要单独判断.
		if(p.next == null){
			Node<T> q = p;
			while(p.next != null){
				q = p;
				p = p.next;
			}
			q.next = p.next;
			p = null;
		}
		
		//若p不是最后一个结点，则将p后继结点的数据复制到p中，再删除p的后继结点
		//解析：单链表是一种用于存储数据的物理结构，从逻辑上看和数组一样。
		//要删除一个结点，从逻辑上看就是删除一个序列的某一个数据。因此，从逻辑上看，
		//只要两个结点的数值相同，就认为这两个结点是相等的。
		//因此，采用这种复制后继结点的方式删除结点，虽然删除后结点的存储位置发生了变化，
		//但从逻辑角度看，只是删除了序列中的一个数。
		if(p.next != null){
			p.data = p.next.data;
			p.next = p.next.next;
		}
		
		return true;
	}
	
}

/**
 * 定义结点 
 */
class Node<T>{
	public T data;
	public Node<T> next;
}
