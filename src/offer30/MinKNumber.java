package offer30;

/**
 * 题目：输入n个数，找出其中最小的k个数。
 * @author 大闲人柴毛毛
 * @date 2016年3月16日
 */
public class MinKNumber {

	/**
	 * 分析：这个问题最直观的思路就是想将数组排序，然后只要输出前n个数即可。
	 * 这种方法的时间复杂度就取决于选择何种排序算法了。一般选择快速排序具有较好的性能。
	 * 这种方式只要能写出快速排序算法就可以了，这里就不再赘述，快速排序算法请参见我的博客http://blog.csdn.net/u010425776/article/details/50813551
	 * 快速排序在最好和平均情况下时间复杂度都是o(nlogn)，是否能找到更加高效的方法？
	 * 此外，快速排序需要将待排序的所有数都加载进内存，那么如果要处理海量数据时，把他们都加载进内存显然不是一种好办法。
	 * 下面我们来探寻更高效、更适合处理海量数据的方法。
	 */
	
	/**
	 * 要降低算法的时间开销，我们很自然地就想到了用空间换时间的思想。
	 * 首先我们需要扫描数组a，并选择一种数据结构b用于存储到目前为止数组中最小的k个数，且这k个数递增排序。
	 * 在扫描的过程中，如果当前元素a[i]比b末尾那个最大的数还要大，则说明a[i]一定不是最小的k个数，直接丢弃即可；
	 * 如果a[i]比b末尾的数小，则从b的末尾向前寻找插入点，保证插入后b仍然保持递增排序。
	 * 当数组经过一次扫描后，数据结构b中的k个数就是最小的k个数。
	 * 
	 * 由于数据结构b需要插入结点，并能够从后向前扫描，因此我们选择双向链表比较合适。
	 * PS：双向链表支持从前向后扫描，也支持从后向前扫描，并且插入结点的效率较高，因此选择双向链表。
	 * 代码如下：
	 */
	
	/**
	 * 获取数组a中最小的k个整数
	 * @param a 输入的数组
	 * @param k 需要打印的最小数的个数
	 * @return 返回算法执行结果
	 */
	public static boolean getMinKNumber(int[] a,int k){
		//若数组为空
		if(a==null || a.length<=0){
			System.out.println("数组为空！");
			return false;
		}
		
		//若k>数组长度
		if(k>a.length){
			System.out.println("k大于数组长度！");
			return false;
		}
		
		//开始获取最小的k个数
		//创建一个双向链表
		TwoWayNode<Integer> first = new TwoWayNode<Integer>();
		{
			first.data = a[0];
			//保存双向链表当前的结点数
			int link_node = 1;
			//创建指向链表末尾的指针
			TwoWayNode<Integer> last = first;
			//扫描数组a
			for(int i=1;i<a.length;i++){
				//若a[i]<=链表末尾的值
				if(a[i]<=last.data){
					System.out.println("a["+i+"]="+a[i]+"<=last.data");
					//从后向前寻找插入点
					TwoWayNode<Integer> p = last.pre;
					while(p!=null && p.data>a[i])
						p = p.pre;
					
					//创建结点
					TwoWayNode<Integer> node = new TwoWayNode<Integer>();
					node.data = a[i];
					
					//将该结点插入到结点p的后面
					node.next = p.next;
					node.next.pre = node;
					p.next = node;
					node.pre = p;
					
					//链表结点数＋1
					link_node++;
					
					//若此时链表中的结点个数大于4
					if(link_node==4){
						//删除最后的那个结点
						last.pre.next = null;
						last.pre = null;
						//链表结点数-1
						link_node--;
					}
				}
			}
			
			//输出最小的k个数
			TwoWayNode<Integer> node = first;
			while(node!=null){
				System.out.print(node.data+",");
			}
		}
		return true;
	}
	
	
	
	/**
	 * 获取数组a中最小的k个整数
	 * @param a 输入的数组
	 * @param k 需要打印的最小数的个数
	 * @return 返回算法执行结果
	 */
	public static boolean getMinKNumber2(int[] a,int k){
		//若数组为空
		if(a==null || a.length<=0){
			System.out.println("数组为空！");
			return false;
		}
		
		//若k>数组长度
		if(k>a.length){
			System.out.println("k大于数组长度！");
			return false;
		}
		
		//创建双向链表
		TwoWayNode<Integer> first = new TwoWayNode<Integer>();
		first.next = first.pre = null;
		first.data = a[0];
		//用于记录当前双向链表的长度
		int node_count = 1;
		//创建指针，指向双向链表尾结点（尾结点也是链表中的最大值）
		TwoWayNode<Integer> last = first;
		
		//开始扫描数组(从第二个结点开始)
		for(int i=1;i<a.length;i++){
			//若双向链表的结点数小于k，则直接将a[i]插入
			if(node_count<k){
				//将a[i]插入到双向链表中
				insertNodeByOrder(a[i],first,last);
				//双向链表的结点数＋1
				node_count++;
//				break;
			}
			//若结点数已满，且a[i]<=双向链表尾结点的值，才将a[i]插入
			else if(node_count>=k && a[i]<=last.data){
				//将a[i]插入到双向链表中
				insertNodeByOrder(a[i],first,last);
				//双向链表的结点数＋1
				node_count++;
				//如果插入后结点数超过k
				if(node_count>k){
					//删掉尾结点
					last.pre.next = null;
					last.pre = null;
					//双向链表结点数－1
					node_count--;
				}
			}
		}
		
		//输出最小的k个数
		TwoWayNode<Integer> p = first;
		while(p!=null){
			System.out.print(p.data+",");
			p = p.next;
		}
		System.out.println("-----------------------");
		return true;
	}
	
	
	
	/**
	 * 向双向链表中按照递增顺序插入一个结点
	 * @param a 带插入的结点的数值
	 * @param first 双向链表的头结点
	 * @param last 双向链表的尾结点
	 */
	private static void insertNodeByOrder(int a, TwoWayNode<Integer> first, TwoWayNode<Integer> last) {
		//创建一个新的结点
		TwoWayNode<Integer> node = new TwoWayNode<Integer>();
		node.data = a;
		
		//若尾结点为空，表示链表为空，直接返回新结点即可
		if(last==null){
			last = node;
			return;
		}
		
		//若尾结点不为空，则向前寻找插入点
		TwoWayNode<Integer> p = last;
		System.out.println("p!=null && p.data>a="+p!=null && p.data>a);
		while(p!=null && p.data>a){
			p = p.pre;
		}
		System.out.println("p.next="+p.next);
		
		//若p为空(插入点在链表的头)
		if(p==null){
			System.out.println(a+"插入在"+first.data+"前");
			first.pre = node;
			node.next = first;
			first = node;
		}
		
		//若p.next为空(插入在链表的尾)
		else if(p.next==null){
//			p.next = node;
//			node.pre = p;
//			last = node;
			node.pre = last;
			last.next = node;
			last = node;
			System.out.println("插入在最后面");
		}
		
		//将新结点插在p的后面
		else{
			node.next = p.next;
			p.next.pre = node;
			node.pre = p;
			p.next = node;
			System.out.println("插入在中间");
		}
		
		
		TwoWayNode<Integer> t = first;
		while(t!=null){
			System.out.print(t.data);
			t = t.next;
		}
		System.out.println("------");

	}



	/**
	 * 测试
	 */
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7};
		getMinKNumber2(a,4);
	}
}



/**
 * 双向链表的结点
 */
class TwoWayNode<T>{
	//数据域
	T data;
	//前一个结点
	TwoWayNode<T> next;
	//后一个结点
	TwoWayNode<T> pre;
}