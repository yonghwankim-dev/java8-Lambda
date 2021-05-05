package chapter04_����ǥ�������̿��Ѽ���.ch04_01_���ٸ�����ѹ����Ǻи�;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtilRefactored {
	/**
	 * step4 �Լ��� �������̽��� �Ķ���ͷ� ���� ���� �ϳ��� �޼ҵ�� �����丵�� ����
	 * ���� �޼ҵ�� Ŭ������ ���ϸӽ� �̳� Ŭ������ �������� �ʰ� ���� ǥ������
	 * totalAssetValue() �޼����� �����丵 ������ �����Ѵ�.
	 * 
	 * �������
	 * 0. ������ Predicate�� filter() �޼��忡 �����ϰ� mapToInt()�� �μ��� ���� �޼��� ���۷��� ���
	 * 1. filter() �޼��带 ����Ͽ� asset�� ����Ʈ�� ���͸� ����
	 * 2. asset�� mapToInt() �Լ��� ����Ͽ� ������ ���ݿ� ����
	 * 3. sum() �޼��带 �����Ͽ� �հ谪 ����
	 *  
	 * @param assets		assets�� ����Ʈ
	 * @param assetSelector	asset�� ����ؾ� ������ �Ǵ��ϴ� Predicate
	 * @return	assetSelector�� ���� �ʷ��õ� ������ �հ谪
	 */
	public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector)
	{
		return assets.stream()
					.filter(assetSelector)
					.mapToInt(Asset::getValue)
					.sum();
	}
}
