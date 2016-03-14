package common;

/**
 * 本类用于存储数据
 * @author chibozhou
 *
 */
public class Value <T>{
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
