package offer7;

import common.Stack;

/**
 * 用两个栈实现一个队列
 * @author chibozhou
 */
public class Queue<T> {
	//队列当前大小
	private int curSize;
	//队列最大容量
	private int maxSize;
	//两个栈
	private Stack<T> stack1;
	private Stack<T> stack2;
	
	
	/**
	 * 初始化队列
	 * @param maxSize 设置最大容量
	 */
	public Queue(int maxSize){
		//健壮性判断
		if(maxSize<=0){
			System.out.println("队列大小不能小于1");
			return;
		}
		
		//初始化栈
		stack1 = new Stack<T>(maxSize);
		stack2 = new Stack<T>(maxSize);
		this.maxSize = maxSize;
	}
	
	
	
	/**
	 * 入队 
	 * @param obj 入队的元素
	 */
	public boolean push(T obj){
		//健壮性判断
		if(obj==null){
			System.out.println("入队元素不能为空！");
			return false;
		}
		
		//队已满
		if(stack1.getCurSize()>=maxSize){
			System.out.println("队以满！");
			return false;
		}
		
		//入队
		stack1.push(obj);
		curSize++;
		return true;
	}
	
	
	
	/**
	 * 出队
	 */
	public T pop(){
		//对为空
		if(curSize==0){
			System.out.println("队为空！");
			return null;
		}
		
		//将stack1中的所有元素转移到stack2中，再从stack2栈顶取元素即可（错误！！！下面为修订版：）
		//将stack2中的元素先出栈，若stack2中元素为空，此时将stack1中所有元素转移到stack2中，再出栈
//		while(stack1.getCurSize()>0){
//			stack2.push(stack1.pop());
//		}
		
		//若stack2中不为空，则直接出队
		if(stack2.getCurSize()>0){
			curSize--;
			return stack2.pop();
		}
		//若stack2为空，则将stack1中所有元素转移到stack2中，再出队
		else{
			while(stack1.getCurSize()>0){
				stack2.push(stack1.pop());
			}
			
			curSize--;
			return stack2.pop();
		}
	}
	
	
	
	/**
	 * 打印队列
	 */
	@Override
	public String toString() {
		System.out.println("Queue---maxSize:"+maxSize+"---curSize:"+curSize+"------");
		//存储队列元素
		StringBuffer sb = new StringBuffer();
		
		//队列为空
		if(curSize==0){
			System.out.println("队列为空");
			return null;
		}
		
//		//若数据都在stack1中，则转到stack2中
//		if(stack1.getCurSize()>=0){
//			while(stack1.getCurSize()>0){
//				stack2.push(stack1.pop());
//			}
//		}
//		
//		//打印stack2中的元素
//		for(int i=0;i<stack2.getCurSize();i++){
//			System.out.println(stack2.top());
//		}
		
		
		//先打印stack2中的元素
		while(stack2.getCurSize()>0){
			sb.append(stack2.pop());
		}
		
		//若stack1中还有元素，则先将其转移到stack2，再将stack2中的元素打印
		while(stack1.getCurSize()>0){
			stack2.push(stack1.pop());
		}
		
		while(stack2.getCurSize()>0){
			sb.append(stack2.pop());
		}
		
		System.out.println(sb.toString());
		System.out.println("Queue--------------------------------------------------");
		return null;
	}



	/**
	 * 测试
	 */
	public static void main(String[] args){
		Queue<Integer> queue = new Queue<Integer>(10);
		for(int i=0;i<10;i++)
			queue.push(i+1);
		queue.toString();
		queue.pop();
		queue.toString();
	}
}
