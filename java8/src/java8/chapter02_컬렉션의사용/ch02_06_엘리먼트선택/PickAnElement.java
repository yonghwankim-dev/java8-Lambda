package java8.chapter02_컬렉션의사용.ch02_06_엘리먼트선택;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElement {
	
	/**
	 * step1 주어진 문자로 시작하는 엘리먼트를 찾아 출력하는 메소드
	 * 첫번째 문제점
	 * foundName 변수를 생성하고 null로 초기화함
	 * null 체크를 해야 하고 체크하는 것을 잊어버리면 결과는 NullPointerException이 발생하여
	 * 문제가 생간다.
	 * 
	 * 두번째 문제점
	 * 이터레이터를 사용하여 찾고자 하는 엘리먼트를 찾으면 루프를 빠져나오는 점
	 * 
	 * 그외 문제점
	 * 원시적인 강박관념
	 * 명령형 스타일
	 * 가변성
	 */
	public static void pickName(final List<String> names, final String startingLetter) {
		String foundName = null;
		for(String name : names) {
			if(name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		System.out.println(String.format("A name starting with %s: ", startingLetter));
		
		if(foundName!=null)
		{
			System.out.println(foundName);
		}
		else
		{
			System.out.println("No name found");
		}
	}
	
	/**
	 * step2 람다 표현식 사용
	 * filter()
	 * - 메서드를 사용하여 원하는 패턴과 매칭되는 모든 엘리먼트를 가져온다.
	 * 
	 * Stream.findFirst()
	 * - 컬렉션에서 첫번째 값 추출
	 * - Optional 객체 반환
	 * 
	 * Optional
	 * - Optional 클래스는 결과가 없는 경우에 유용함
	 * - NullPointerException이 발생하는 것을 막아줌
	 * 
	 * 
	 * @param args
	 */
	public static void pickName2(final List<String> names, final String startingLetter) {
		final Optional<String> foundName = names.stream()
												.filter(name -> name.startsWith(startingLetter))
												.findFirst();
		
		System.out.println(String.format("A name starting with %s : %s", startingLetter, foundName.orElse("No name found")));
		
		/**
		 * step3
		 * ifPresent
		 * 객체가 존재하는지를 알아보고 get() 메서드를 사용하여 현재 값을 얻어온다.
		 * 
		 *  name이 null이면 다음 문장을 실행하지 않는다.
		 */
		foundName.ifPresent(name -> System.out.println("Hello " + name));
		
	}
	public static void main(String args[])
	{
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		pickName2(friends,"N");
		pickName2(friends,"Z");
		
		
	}
}
