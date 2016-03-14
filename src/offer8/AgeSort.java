package offer8;

import common.ArrayTools;

/**
 * 对某公司所有员工的年龄进行排序，要求时间复杂度为O(n)
 * @author chibozhou
 *
 */
public class AgeSort {
	/**
	 * 排序函数
	 * @param ages 存放公司全体人员年龄的数组
	 */
	public static void ageSort(int[] ages){
		//countAge的下标i代表年龄，countAge[i]代表年龄为i的员工人数
		int[] countAge = new int[100];
		
		//健壮性判断
		if(ages==null || ages.length<=0){
			System.out.println("数组为空！");
			return;
		}
		for(int i=0;i<ages.length;i++){
			if(ages[i]<0 || ages[i]>99){
				System.out.println("数组中存在非法年龄！");
				return;
			}
		}
		
		//统计每个年龄的人数，存储在countAge数组中
		for(int i=0;i<ages.length;i++)
			countAge[ages[i]]++;
		
		//将countAge数组展开，存放在ages数组中
		int curIndex = 0;//用于记录ages数组当前下标
		for(int i=0;i<countAge.length;i++){
			for(int j=0;j<countAge[i];j++){
				ages[curIndex] = i;
				curIndex++;
			}
		}
	}
	
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] ages){
//		int[] arr = new int[]{23,20,19,17,33,45,28};
//		ageSort(arr);
//		System.out.println(ArrayTools.printArray(arr));
		
		int a = 3;
		switch(a){
		default:
			System.out.println("default");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		case 3:
			System.out.println("3");
		case 4:
			System.out.println("4");
		}
		
		
		wangcai:for(int i=0;i<10;i++){
			break wangcai;
		}
	}
	
	
//	byte a = 10;
//	int b = a;
//	byte c = a;
//	byte d = a+3;
//	byte e = (byte)(a+3);
}
