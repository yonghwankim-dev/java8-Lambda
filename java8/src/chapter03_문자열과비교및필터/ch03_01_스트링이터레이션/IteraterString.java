package chapter03_문자열과비교및필터.ch03_01_스트링이터레이션;

public class IteraterString {
	public static void main(String args[])
	{
		/**
		 * step1 컨비니언트 인터널 이터레이터(Convenient Internal Iterator)를 사용하여
		 * 		스트링을 구성하는 개별적 문자들에 대해 오퍼레이션을 적용
		 * chars() 메서드는 forEach() 내부 이터레이터를 사용하여 이터레이션하는 스트림을 리턴한다.
		 * 
		 * 아래의 결과는 기대와는 달리 숫자로 출력된다. 이유는 chars() 메서드가 Characters의 스트림
		 * 대신 문자를 표현하는 int의 스트림을 리턴했기 때문이다. 
		 */
		final String str = "w00t";
		str.chars().forEach(ch -> System.out.println(ch)); // output 119 48 48 116
		
		/**
		 * step2 메서드 래퍼런스를 통한 문자 출력
		 * 인스턴스 메서드 -> name.toUpperCase()
		 * 메서드 레퍼런스 -> String::toUpperCase
		 * 
		 * String::toUppercase는 합성되는 메서드에 대한 파라미터이며,
		 * 이 메서드는 메서드 호출의 타깃으로 변환된다.
		 * 
		 * parameter.toUppercase();와 같다.
		 * 위와 같이 가능한 이유는 메서드 레퍼런스가 클래스 이름(String)을
		 * 기반으로 하기 때문임
		 */
		str.chars().forEach(System.out::println);
		
		/**
		 * step3-2 메서드 레퍼런스 printChar 호출
		 */
		str.chars().forEach(IteraterString::printChar);
		
		/**
		 * step4 처음부터 int가 아닌 문자로 처리하고 싶은 경우
		 * 1. 스트림에서 제공하는 메서드를 이용하여 스트링에 있는 문자들을 처리할 수 있다.
		 * 2. 예를들어 map(), filter(), reduce() 등이 있다.
		 */
		str.chars()
			.mapToObj(ch -> Character.valueOf((char)ch))
			.forEach(System.out::println);
		System.out.println();
		
		/**
		 * step5 스트링에서 숫자(digit)로 필터링
		 * 1. 스트림에서 제공하는 메서드를 이용하여 스트링에 있는 문자들을 처리 가능함
		 * 2. 문자열에서 숫자만 필터링하여 문자로 출력한다.
		 */
		str.chars()
			.filter(ch -> Character.isDigit(ch))
			.forEach(ch -> printChar(ch));
		System.out.println();
		
		/**
		 * step6 step5의 코드를 메서드 레퍼런스로 변경하여 적용
		 * 1. filter 메서드와 forEach() 메서드에 전달하는 
		 * 람다 표현식 대신 각 메서드에 대한 레퍼런스를 사용할 수 있다. 
		 * 2. 메서드 레퍼런스는 일반적인 파라미터 라우팅을 제거하도록 해준다.
		 * 
		 * 3. 자바 컴파일러는 메서드가 인스턴스 메서드인지 아니면 정적 메서드인지
		 * 확인한다.
		 * 3.1. 인스턴스 메소드 -> 합성된 메서드의 파라미터는 호출하는 타깃이 됨
		 * (paramter.toUppercase())
		 * 3.2. 메서드가 정적 메서드이면 합성된 메서드에 대한 파라미터는 
		 * 이 메서드의 인수로 라우팅된다. (Character.isDigit(paramter))
		 * 
		 */
		str.chars()
			.filter(Character::isDigit)
			.forEach(IteraterString::printChar);
	}
	/**
	 * step3-1 컨비니언스 메서드(Convenience Method)를 사용해서
	 * 		int를 문자로 출력하는 코드를 작성
	 */
	public static void printChar(int aChar)
	{
		System.out.println((char)(aChar));
	}
}
