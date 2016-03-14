package common;

/**
 * 这是一个栈
 * @author chibozhou
 */
public class Stack<T> {
	//栈最大容量
	private int maxSize;
	//栈实际大小
	private int curSize;
	//栈的底层数组
	private T[] dataArray;
	
	/**
	 * 初始化栈
	 * @param size 指定栈的最大容量
	 */
	public Stack(int maxSize){
		if(maxSize<=0){
			System.out.println("size不能小于1！");
			return;
		}
		this.maxSize = maxSize;
		dataArray = (T[]) new Object[maxSize];
	}
	
	
	
	/**
	 * 入栈
	 * @param obj
	 * @return
	 */
	public boolean push(T obj){
		//健壮性判断
		if(obj==null){
			System.out.println("入栈元素不得为空！");
			return false;
		}
		
		//判断栈是否已满
		if(curSize>=maxSize){
			System.out.println("栈已满！");
			return false;
		}
		
		//入栈
		dataArray[curSize++] = obj;
		return true;
	}

	
	/**
	 * 出栈
	 */
	public T pop(){
		//栈为空时
		if(curSize==0){
			System.out.println("当前栈为空");
			return null;
		}
		
		//出栈
		return dataArray[--curSize];
	}
	
	
	/**
	 * 输出栈
	 */
	@Override
	public String toString() {
		System.out.println("Stack{ maxSize:"+maxSize+"-----curSize:"+curSize+"--------------");
		//栈为空
		if(curSize<=0){
			System.out.println("当前栈为空");
		}
		
		//栈非空
		else{
			for(int i=0;i<curSize;i++){
				System.out.println(dataArray[curSize-i-1]);
			}
		}
		
		System.out.println("}Stack----------------------------------------------------------");
		return null;
	}

	
	
	/**
	 * 获取栈顶元素
	 */
	public T top(){
		if(curSize==0){
			System.out.println("栈为空！");
			return null;
		}
		
		return dataArray[curSize-1];
	}
	
	/**
	 * 获取栈的最大容量 
	 */
	public int getMaxSize() {
		return maxSize;
	}



	/**
	 * 获取栈的当前容量
	 */
	public int getCurSize() {
		return curSize;
	}



	/**
	 * 测试
	 */
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>(10);
		
//		stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.toString();
	}
}
