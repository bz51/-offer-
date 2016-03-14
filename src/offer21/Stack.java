package offer21;

/**
 * 题目：实现一个栈，要求使用O(1)时间获取栈中最小值，O(1)执行pop、push操作
 * @author 大闲人柴毛毛
 * @date 2016年3月14日
 */
public class Stack {
	/**
	 * 分析：要获取栈的最小值，我们首先想到的思路就是使用一个全局变量记录最小值，当元素进栈时和该全局变量进行比较，若小于全局变量，则更新最小值。
	 * 这种方法有个致命的缺陷，如果这个最小值出栈了，那么当前栈的最小值是什么？
	 * 解决办法：我们可以再开辟一个栈b，栈b的高度始终与栈a保持一致，栈顶元素保存当前栈a的最小值。
	 * 当元素入栈a后，将该元素与栈b的栈顶元素比较大小，若小于栈b的栈顶元素，则将该元素入栈b，否则，将栈b原本的栈顶元素再次入栈b。
	 * 当栈a的栈顶元素出栈时，只需将栈b的栈顶元素也出栈即可。
	 * 这样，栈b的栈顶元素始终是栈a的最小值。
	 */
	
	private int[] stack_a;//栈a底层使用数组存储
	private int[] stack_b;//用于存储最小值的栈
	private int top_a = -1;//栈a的实际深度
	private int top_b = -1;//栈b的实际深度
	private int max;//栈的最大深度
	
	/**
	 * 构造函数
	 * @param max 栈允许的最大深度
	 */
	public Stack(int max){
		this.max = max;
		//初始化栈的底层数组
		stack_a = new int[max];
		//初始化用于存储最小值的数组
		stack_b = new int[max];
	}
	
	
	
	/**
	 * 入栈
	 * @param t 入栈的元素
	 * @return 返回入栈操作的结果
	 */
	public boolean push(int t){
		//若栈已满
		if(top_a==max-1){
			System.out.println("栈已满！");
			return false;
		}
		
		//入栈
		{
			//元素首先入栈a
			stack_a[++top_a] = t;
			//当前入栈元素与栈b的栈顶元素比较，若小与栈b的栈顶元素，则入栈b，否则将栈b的栈顶元素再次入栈
			if(top_b==-1 || t<stack_b[top_b])//PS:top_b==-1表示：如果栈b为空，则直接将当前值当作最小值入栈
				stack_b[++top_b]=t;
			else{
				stack_b[top_b+1]=stack_b[top_b];
				top_b++;
			}
		}
		return true;
	}
	
	
	
	/**
	 * 出栈
	 * @return 返回栈顶元素
	 */
	public int pop(){
		//若栈为空
		if(top_a==-1){
			System.out.println("栈为空！");
			return -1;
		}
		
		//栈不为空时可以出栈
		{
			//栈b的栈顶元素出栈
			top_b--;
			//栈a的栈顶元素出栈
			return stack_a[top_a--];
		}
	}
	
	
	
	/**
	 * 获取栈中的最小值
	 * @return 返回栈中最小值
	 */
	public int min(){
		//若栈为空
		if(top_a==-1){
			System.out.println("栈为空！");
			return -1;
		}
		
		//返回最小值
		return stack_b[top_b];
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		//创建最大容量为10的栈
		Stack stack = new Stack(10);
		
		//栈为空时出栈
		System.out.println("栈为空时出栈:");
		stack.pop();
		
		//入栈
		System.out.println("\n1,2,3,4,5依次入栈:");
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		//最小值
		System.out.println("\n最小值:"+stack.min());
		
		//出栈
		System.out.println("\n出栈:"+stack.pop());

		//最小值
		System.out.println("\n最小值:"+stack.min());
		
	}
}
