package offer12;

/**
 * 题目：输入一个正整数n，请计算位数为n的最大正数,
 * 并从1开始依次打印到这个最大的n位正数。
 * @author 大闲人柴毛毛
 *
 */
public class MaxN {
	/**
	 * 本题看似简单，
	 * 只要计算10^n-1即可求得最大的n位正数。代码如下：
	 * PS:用全局变量result表示函数执行是否正确
	 */
	static boolean result = true;
	public static int getMaxN_1(int n){
		//健壮性判断
		if(n<=0){
			System.out.println("请输入正确的位数！");
			result = false;
			return 0;
		}
		
		int max = 1;
		for(int i=0;i<n;i++){
			max *= 10;
		}
		
		//依次打印
		for(int i=1;i<=max;i++){
			System.out.println(i);
		}
		return max-1;
	}
	
	
	
	/**
	 * 上述程序有个致命的缺点：由于n是位数，若n很大时，long都无法表示这个数字该怎么办？
	 * 想到这点，这个问题其实就是一道大数问题。
	 * 解决方法：采用数组来表示这个大数，每位存一个0-9。
	 * 由于数组的内存大小可以无限增大，因此使用数组存储大数非常合适。
	 * 但用数组存储有个缺点，那就是需要我们自己定义数组的递增函数，以便打印时使用，代码如下：
	 */
	public static int getMaxN_2(int n){
		//健壮性判断
		if(n<=0){
			System.out.println("请输入正确的位数！");
			result = false;
			return 0;
		}
		
		//创建一个长度为n的数组
		short[] a = new short[n];
		
		//数组初始化为：000……001
		for(int i=0;i<n;i++){
			a[i] = 0;
		}
		a[n-1] = 1;
		
		//打印1-最大的n位数(当i比数组a表示的值小的时候打印当前数组表示的值)
		int index = n-1;//当前最高位
//		while(index>=0 && a[index]<9)
		
		return 0;
	}
	
	
	
	/**
	 * 比较i是否小于字符数组a表示的值
	 * @param i 整数
	 * @param a 字符数组
	 * @return 比较结果
	 */
	public static boolean isLower(int i,char[] a){
		//健壮性判断
		if(a==null || a.length<=0){
			System.out.println("字符数组a为空！");
			result = false;
			return false;
		}
		
		//
		
		
		return true;
	}
}
