package offer14;

/**
 * 题目：输入一个数组，要求将奇数放在数组的前半段，偶数放在数组的后半段 
 * @author 大闲人柴毛毛
 */
public class Reorder {
	/**
	 * 分析：本题只要求前半段为奇数，后半段为偶数，没有要求有序，
	 * 因此可以采用快速排序中一趟排序的思想：
	 * 使用两个指针i、j，i指向头、j指向尾，分别向后、向前扫描；
	 * 若i遇到偶数则停下，j遇到奇数则停下，交换这两个数，
	 * 然后继续重复上述操作，直到i、j相遇为止。代码如下：
	 * PS:快速排序算法请看我的博客《剑指 offer——快速排序》
	 */
	public static boolean reorder(int[] a){
		//若数组为空
		if(a==null || a.length==0){
			System.out.println("数组为空！");
			return false;
		}
		
		//若数组只有一个元素，那不做任何操作
		if(a.length==1){
			System.out.println("数组长度为1，无需排序！");
			return true;
		}
		
		//若数组长度超过2，则进行排序
		int i=0,j=a.length-1;
		while(i<j){
			//i从头向后扫描，若当前元素为奇数，则继续往后扫描，若为偶数，i停止扫描。
			while(a[i]%2==1)
				i++;
			//j从后向前扫描，若当前元素为偶数，则继续往前扫描，若为奇数，j停止扫描。
			while(a[j]%2==0)
				j--;
			//当i、j都停止时，如果i和j还没有相遇，就交换这两个数
			if(i<j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		return true;
	}
	
	
	/**
	 * 上述代码运行过后会出现死循环！
	 * 当数组全为奇数时，i无限向后寻找，因此出现死循环。
	 * 因此，在i向后、j向前的循环中应多加一个判断：若i搜索到末尾，则停止、若j搜索到开头，则停止。
	 * 修改后的代码如下：
	 */
	public static boolean reorder_modify(int[] a){
		//若数组为空
		if(a==null || a.length==0){
			System.out.println("数组为空！");
			return false;
		}
		
		//若数组只有一个元素，那不做任何操作
		if(a.length==1){
			System.out.println("数组长度为1，无需排序！");
			return true;
		}
		
		//若数组长度超过2，则进行排序
		int i=0,j=a.length-1;
		while(i<j){
			//i从头向后扫描，若当前元素为奇数，则继续往后扫描，若为偶数，i停止扫描。
			while(i<a.length-1 && a[i]%2==1)
				i++;
			//j从后向前扫描，若当前元素为偶数，则继续往前扫描，若为奇数，j停止扫描。
			while(j>0 && a[j]%2==0)
				j--;
			//当i、j都停止时，如果i和j还没有相遇，就交换这两个数
			if(i<j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7};
		reorder_modify(a);
		for(int data : a)
		System.out.print(data+",");
	}
	
}
