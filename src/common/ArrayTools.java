package common;

public class ArrayTools {
	/**
	 * 输出数组元素
	 * @param arr
	 * @return
	 */
	public static String printArray(int[] arr){
		if(arr==null){
			System.out.println("数组为空！");
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]+",");
		}
		
		return sb.toString();
	}
}
