package java8.chapter02_컬렉션의사용.ch02_04_람다표현식재사용성;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PickElementsMultipleCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
		final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

		/**
		 * step1 filter() 메서드의 초보적 방법
		 * - 람다 표현식은 코드를 간결하게 만들어주지만 name-> name.startsWith("N") 부분이 중복을 발생시킴
		 * - 아래와 같은 문제를 해결하기 위해서 람다 표현식을 변수에 저장해서 사용이 가능하다.
		 */
		final long countFriendsStartN = friends.stream().filter(name -> name.startsWith("N")).count();

		final long counteditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();

		final long countcomradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();

		/**
		 * step2 Predicate 함수형 인터페이스를 활용한 람다 표현식을 변수에 저장
		 */
		final Predicate<String> startsWithN = name->name.startsWith("N");
		final long countFriendsStartN2 = friends.stream().filter(startsWithN).count();

		final long counteditorsStartN2 = editors.stream().filter(startsWithN).count();

		final long countcomradesStartN2 = comrades.stream().filter(startsWithN).count();
		
		
	}

}
