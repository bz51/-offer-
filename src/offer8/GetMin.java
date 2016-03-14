package offer8;

/**
 * 获取旋转数组的最小值
 * 旋转数组：在一个递增数组的任意一个位置切一刀，
 * 	再把第一个数组放到第二个数组的后面，
 * 	这样生成的数组就是旋转数组。 
 * @author chibozhou
 */
public class GetMin {
	private static int min;
	/**
	 * 获取旋转数组的最小值
	 * @param arr 输入的旋转数组
	 * @param start 数组的起始下标
	 * @param end 数组的结束下标
	 * @param min 搜索结果最小值
	 */
	public static void getMin(int[] arr,int start,int end,Int min){
		System.out.println("start="+start+",end="+end);
		//健壮性判断，数组不能为空
		if(arr==null || arr.length<=0){
			System.out.println("数组为空！");
			return ;
		}
		//健壮性判断，start不能>end
		if(start<0 || end<0 || start>end){
			System.out.println("start、end非法！");
			return;
		}
		//健壮性判断，min不能为空
		if(min==null){
			System.out.println("min为空！");
			return;
		}
		
		//若数组首<尾，则本身有序
		if(arr[start]<arr[end]){
			System.out.println("数组本身有序");
			min.setMin(arr[start]);
			return;
		}
		
		//若数组首＝尾，则断点位置不确定
		if(arr[start]==arr[end]){
			System.out.println("数组首尾相同，需要采用遍历寻找最小值:start="+start+",end="+end);
			//遍历数组，寻找最小值
			int i = start;
			while(arr[i]<=arr[i+1] && i<end){
				i++;
			}
			//输出最小值
			min.setMin(arr[++i]);
		}
		
		//若数组首>尾，则断点位置可以确定(要么在中点前，要么在中点后)
		if(arr[start]>arr[end]){
			//获取中点
			int mid = (start+end)/2;
			//若数组首<中点，则断点在后半段
			if(arr[start]<arr[mid]){
				start = mid+1;
			}
			else if(arr[start]>arr[end]){
				end = mid-1;
			}
			else{//arr[start]=arr[end]
				start = mid+1;
			}
			
			//若start和end相邻，则比较一下选出小的
			if(start+1==end){
				System.out.println("start和end相邻");
				if(arr[start]>arr[end]){
					min.setMin(arr[end]);
					System.out.println("mid1="+min.getMin());
				}
				else{
					min.setMin(arr[start]);
					System.out.println("mid2="+min.getMin());
				}
				return;
			}
			getMin(arr,start,end,min);
		}
	}
	
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		int[] a = new int[]{5,5,5,1,1,1,2,3,4};
		Int min = new Int();
		getMin(a, 0, a.length-1, min);
		System.out.println("最小值＝"+min.getMin());
		//Integer即使通过new出来的对象，作为参数传给函数，难道仍然传递的是值？？难道函数重新new了一个Integer对象？
	}
}

/**
 * 本类用于设置最小值 
 * @author chibozhou
 */
class Int{
	private int min;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
}
