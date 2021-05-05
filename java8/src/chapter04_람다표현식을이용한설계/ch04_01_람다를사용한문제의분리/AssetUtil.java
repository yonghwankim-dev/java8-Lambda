package chapter04_����ǥ�������̿��Ѽ���.ch04_01_���ٸ�����ѹ����Ǻи�;

import java.util.List;

import chapter04_����ǥ�������̿��Ѽ���.ch04_01_���ٸ�����ѹ����Ǻи�.Asset.AssetType;

public class AssetUtil {
	/**
	 * step1 asset�� ��� ���� ���ϴ� ���� ����
	 * 1. Assets�� ����Ʈ�� ��Ʈ������ ��ȯ
	 * 2. mapToint() �޼��带 ����Ͽ� ���� ���� ��Ʈ������ ����
	 * 3. ��Ʈ���� �ִ� ������ ����� �Ŀ� sum() �޼��带 ����Ͽ� �ϳ��� ������ ����
	 */
	public static int totalAssetValues(final List<Asset> assets)
	{
		return assets.stream()
						.mapToInt(Asset::getValue)
						.sum();
	}
	
	/**
	 * step2 �ڻ����°� BOND�� �ڻ��� �հ谪 ����
	 */
	public static int totalBondValues(final List<Asset> assets)
	{
		return assets.stream()
						.mapToInt(asset -> asset.getType()==AssetType.BOND ? asset.getValue() : 0)
						.sum();
	}
	
	/**
	 * step3 �ڻ����°� STOCK�� �ڻ��� �հ谪 ����
	 */
	public static int totalStockValues(final List<Asset> assets)
	{
		return assets.stream()
						.mapToInt(asset -> asset.getType()==AssetType.STOCK ? asset.getValue() : 0)
						.sum();
	}
	
	/**
	 * ���Ͱ��� �޼ҵ� 3���� 3���� �������� �����Ѵ�.
	 * 1. ���ͷ��̼��� ��� �ϴ°�?
	 * 2. � ���鿡 ���� �հ踦 ����ϴ°�?
	 * 3. �� �հ踦 ��� ���ϴ°�?
	 */
	 
}
