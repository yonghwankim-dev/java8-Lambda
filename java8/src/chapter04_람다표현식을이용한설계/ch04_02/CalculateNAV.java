package chapter04_람다표현식을이용한설계.ch04_02;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {
	/**
	 * step2
	 */
	private Function<String, BigDecimal> priceFinder;
	
	/**
	 * step3
	 * @param aPriceFinder
	 */
	public CalculateNAV(final Function<String, BigDecimal> aPriceFinder)
	{
		priceFinder = aPriceFinder;
	}
	
	/**
	 * step1 CalculateNAV 클래스를 사용해서 웹 서비스에서 받은 데이터를 사용하여 재무연산 수행
	 * - priceFinder에 대한 주식시세표(ticker)의 가격을 요청하고 주식의 시세에 따라 가치를 결정한다.
	 * @param ticker
	 * @param shares
	 * @return
	 */
	public BigDecimal computeStockWorth(final String ticker, final int shares){
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
