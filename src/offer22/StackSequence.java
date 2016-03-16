package offer22;

import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为栈的弹出顺序。
 * PS：设所有数字均不想等。
 * @author 大闲人柴毛毛
 * @date 2016年3月15日
 */
public class StackSequence {
	/**
	 * 栈的特点是不管入栈还是出栈，都只能对栈顶元素进行操作。
	 * 一个序列如果依次入栈，再依次出栈的话，序列将会被逆序输出。
	 * 但如果在入栈的过程中随机停止入栈操作，紧接着随机出栈n个元素，这样出栈顺序将会千变万化。
	 * 本题就是要求判断某一个数组是否属于指定入栈序列的出栈序列。
	 */
	
	/**
	 * 通过上述分析，最直观的方法就是穷举法，将一个入栈序列的所有出栈序列均罗列出来，然后判断这些序列中是否含有指定的出栈序列。
	 * 由于穷举法需要大量的时间、空间开销，因此要尽量避免。下面介绍更加高效的算法。
	 */
	
	/**
	 * 假设入栈序列为a，出栈序列为b。我们需要用一个全局变量count来记录当前匹配出栈序列的最大长度。
	 * 我们需要两个指针i和j分别指向序列a和b。
	 * 准备工作完毕，下面开始算法：
	 * 首先将a[i]入栈，
	 * 然后判断栈顶元素与b[j]是否相等，若二者相等，则该元素出栈，并count++表示已匹配到一位出栈元素，并使j++，然后重复上述操作，直到i扫描完序列a。
	 * 最后判断下匹配到的出栈元素个数是否与序列a的长度相同。
	 */
	
	/**
	 * 判断出栈序列是否符合指定入栈序列的某一种出栈顺序
	 * @param a 入栈序列
	 * @param b 出栈序列
 	 * @return 返回执行结果
	 */
	public static boolean isStackSequence(int[] a,int[] b){
		//若序列为空
		if(a==null || b==null || a.length<=0 || b.length<=0){
			System.out.println("序列为空！");
			return false;
		}
		
		//若入栈序列和出栈序列长度不等
		if(a.length != b.length){
			System.out.println("入栈序列与出栈序列长度不等！");
			return false;
		}
		
		//开始判断
		{
			//创建栈
			Stack<Integer> stack = new Stack<Integer>();
			int i=0,j=0;
			while(i<a.length){
				//若栈为空，则a[i]入栈
				stack.add(a[i++]);
				//判断栈顶元素和b[j]是否相等
				if(stack.peek()==b[j]){
					//栈顶元素出栈
					stack.pop();
					//j向后一位
					j++;
				}
			}
			
			//若栈中还有元素，则依次出栈，判断出栈序列与b剩余的序列是否相同
			while(!stack.isEmpty()){
				if(stack.pop()!=b[j])
					return false;
				else
					j++;
			}
			
			//判断栈是否为空，若为空表示成功匹配，若不为空表示失败
			if(!stack.isEmpty())
				return false; 
		}
		
		return true;
	}
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		//入栈序列
		int[] a = {1,2,3,4,5};
		//出栈序列
		int[] b = {4,3,5,1,2};
		System.out.println(isStackSequence(a,b));
	}
}
