package chapter04_람다표현식을이용한설계.ch04_01_람다를사용한문제의분리;

public class Asset {
	public enum AssetType {BOND, STOCK};
	private final AssetType type;
	private final int value;
	
	public Asset(final AssetType type, final int value) {
		this.type = type;
		this.value = value;
	}

	public AssetType getType() {
		return type;
	}

	public int getValue() {
		return value;
	}
	
	
	
}
