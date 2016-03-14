package offer10;

/**
 * 题目：输入一个十进制整数，统计其中二进制1的个数
 * @author 大闲人柴毛毛
 */
public class CountBitOne {
	/**
	 * 这个问题最直观的思路：
	 * 将输入的整数转换成二进制数，
	 * 再把这个二进制数转换成字符数组，
	 * 最后遍历数组，统计1的个数。
	 * 
	 * 使用数组需要开辟额外的内存空间，
	 * 若在不能使用Java相关类库的情况下，
	 * 要实现十进制向二进制数组的转化实属不易。
	 * 且该方法需要完整遍历数组，因此需要n次比较。
	 * 
	 * 下面我们探求更高效的方法。
	 */
	
	
	/**
	 * 这道题涉及到二进制，因此我们应当敏锐地察觉到使用位运算来解决问题！
	 * 
	 * 位运算具有如下特性：
	 * 1与一个二进制数进行与运算，若最低位是1，则运算的结果为1，否则结果为0。
	 * 
	 * 因此，让输入的数与1进行与运算，每运算一次便统计当前结果是否为1，并将数右移一位，
	 * 当该数为0时统计结束。
	 * 
	 * 代码实现如下：
	 */
	public static int countBitOne_1(int n){
		//n中1的个数
		int count = 0;
		while(n!=0){
			//判断当前运算结果是否为1
			if((n&1)==1)
				count++;
			//将n右移一位
			n = n >> 1;
		}
		return count;
	}
	
	
	
	/**
	 * 上述方法有个严重的bug！
	 * 若一个正数右移n位，则需要用n个1来补齐最高位。
	 * 因此，当一个正数右移了若干次之后，它的所有位置都被1取代，
	 * 此时与1进行与运算的结果永远是1，从而出现了死循环。
	 * 
	 * 如何解决呢？
	 * 
	 * 出现上述情况的原因有两个：1.右移、2.正数，
	 * 只要破坏了这两个条件中的任何一个，就能避免死循环的现象。
	 * 由于本题的输入要求中包含了正整数，因此我们只能破坏第一个条件。
	 * 
	 * 虽然右移与正负有关，但左移与正负无关！
	 * 并且要达到和方法1一样的效果，我们就让“00000001”这个序列左移。
	 * 
	 * 代码如下：
	 */
	public static int countBitOne_2(int n){
		//n中1的个数
		int count = 0;
		//进行左移的序列00000001
		int flag = 1;
		//当flag不为0的时候循环
		while(flag!=0){
			//若当前与运算结果为1，则表示n当前位置是1
			if((n&flag) != 0)
				count++;
			//flag左移一位
			flag = flag << 1;
		}
		return count;
	}
	/**
	 * 这种方式不需要额外的内存空间，
	 * 而且十进制位运算的过程中，进制的转化由JVM完成，无需程序猿手动实现。
	 * 这种方法的时间复杂度为O(n),需要进行n次比较。
	 * 
	 * 下面介绍更高效的方式。
	 */
	
	
	
	/**
	 * 如果将一个二进制数－1，那么该二进制数最右侧的1将会变成0，1后面的0均变成1，1前面的数保持不变。
	 * 也就是说，如果一个二进制数－1，那么该数最右侧的1及1右侧的所有数均变成相反数。
	 * 如果把这个数和原数与运算，那么最右侧的那个1前面的数将不变，1及1右侧的所有数均变为0。
	 * 也就是说，进行一次上述的运算后，原数最右侧的那个1将会变成0，
	 * 那么只要重复上述操作，当原数变成0时，循环的次数就是1的个数。
	 * 
	 * 代码如下：
	 */
	public static int countBitOne_3(int n){
		//n中1的个数
		int count = 0;
		while(n!=0){
			n = n & (n-1);
			count++;
		}
		return count;
	}
	
	
	public static void main(String[] args){
		int num = -456;
		System.out.println("countBitOne_1="+countBitOne_1(num));
		System.out.println("countBitOne_2="+countBitOne_2(num));
		System.out.println("countBitOne_3="+countBitOne_3(num));
	}
}
