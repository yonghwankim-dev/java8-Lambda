package java8.chapter02_컬렉션의사용.ch02_01_리스트를사용한이터레이션;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {
	public static void main(String args[])
	{
		// 불변(Immutable) 컬렉션
		final List<String> friends = Arrays.asList("Brian","Nate","Neal","Raju","Sara","Scott");
		
		
		/**
		 * step1 각각의 엘리먼트를 이터레이션
		 * 자해하는 패턴이라고 부름
		 * 코드가 장황하고 오류가 발생활 확률이 높음	
		 * 컬렉션에서 특정 인덱스에 있는 엘리먼트를
		 * 처리하는 경우에만 유요함
		 * 명령형 프로그래밍 스타일
		 */
		for(int i=0;i<friends.size();i++)
		{
			System.out.println(friends.get(i));
		}
		
		/**
		 * step2 내부적인 이터레이션 사용
		 * Iterator 인터페이스를 사용하고 hasNext()와 next() 메서드 사용
		 * 명령형 프로그래밍 스타일
		 */
		for(String name : friends)
		{
			System.out.println(name);
		}
		
		/**
		 * step3 forEach() 메소드 사용
		 * - forEach 메소드는 Consumer 타입의 인자를 받는다.
		 * - Consumer 인스턴스는 accept 메소드를 통해 자원을 소비하는 기능을 수행
		 * 
		 * 작동과정
		 * 1. friends 컬렉션에서 forEach 메소드 호출
		 * 2. forEach 메소드의 인자로 Consumer 인스턴스를 넘긴다.
		 * 3. 컬렉션의 각각의 엘리먼트에 대해서 Consumer 인스턴스의 accept 메소드 호출
		 * 4. accept 메소드 내용 수행
		 * 
		 * 아래와 같은 작업을 통해서 각각의 엘리먼트들을 어떻게 이터페이션하는지 보다
		 * 각각의 엘리먼트들이 수행해야 할 기능에 대해서만 집중이 가능해졌다.
		 */
		friends.forEach(new Consumer<String>() {

			@Override
			public void accept(String name) {
				// TODO Auto-generated method stub
				System.out.println(name);
			}
			
		});
		
		/**
		 * step4 어노니머스 이너 클래스를 람다 표현식으로 변환
		 * - forEach 메소드는 람다 표현식 호은 코드 블록을 인수로 받는 고차 함수이다.
		 * - 리스트에 있는 각 엘리먼트의 내용을 처리한다.
		 */
		friends.forEach((final String name)->System.out.println(name));
		
		/**
		 * step5 타입 정보가 없는 이전 코드
		 * - 자바 컴파일러는 변수 name에 저장되어 있는 내용을 보고 name 파라미터가
		 * 스트링(String) 타입이라는 것을 알 수 있다.
		 * 
		 */
		friends.forEach((name)->System.out.println(name));
		
		/**
		 * step6 괄호 생략
		 * - 싱글 파라미터 람다 표현식에서 파라미터의 타입을
		 * 추론할 수 있는 경우에는 파라미터 주변의 괄호를 생략할 수 있도록
		 * 자바 컴파일러가 처리한다.
		 * 
		 * 문제점
		 * final 사용을 하지 않아 수정이 발생할 수 있음.
		 */
		friends.forEach(name->System.out.println(name));
		
		/**
		 * step7 메소드 레퍼런스 사용
		 * - 자바에서는 코드의 본문을 우리가 선택한 메서드 이름으로 변경 가능함
		 */
		friends.forEach(System.out::println);
		
	}
}
