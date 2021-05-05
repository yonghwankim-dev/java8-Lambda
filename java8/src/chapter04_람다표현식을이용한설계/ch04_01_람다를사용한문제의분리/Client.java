package chapter04_람다표현식을이용한설계.ch04_01_람다를사용한문제의분리;

import java.util.Arrays;
import java.util.List;

import chapter04_람다표현식을이용한설계.ch04_01_람다를사용한문제의분리.Asset.AssetType;

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
		 * 연습문제1 : AssetType이 BOND인 asset들의 합계를 구하라.
		 * 			AssetUtilRefactored 클래스의 totalAssetValues 메서드 활용
		 * 			단, totalAssetValues 메서드의 내용이 변경되면 안되고 인자값만으로
		 * 			결과를 도출하라.
		 */
		System.out.println("Total of bonds : " + AssetUtilRefactored.totalAssetValues(assets, asset -> asset.getType()==AssetType.BOND));
		
		/**
		 * 연습문제2 : 연습문제1과 동일하게 AssetType이 STOCK인 asset들의 합계를 구하라
		 */
		System.out.println("Total of stocks : " + AssetUtilRefactored.totalAssetValues(assets, asset -> asset.getType()==AssetType.STOCK));
		
		
		
	}

}
