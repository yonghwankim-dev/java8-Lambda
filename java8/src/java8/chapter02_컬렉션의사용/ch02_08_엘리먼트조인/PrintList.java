package java8.chapter02_컬렉션의사용.ch02_08_엘리먼트조인;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		/**
		 * step1 기존 for문을 활용한 컬렉션 리스트 출력
		 * 아래 for문의 문제는 마지막 이름 뒤에 ','가 출력된다.
		 */
		for(String name : friends)
		{
			System.out.print(name + ", ");
		}
		System.out.println();
		
		/**
		 * step2 콤마를 출력하지 않은 구식 방법
		 * 결과는 좋게 보이지만 그다지 좋아 보이지가 않음.
		 */
		for(int i=0;i<friends.size()-1;i++)
		{
			System.out.print(friends.get(i) + ", ");
		}
		if(friends.size()>0)
		{
			System.out.println(friends.get(friends.size()-1));
		}
		
		/**
		 * step3 StringJoiner 클래스를 사용한 리스트 출력
		 * 내부적으로 String의 join() 메서드는 StringJoiner를 호출하여
		 * 두번째 매개변수인 가변인자 안에 있는 값들을 첫번째 인수로 분리된 하나의
		 * 스트링으로 합친다.
		 */
		System.out.println(String.join(", ", friends));
		
		/**
		 * step4 collect() 메서드를 활용한 리스트 출력
		 * collect() 메서드는 리덕션(reduction)이지 실제 구현을 위임하거나 타깃이
		 * 컬렉터가 되는 것은 아니다.
		 * 예를들어 변경된 엘리먼트를 ArrayList에 넣을 수 있다.
		 */
		System.out.println(
				friends.stream()
						.map(String::toUpperCase)
						.collect(Collectors.joining(", "))
				);
		
		
		
		
	}

}
