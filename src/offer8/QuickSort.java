package offer8;

/**
 * 实现快速排序 
 * @author chibozhou
 */
public class QuickSort {
	
	/**
	 * 本函数实现一趟快速排序，以数组的第一个元素为主元，
	 * 本函数运行结束后使得主元左侧的元素小于主元，主元右侧的元素大于主元。
	 * @param arr 待排序的数组
	 * @return 返回经一趟排序后主元的下标
	 */
	private static int partition(int[] arr,int start,int end){
		//健壮性判断
		if(arr.length<=0){
			System.out.println("数组为空！");
			return -1;
		}
		if(start<0 || end<0 || start>end){
			System.out.println("start、end非法！");
			return -1;
		}
		
		//i指向数组头、j指向数组尾
		int i=start+1,j=end;
		//选择数组第一位为主元
		int key = arr[start];
		//若i与j未相遇，则执行以下循环
		while(i<j){
			//i从左向右扫描，直到当前元素大于主元时停下
			while(arr[i]<=key && i<end){
				i++;
			}
			//j从右向左扫描，直到当前元素小于主元时停下
			while(arr[j]>=key && j>start){
				j--;
			}
			//i、j停下有两种情况：1.
			if(i<j)
				swap(arr,i,j);
		}
		//将主元与j交换
		swap(arr,start,j);
		System.out.println("某一趟排序结果:"+printArray(arr));
		//返回新的主元下标
		return j;
	}
	
	
	
	/**
	 * 快速排序入口函数
	 * @param arr 待排序数组
	 * @return 返回有序的数组
	 */
	public static void QuickSort(int[] arr){
		//健壮性判断
		if(arr==null || arr.length<=0){
			System.out.println("数组为空！");
			return;
		}
		
		//通过递归进行快速排序
		QuickSort(arr,0,arr.length-1);
	}
	
	
	
	/**
	 * 快速排序的递归函数
	 * @param arr 待排序数组
	 * @param start 数组的起始下标
	 * @param end 数组的结束下标
	 * @return 返回当前有序子序列
	 */
	private static void QuickSort(int[] arr,int start,int end){
		if(start<end){
			//获取主元
			int key = partition(arr,start,end);
			//对主元左侧的序列进行快速排序
			QuickSort(arr,start,key-1);
			//对主元右侧的序列进行快速排序
			QuickSort(arr,key+1,end);
		}
	}
	
	
	/**
	 * 实现i与j位置的元素交换
	 * @param arr 数组
	 * @param i 下标
	 * @param j 下标
	 */
	private static void swap(int[] arr,int i,int j){
		//健壮性判断
		if(arr==null || arr.length<=0){
			System.out.println("数组为空！");
			return;
		}
		
		//定义临时变量temp实现交换
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	/**
	 * 输出数组元素
	 * @param arr
	 * @return
	 */
	public static String printArray(int[] arr){
		if(arr==null){
			System.out.println("数组为空！");
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		
		return sb.toString();
	}
	
	
	
	/**
	 * 测试 
	 */
	public static void main(String[] args){
//		int[] arr = new int[]{1,2,3,4,5,6};
//		System.out.println("交换前："+printArray(arr));
//		swap(arr,0,5);
//		System.out.println("交换后："+printArray(arr));
		
		int[] arr = new int[]{4,3,1,5,3,6,8,0,1};
		System.out.println("排序前："+printArray(arr));
		QuickSort(arr);
		System.out.println("排序后："+printArray(arr));
	}

}
