package offer11;

/**
 * 实现a的b次方
 * @author 大闲人柴毛毛
 */
public class Power {
	/**
	 * 分析：a的b次方就是将a连乘b次，
	 * 本题的逻辑性不难，关键在于程序的健壮性，
	 * 需要将可能的情况考虑全面。
	 * @param a 底数
	 * @param b 指数
	 * @return a的b次方
	 */
	public static double power(double a,int b){
		//若底数为0，则结果为0
		if(Power.equal(a,0.0))
			return 0;
		
		//若指数为0，则结果为1
		if(b==0)
			return 1;
		
		//计算a^|b|,若指数为负数，则取b的绝对值
		double c = a;//c存放计算结果
		for(int i=0; i<(b<0?-b:b)-1; i++){
			c *= a;
		}
		
		//输出结果
		if(b<0)
			return 1/c;
		else
			return c;
	}
	
	
	/**
	 * 由于float、double都存在精度问题，float、double进行计算时得不到精确的结果，
	 * 因此误差若小于0.0001，我们就认为近似相等，因此需要定义判断近似相等的函数。
	 */
	
	
	/**
	 * 比较两个double是否近似相等
	 * PS:若误差在0.0001内就认为相等
	 * @param a
	 * @param b
	 * @return 是否近似相等
	 */
	public static boolean equal(double a, double b){
		if(a-b<=0.0001 && a-b >=-0.0001)
			return true;
		else
			return false;
	}
	
	
	
	public static void main(String[] args){
		System.out.println(power(-2,-2));
	}
	
}
