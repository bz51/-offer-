package offer9;

/**
 * 计算斐波纳切数列的第n个值
 * @author chibozhou
 *
 */
public class Fibonacci {
	/**
	 * 分析：斐波纳切数列的第n个数的值是其前两个数之和，
	 * 因此要计算第n个数就需要计算其前两个数，
	 * 以此类推，直到计算出第0个数为止，
	 * 因此可以使用递归。
	 */
	
	/**
	 * 采用递归的方法
	 */
	public static int fibonacci(int n){
		//健壮性判断
		if(n<0){
			System.out.println("n不能小于0！");
			return 0;
		}
		
		//n＝＝0
		else if(n==0)
			return 0;
		
		//n＝＝1
		else if(n==1)
			return 1;
		
		//n>1
		else
			return fibonacci(n-1) + fibonacci(n-2);
		
	}
	
	
	
	/**
	 * 上述递归的代码虽然简单，但所需的内存空间很大，
	 * 而且在递归的过程中，有很多计算是重复的，比如：
	 * fibonacci(6)＝fibonacci(5)+fibonacci(4)
	 * 		fibonacci(5)＝fibonacci(4)+fibonacci(3)
	 * 		fibonacci(4)＝fibonacci(3)+fibonacci(2)
	 * 由此可见:fibonacci(4)、fibonacci(3)均被重复计算，
	 * 因此递归的方法在时间和空间上的开销都很大！
	 * 是否有比递归更好的办法来实现斐波纳切？
	 */
	
	
	
	/**
	 * 递归之所以开销巨大，是因为它是一个自顶向下的计算过程，
	 * 要计算fibonacci(n)，就需要先计算fibonacci(n-1)和fibonacci(n-2)，
	 * 而在fibonacci(0)被计算出之前，之前所有的函数都处于在内存中等待的状态，都占用着内存空间；
	 * 因此，如果我们采用自底向上的方式，每完成一个fibonacci函数，就记录下该值，并释放其内存空间，
	 * 就能节约内存空间。
	 * 此外，由于fibonacci(n)是由前两个数相加得到的，
	 * 因此只要将每次计算结果和前一个数记录下来，就能计算出之后值，从而避免了重复计算。
	 * @param n 斐波纳切数列长度
	 * @return 第n个元素值
	 */
	public static int fibonacci_recursion(int n){
		//健壮性判断
		if(n<0){
			System.out.println("n不能小于0");
			return 0;
		}
		
		if(n==0 || n==1)
			return n;
		
		//a1用于存储fibonacci(n-2)，a2用于存储fibonacci(n-1)，a3用于存储fibonacci(n)
		int a1=0,a2=1,a3=1;
		for(int i=0;i<n-1;i++){
			a3 = a1+a2;
			a1 = a2;
			a2 = a3;
		}
		
		return a3;
	}
	
	/**
	 * 上述算法求fibonacci(n)的过程如下：
	 * 	从0开始循环n－1次，每次计算
	 */
	
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		int result = fibonacci(40);
		System.out.println(result);
		
		int result2 = fibonacci_recursion(40);
		System.out.println(result2);
	}

}
