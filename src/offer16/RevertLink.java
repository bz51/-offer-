package offer16;

/**
 * 题目：将单链表反转，并输出反转后链表的头结点
 * @author 大闲人柴毛毛
 */
public class RevertLink {
	/**
	 * 分析：本题是要将链表“反转”，而不是反向输出，这点要特别注意。
	 * 反转需要改变链表的结构，使所有指针都指向相反方向；
	 * 而反向输出不需要改变链表结构，只需反向输出即可。
	 * 对于反向问题可使用栈来实现，可参见我的博客《剑指offer——面试题5》，这里不再赘述。
	 * 下面来解决反转问题。 
	 */
	
	/**
	 * 反转单链表其实就是将链表中的指针指向相反方向，
	 * 若a1和a2是单链表中两个相邻的结点，未反转前的状态是：a1.next = a2,
	 * 现在进行反转：a2.next = a1.
	 * 此时，虽然a2指向了a1，但链表出现了“断裂”，a2和它的后继结点发生了断裂，无法继续进行反转操作。
	 * 因此，我们需要再增加一个指针a3，指向a2的后继结点。
	 * 当反转完a2结点后，从a3开始继续依次向后进行反转操作，直到整个链表反转完为止。
	 * 代码如下：
	 */
	
	/**
	 * 反转链表
	 * @param first 链表的头结点
	 * @return 返回反转后链表的头结点
	 */
	public static <T> Node<T> revertLink(Node<T> first){
		//当链表为空时
		if(first==null){
			System.out.println("链表为空！");
			return null;
		}
		
		//当链表只有一个结点时
		if(first.next==null){
			return first;
		}
		
		//当链表只有两个结点时
		if(first.next.next==null){
			//end为链表的尾结点，是反转后的头结点
			Node<T> end = first.next;
			//将第二个结点的next域指向第一个结点
			first.next.next = first;
			//将第一个结点的next域设置null
			first.next = null;
			return end;
		}
		
		//当链表有三个及以上结点时
		{
			Node<T> a1 = first;//a1指向头结点
			Node<T> a2 = first.next;//a2指向第二个结点
			Node<T> a3 = first.next.next;//a3指向第三个结点
		
			//将头结点的后继设为null
			first.next = null;
			
			//不停的将a1->a2反转为a2->a1，直到a3为空
			while(a3!=null){
				//a2的后继设为a1
				a2.next = a1;
				//a1、a2、a3依次向后移一位
				a1 = a2;
				a2 = a3;
				a3 = a3.next;
			}
			
			//将最后一个结点反向
			a2.next = a1;
			return a2;
		}
		//PS：这里使用局部代码块一方面增强了代码的可读性，另一方面使得局部代码块中的变量能够在代码块结束之后立即释放，从而节约了内存空间。
	}
}


/**
 * 定义结点 
 */
class Node<T>{
	public T data;
	public Node<T> next;
}
