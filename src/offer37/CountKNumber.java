package offer37;

/**
 * 题目：统计一个有序数组中K出现的次数。
 * @author 大闲人柴毛毛
 * @date 2016年3月25日
 */
public class CountKNumber {
	
	/**
	 * 分析：本题最直观的思路就是遍历数组，统计K出现的次数即可。
	 * 这种方式的时间复杂度为O(n)。下面我们充分利用“有序数组”这一条件，提高算法的时间效率。
	 * 
	 * 对于一个有序数组，所有的数字K一定都集中在一起，因此只要我们找到这一组K的头和尾就能知道K出现的次数。
	 * 此时问题就转化为：在一个有序数组中寻找某个数字。
	 * 我们很自然地就想到了二分搜索，在目前所有的搜索算法中，二分搜索具有最高的搜索效率。
	 * 对于本题，我们需要进行两次二分搜索，一次寻找K的头，一次寻找K的尾。
	 * 二分搜索K头部的过程如下：
	 * 1.确定当前数组的中点；
	 * 2.若中点<K，则K的起点在后半段；
	 * 3.若中点>K，则K的起点在前半段；
	 * 4.若中点=K，则判断中点的前一个点是否等于K；
	 * 	4.1.若等于K，则K的起点在前半段；
	 * 	4.2.若不等于K，则该中点即为K的起点。
	 * 寻找K的终点与寻找起点类似。
	 * 
	 * 本算法的具体代码如下：
	 */
	
	/**
	 * 获取数组中K出现的个数
	 * @param a 数组
	 * @param k
	 * @return 返回K出现的个数(若为－1表示获取失败)
	 */
	public static int getKNumber(int[] a,int k){
		//健壮性判断：若数组为空
		if(a==null || a.length<=0){
			System.out.println("数组为空！");
			return -1;
		}
		
		//子数组起点的下标
		int start = 0;
		//子数组终点的下标
		int end = a.length-1;
		
		//K起点的下标
		int k_start = -1;
		//K终点的下标
		int k_end = -1;
		
		//当子数组的长度大于0的时候一直循环，获取k的起点坐标
		while(end-start >= 0){
			//计算中点下标
			int mid = (start+end)/2;
			
			//若a[mid]>k，则k的起点在前半段
			if(a[mid]>k){
				end = mid-1;
			}
			//若a[mid]<k，则k的起点在后半段
			else if(a[mid]<k){
				start = mid+1;
			}
			//若a[mid]＝k
			else{
				//若a[mid-1]＝＝k，则说明a[mid]不是k的起点
				if(a[mid-1]==k){
					end = mid-1;
				}
				//若a[mid-1]!＝k，则说明a[mid]是k的起点
				else{
					k_start = mid;
					break;
				}
			}
		}
		
		
		//将start、end指向数组的头和尾
		start = 0;
		end = a.length-1;
		//当子数组的长度大于0的时候一直循环，获取k的终点坐标
		while(end-start >= 0){
			//计算中点下标
			int mid = (start+end)/2;
			
			//若a[mid]>k，则k的起点在后半段
			if(a[mid]>k){
				end = mid-1;
			}
			//若a[mid]<k，则k的起点在前半段
			else if(a[mid]<k){
				start = mid+1;
			}
			//若a[mid]＝k
			else{
				//若a[mid+1]＝＝k，则说明a[mid]不是k的终点
				if(a[mid+1]==k){
					start = mid+1;
				}
				//若a[mid+1]!＝k，则说明a[mid]是k的终点
				else{
					k_end = mid;
					break;
				}
			}
		}
		
		//若未找到k的起点或终点
		if(k_start==-1 || k_end==-1)
			return 0;
		
		//统计k的个数
		return k_end-k_start+1;
	}
	
	
	
	/**
	 * 测试
	 */
	public static void main(String[] args){
		//构建数组
		int[] a = {0,1,2,3,4,6,7,7,7,7,7,7,8,9};
		//统计k的个数
		System.out.println(getKNumber(a,7));
	}
}
