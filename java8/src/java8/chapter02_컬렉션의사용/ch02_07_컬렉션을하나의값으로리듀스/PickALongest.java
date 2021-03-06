package java8.chapter02_컬렉션의사용.ch02_07_컬렉션을하나의값으로리듀스;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickALongest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		
		/**
		 * step1 firends 컬렉션에 있는 값들을 살펴보고 문자의 전체 수를 계산
		 * IntStream 인스턴스의 메서드에는 다음과 같은 메서드가 존재한다.
		 * sum(), max(), min(), sorted(), average()
		 */
		System.out.println("Total number of characters in all names: " + 
				friends.stream()
						.mapToInt(name -> name.length()).sum());
		
		/**
		 * step2
		 * 작동과정
		 * 1. 리스트에 있는 처음 두개 엘리먼트(name1,name2)를 사용하여 람다 표현식을 호출한다.
		 * 2. 람다 표현식의 결과는 다음 호출에서 사용된다.
		 * 3. 두번째 호출에서 name1은 이전 호출의 결과이며 name2는 컬렉션의 3번째 엘리먼트이다.
		 * 4. 마지막 호출에 대한 결과는 reduce() 메서드 호출의 전체 결과로 리턴한다.
		 * 5. reduce() 메서드의 결과는 Optional 인스턴스이다.
		 * 	이유는 reduce()가 호출된 리스트가 비워져 있을 수 있기 때문이다.
		 */
		final Optional<String> aLongName = friends.stream()
												.reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
		
		/**
		 * step3 reduce() 메서드의 기준값 설정
		 * - steve보다 큰 이름이 있으면 그 이름을 반환
		 * 없으면 Steve를 반환
		 * - 이 reduce() 버전은 Optional 인스턴스를 반환하지 않는다. 이유는 null인 경우
		 * 기준값(Steve)를 반환하기 때문이다.				
		 */
		final String steveOrLonger = friends.stream()
											.reduce("Steve", (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		
		
	}

}
