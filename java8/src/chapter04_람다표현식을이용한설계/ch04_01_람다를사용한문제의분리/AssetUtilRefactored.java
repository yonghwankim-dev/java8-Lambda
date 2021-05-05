package chapter04_람다표현식을이용한설계.ch04_01_람다를사용한문제의분리;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtilRefactored {
	/**
	 * step4 함수형 인턴페이스를 파라미터로 갖는 오직 하나의 메소드로 리팩토링을 수행
	 * 다음 메소드는 클래스나 어노니머스 이너 클래스를 생성하지 않고 람다 표현식을
	 * totalAssetValue() 메서드의 리팩토링 버전에 전달한다.
	 * 
	 * 수행과정
	 * 0. 인자인 Predicate를 filter() 메서드에 전달하고 mapToInt()의 인수를 위해 메서드 레퍼런스 사용
	 * 1. filter() 메서드를 사용하여 asset의 리스트를 필터링 수행
	 * 2. asset을 mapToInt() 함수를 사용하여 각각의 가격에 매핑
	 * 3. sum() 메서드를 수행하여 합계값 도출
	 *  
	 * @param assets		assets의 리스트
	 * @param assetSelector	asset을 고려해야 할지를 판단하는 Predicate
	 * @return	assetSelector에 의해 필러팅된 값들의 합계값
	 */
	public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector)
	{
		return assets.stream()
					.filter(assetSelector)
					.mapToInt(Asset::getValue)
					.sum();
	}
}
