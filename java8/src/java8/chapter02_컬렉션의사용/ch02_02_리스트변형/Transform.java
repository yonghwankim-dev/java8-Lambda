package java8.chapter02_컬렉션의사용.ch02_02_리스트변형;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian","Nate","Neal","Raju","Sara","Scott");
		
		/**
		 * step1 새로운 컬렉션 생성하여 대문자로 변환후 저장
		 */
		final List<String> uppercaseNames = new ArrayList<String>();
		for(String name : friends)
		{
			uppercaseNames.add(name.toUpperCase());
		}
		
		/**
		 * step2 내부 iterator 사용
		 * - 내부 iterator를 사용했지만 여전히 빈 리스트(uppercaseNames)가 필요하고 그 리스트에 엘리먼트를
		 * 추가하는 작업도 필요하다.
		 */
		uppercaseNames.clear();
		friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
		
		/**
		 * step3 map 메서드 사용
		 * - map() 메서드를 사용하면 가변성(mutability)이 발생하지 않도록 할 수 있으며
		 * 코드를 더 간결하게 만들 수 있다.
		 * - map() 메서드는 입력 순서를 출력 순서로 매핑하거나 입력 순서를 다른 순서의 출력으로
		 * 변형한다.
		 * - map() 메서드는 람다 표현식의 실행 결과를 취합하여 결과 컬렉션으로 리턴한다.
		 */
		uppercaseNames.clear();
		friends.stream()
				.map(name -> name.toUpperCase())
				.forEach(name -> System.out.print(name + " "));
		System.out.println();
		
		/**
		 * step4 각 이름에 있는 문자의 수를 카운트
		 * 
		 */
		uppercaseNames.clear();
		friends.stream()
				.map(name -> name.length())
				.forEach(count -> System.out.print(count + " "));
		
		/**
		 * step5 메소드 레퍼런스의 사용
		 * name -> name.toUpperCase()  => String::toUpperCase
		 */
		friends.stream()
				.map(String::toUpperCase)
				.forEach(name -> System.out.println(name));
		
		/**
		 * 메소드 레퍼런스를 언제 사용해야 하는가?
		 * 람다 표현식을 사용할 때 파라미터를 전달하지 않는 경우라면 메서드 레퍼런스를 사용할 수 있다는 의미
		 */
	}

}
