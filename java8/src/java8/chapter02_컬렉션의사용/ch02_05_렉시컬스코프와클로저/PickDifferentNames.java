package java8.chapter02_컬렉션의사용.ch02_05_렉시컬스코프와클로저;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PickDifferentNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

		/**
		 * step1 friends 컬렉션에서 N이나 B로 시작하는 이름을 선택 
		 * - 표면적으로는 맞는것처럼 보이지만 단지 찾고자 하는 시작 문자가
		 * 다르다는 이유만으로 두개의 Predicate를 사용하는 것은 중복이다.!! 
		 * - 다음 단계에서 중복을 제거하는 방법을 알아봄
		 */
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final Predicate<String> startsWithB = name -> name.startsWith("B");

		final long countFriendsStartN = friends.stream().filter(startsWithN).count();

		final long countFriendsStartB = friends.stream().filter(startsWithB).count();

		/**
		 * step3 checkIfStartsWith()에 의해 리턴되는 람다 표현식을 사용
		 */
		final long countFirendsStartN2 = friends.stream().filter(checkIfStartsWith("N")).count();
		final long countFirendsStartB2 = friends.stream().filter(checkIfStartsWith("B")).count();

		/**
		 * step4 적용 범위를 좁히기 위한 리팩토링 1단계 - 필요한 곳에만 사용되도록 함수의 범위를 좁게 만드는 것이 좋음
		 */
		final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
			Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
			return checkStarts;
		};

		/**
		 * step5 step4 리팩토링
		 */
		final Function<String, Predicate<String>> startsWithLetter2 = (
				String letter) -> (String name) -> name.startsWith(letter);

		/**
		 * step6 step5 리팩토링 
		 * - 타입 제거 
		 * - 자바 컴파일러가 해당 타입을 컨텍스트에 따라 추론할 수 있도록 함
		 */
		final Function<String, Predicate<String>> startsWithLetter3 = letter -> name -> name.startsWith(letter);

		/**
		 * step7 startsWithLetter3 사용
		 */
		final long countFirendsStartN3 = friends.stream().filter(startsWithLetter3.apply("N")).count();
		final long countFirendsStartB3 = friends.stream().filter(startsWithLetter3.apply("B")).count();
		
		/**
		 * Function과 Predicate의 차이점
		 * Predicate
		 * - Predicate<T>는 타입 T인 파라미터 하나를 받아 체크한 결과에 대해 알려주기 위해 boolean 결과를 리턴한다.
		 * - 언제든지 이 기능을 사용하여 predicate에 넘기는 후보를 위해 계속 진행할지 말지를 결정할 수 있다.
		 * - 후보 엘리먼트를 평가하는 filter()와 같은 메서드들은 파라미터로 Predicate를 갖는다.
		 * 
		 * Function
		 * - Function<T,R>은 타입 T를 파라미터로 갖고 타입 R을 결과로 리턴하는 함수이다.
		 * - 이것은 항상 boolean 값을 리턴하는 Predicate 보다 더 일반적이다.
		 * - 입력을 다른 값으로 변경하고 싶은 경우에는 Function을 사용
		 */
	}

	/**
	 * step2 렉시컬 스코프(lexical scope)로 중복 제거하기 
	 * - 파라미터로 스트링 타입의 letter를 인수로 받는 정적함수인
	 * checkIfStartsWith() 메소드 정의 - Predicate를 리턴으로 넘김
	 * 
	 * - 렉시컬 스코프(lexical scope) 변수 letter의 범위는 이 어노니머스(anonymous) 함수의 범위에 있지 않기 때문에
	 * 람다 표현식의 정의에 대해 범위를 정하고 그 범위 안에서 변수 letter를 찾는다. 이것을 렉시컬 스코프라고 한다.
	 * 
	 * - 렉시컬 스코프의 제한 조건 final이나 스코프 내에 있는 지역변수만을 사용해야함 
	 * 1. 액세스된 변수는 람다 표현식이 정의되기 전에
	 * 변수를 사용하는 메서드에서 초기화되어야 한다. 
	 * 2. 이 변수들의 값은 어느 곳에서도 변경할 수 없다.
	 */
	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}
}
