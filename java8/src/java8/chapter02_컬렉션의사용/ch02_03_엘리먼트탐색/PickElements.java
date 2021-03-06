package java8.chapter02_컬렉션의사용.ch02_03_엘리먼트탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PickElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian","Nate","Neal","Raju","Sara","Scott");
		
		/**
		 * step1 startsWithN 리스트에 N으로 시작하는 엘리먼트 추가
		 * - 코드가 장황한편
		 */
		final List<String> startsWithN = new ArrayList<String>();
		for(String name : friends)
		{
			if(name.startsWith("N"))
			{
				startsWithN.add(name);
			}
		}
		
		/**
		 * step2 filter() 메서드를 사용하여 리팩토링
		 * - filter() 메서드는 boolean 결과를 리턴하는 람다 표현식이 필요함
		 * - 람다 표현식이 true를 리턴하면 람다 표현식이 실행하는 동안 컨텍스트의
		 * 엘리먼트는 결과 컬렉션에 추가된다.
		 * - 마지막에 true라고 체크한 엘리먼트의 스트림을 리턴한다.
		 * - 결과를 collect() 메서드를 사용하여 리스트로 변경한다.
		 */
		final List<String> startsWithN2 = friends.stream()
													.filter(name -> name.startsWith("N"))
													.collect(Collectors.toList());
			
		/**
		 * step3 결과 컬렉션에서 항목의 수를 출력
		 * - fileter() 메서드는 map() 메소드처럼 이터레이션을 리턴함
		 * - map() 메서드는 입력과 같은 크기의 컬렉션을 리턴하는 반면
		 * filter() 메서드는 그렇지 않음.
		 * 
		 */
		System.out.println(String.format("Format %d names", startsWithN2.size()));
		
	}
	
	

}
