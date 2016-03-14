package offer17;


/**
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * @author 大闲人柴毛毛
 * @date 2016年3月14日
 */
public class MergeLink {
	/**
	 * 分析：我们把两个单链表分为a1、a2，每次从a2中取出头结点，然后在a1中寻找插入点插入，重复上述操作直到a2中结点被取光为止。
	 * 代码如下：
	 */
	
	/**
	 * 合并两个递增的单链表
	 * @param first1 第一个链表的头结点
	 * @param first2 第二个链表的头结点
	 * @return 返回合并后链表的头结点
	 */
	public static Node<Integer> mergeLink(Node<Integer> first1, Node<Integer> first2){
		//若a1为空，a2为空
		if(first1==null && first2==null){
			System.out.println("两个链表均为空！");
			return null;
		}
		
		//若a1为空，a2不为空，则返回a2
		if(first1==null && first2!=null)
			return first2;
		
		//若a2为空，a1不为空，则返回a1
		if(first1!=null && first2==null)
			return first1;
		
		//若a1、a2均不为空，则进行合并
		while(first2!=null){
			//p指向链表一中的当前结点
			Node<Integer> p = first1;
			
			//若first2<p，则将first2插入到p之前
			if(first2.data < p.data){
				//q指向first2
				Node<Integer> q = first2;
				//first2指向后继结点
				first2 = first2.next;
				//将a2的头结点摘下来，装到a1的头上
				q.next = p;
				first1 = q;
			}
			
			//若first2>=p时，p一直向后找，直到找到first2<p时停止，将first2插入到p的前面
			Node<Integer> p_pre = p;//p_pre指向p的前一个结点
			while(p.data<=first2.data && p!=null){
				p_pre = p;
				p = p.next;
			}
			//q指向first2
			Node<Integer> q = first2;
			//first2指向后继结点
			first2 = first2.next;
			//q的后继结点设为p
			q.next = p;
			//p_pre的后继结点设为q
			p_pre.next = q;
		}
		
		return first1;
	}
}


/**
 * 定义结点 
 */
class Node<T>{
	public T data;
	public Node<T> next;
}