package chapter04_����ǥ�������̿��Ѽ���.ch04_01_���ٸ�����ѹ����Ǻи�;

import java.util.Arrays;
import java.util.List;

import chapter04_����ǥ�������̿��Ѽ���.ch04_01_���ٸ�����ѹ����Ǻи�.Asset.AssetType;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Asset> assets = Arrays.asList(
										new Asset(AssetType.BOND, 1000),
										new Asset(AssetType.BOND, 2000),
										new Asset(AssetType.STOCK, 3000),
										new Asset(AssetType.STOCK, 4000)
									);
		
		System.out.println("Total of all assets: " + AssetUtil.totalAssetValues(assets));	// 10000
		
		System.out.println("Total of bonds : " + AssetUtil.totalBondValues(assets));	// 3000
		
		System.out.println("Total of stocks : " + AssetUtil.totalStockValues(assets));	// 7000
		
		System.out.println("Total of all assets: " + AssetUtilRefactored.totalAssetValues(assets, asset-> true));	// 10000
		
		/**
		 * ��������1 : AssetType�� BOND�� asset���� �հ踦 ���϶�.
		 * 			AssetUtilRefactored Ŭ������ totalAssetValues �޼��� Ȱ��
		 * 			��, totalAssetValues �޼����� ������ ����Ǹ� �ȵǰ� ���ڰ�������
		 * 			����� �����϶�.
		 */
		System.out.println("Total of bonds : " + AssetUtilRefactored.totalAssetValues(assets, asset -> asset.getType()==AssetType.BOND));
		
		/**
		 * ��������2 : ��������1�� �����ϰ� AssetType�� STOCK�� asset���� �հ踦 ���϶�
		 */
		System.out.println("Total of stocks : " + AssetUtilRefactored.totalAssetValues(assets, asset -> asset.getType()==AssetType.STOCK));
		
		
		
	}

}
