package offer35;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 题目：在字符数组中找出第一个只出现一次的字符。
 * @author 大闲人柴毛毛
 * @date 2016年3月24日
 */
public class FirstChar {
	/**
	 * 分析：本题最直观的思路是从头到尾扫描数组，假设当前扫描的字符为a[i]，
	 * 若尚未统计a[i]出现的次数的话，则从a[i]开始，向后统计a[i]出现的次数。
	 * 这种方式需要扫描数组n次，且每次还需要进行n次扫描统计a[i]出现的次数，因此时间复杂度为O(n^2)。
	 * 是否有更高效的方法呢？
	 */
	
	
	/**
	 * 要想降低时间复杂度，我们就应该想到“用空间换取时间”的思想。
	 * 如果我们只对数组扫描一遍，那么需要额外的空间来存储每个字符在数组中出现的个数。
	 * 这个数据结构能支持通过字符来获取该字符出现的次数。在Java中，Map能存储任意类型的键值对，因此适合本题。
	 * 代码如下：
	 */
	
	/**
	 * 获取字符数组中第一个只出现一次的字符
	 * @param a 字符数组
	 * @return 返回第一个只出现一次的字符
	 */
	private static boolean result = true;
	public static char getFirstChar(char[] a){
		
		//若数组为空
		if(a==null || a.length<=0){
			System.out.println("字符数组为空！");
			result = false;
			return ' ';
		}
		
		//创建Map，用于存储“字符”-“该字符出现的次数”
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		
		//扫描数组，统计每个字符出现的次数
		for(int i=0;i<a.length;i++){
			//获取字符a[i]到目前为止出现的次数
			int count; 
			if(map.get(a[i])==null) 
				count = 0;
			else
				count = map.get(a[i]);
			
			//将次数＋1存入map
			map.put(a[i], ++count);
		}
		
		//遍历map，取出第一个个数为1的字符
		Set<Character> keys = map.keySet();
		for(char key : keys){
			if(map.get(key)==1)
				return key;
		}
		
		return ' ';
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		char[] a = {'a','b','a','c','c','d','e','f','b'};
		System.out.println(getFirstChar(a));
	}
}

