package offer31;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)
 * @author 大闲人柴毛毛
 * @date 2016年3月16日
 */
public class MaxSubArray {
	
	/**
	 * 分析：统计连续子数组的最大值最直观的方法就是遍历数组n次，每次以a[i]作为子数组的起点，然后将a[i]后面的数字依次纳入数组中，计算最大值。
	 * 这种方式的时间复杂度为O(n^2)，显然不符合要求。下面我们根据数组自身的特点来统计连续子数组的最大值。
	 */
	
	/**
	 * 我们尝试从左向右遍历数组，并且进行累加。
	 * 我们就会发现：如果当数组累加到a[i]后，累加的结果反而小于a[i]本身，那就说明a[0]+……+a[i-1]是一个负数。那么这个负数会拖累a[i]后面累加的结果，
	 * 即：a[0]+……+a[i-1]+a[i]+……+a[n] < a[i]+……+a[n]。
	 * 既然如此，当我们发现累加进行到a[i]时，如果累加的结果反而小于a[i]本身，就把a[i]前面的所有数全都丢掉，累加从a[i]重新开始。
	 * 与此同时，用一个全局变量记录当前子数组的最大值。
	 * 那么当扫描完一遍数组后，那个最大值就是我们要的结果。
	 * 代码如下：
	 */
	
	/**
	 * 计算子数组和的最大值
	 * @param a 数组
	 * @return 返回子数组和的最大值
	 */
	private static boolean result = true;//用于标识本函数运行过程是否正常
	public static int getMaxSubArray(int[] a){
		//数组为空
		if(a==null || a.length<=0){
			System.out.println("数组为空！");
			result = false;
			return -1;
		}
		
		int max = 0;//记录当前子数组最大值
		int sum = 0;//记录当前子数组的和
		//扫描数组
		for(int i=0;i<a.length;i++){
			//计算当前子数组的和
			sum += a[i];
			
			//若a[i]比sum大
			if(a[i]>sum){
				//丢掉a[i]之前累加结果，把a[i]作为子数组的起点
				sum = a[i];
				max = a[i];
			}
			
			//若a[i]比sum小，则判断sum是否>max，若sum>max，则更新max
			if(sum > max)
				max = sum;
		}
		
		return max;
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		int[] a = {1,-2,3,10,-4,7,2,1,-5};
		System.out.println("函数执行结果："+result);
		System.out.println("最大值＝"+getMaxSubArray(a));
	}
	
}
