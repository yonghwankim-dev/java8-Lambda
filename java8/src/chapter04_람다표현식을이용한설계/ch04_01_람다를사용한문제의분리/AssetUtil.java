package chapter04_람다표현식을이용한설계.ch04_01_람다를사용한문제의분리;

import java.util.List;

import chapter04_람다표현식을이용한설계.ch04_01_람다를사용한문제의분리.Asset.AssetType;

public class AssetUtil {
	/**
	 * step1 asset의 모든 값을 더하는 과정 수행
	 * 1. Assets의 리스트를 스트림으로 변환
	 * 2. mapToint() 메서드를 사용하여 값에 대한 스트림으로 매핑
	 * 3. 스트림의 있는 값들을 계산한 후에 sum() 메서드를 사용하여 하나의 값으로 도출
	 */
	public static int totalAssetValues(final List<Asset> assets)
	{
		return assets.stream()
						.mapToInt(Asset::getValue)
						.sum();
	}
	
	/**
	 * step2 자산형태가 BOND인 자산의 합계값 도출
	 */
	public static int totalBondValues(final List<Asset> assets)
	{
		return assets.stream()
						.mapToInt(asset -> asset.getType()==AssetType.BOND ? asset.getValue() : 0)
						.sum();
	}
	
	/**
	 * step3 자산형태가 STOCK인 자산의 합계값 도출
	 */
	public static int totalStockValues(final List<Asset> assets)
	{
		return assets.stream()
						.mapToInt(asset -> asset.getType()==AssetType.STOCK ? asset.getValue() : 0)
						.sum();
	}
	
	/**
	 * 위와같은 메소드 3개는 3가지 문제점이 존재한다.
	 * 1. 이터레이션을 어떻게 하는가?
	 * 2. 어떤 값들에 대한 합계를 계산하는가?
	 * 3. 그 합계를 어떻게 구하는가?
	 */
	 
}
