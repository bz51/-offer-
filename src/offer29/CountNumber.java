package offer29;

import offer8.QuickSort;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * @author 大闲人柴毛毛
 * @date 2016年3月16日
 */
public class CountNumber {

	/**
	 * 分析：本题最直观的思路就是分别统计数组中每个数出现的次数，然后求出最大值，判断是否超过数组长度的一半。
	 * 这种方法的时间复杂度为O(n^2)，在面试中，第一反应想到的方法往往不是最佳答案，下面我们来寻求更加高效的方式。
	 */
	
	/**
	 * 一个数出现的次数如果超过数组长度的一半，那么可以得出以下结论：
	 * 1.如果把超过数组长度一半的数整理在一起形成数组b，那么不管把b放在数组的什么位置，数组的中位数一定在b中。
	 * 2.个数超过数组长度一半的数最多只有一个。
	 * 基于上述两点结论，我们可以首先将数组排序，使得超过数组长度一半的那些数靠在一起，然后取排序后数组的中位数，最后判断该数的长度是否超过数组长度的一半。
	 * 代码如下：
	 */
	
	/**
	 * 获取数组中出现次数超过一半的那个数
	 * @param a 输入的数组
	 * @return 返回出现次数超过一半的那个数(返回－1表示函数出错)
	 */
	public static int countNumber(int[] a){
		//若数组为空
		if(a==null || a.length<=0){
			System.out.println("数组为空！");
			return -1;
		}
		
		//对数组排序
		QuickSort.QuickSort(a);
		
		//获取中位数
		int mid = a[a.length/2];
		
		//计算中位数出现的次数
		int count = 0;
		for(int i=0;i<a.length && a[i]<=mid;i++){
			if(a[i]==mid)
				count++;
		}
		
		//判断中位数出现的次数是否超过数组长度的一半
		if(count>=a.length/2)
			return mid;
		else
			return -1;
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		int[] a = {3,1,3,2,3,2,3,2,2,3,5,3,4,2,3,3};
		System.out.println(countNumber(a));
	}
}
