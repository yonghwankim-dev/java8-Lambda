package chapter03_문자열과비교및필터.ch03_06_디렉터리에서선택한파일리스트화;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListSelectFiles {
	
	/**
	 * step1 현재 디렉터리에 존재하는 모든 파일의 이름에 대한 리스트를 출력하는 코드
	 * 1. Paths.get 메서드를 사용해서 Path 인스턴스 생성
	 * 2. list 메서드를 사용해서 주어진 path 안에 있는 파일들을 이터레이션하기
	 * 위해 새로운 CloseableStream을 얻어온다.
	 * 3. forEach를 사용하여 파일 이름을 출력
	 * @throws IOException
	 */
	public static void example1() throws IOException
	{
		Files.list(Paths.get("."))
				.forEach(System.out::println);
	}
	
	/**
	 * step2 모든 파일의 리스타가 아닌 현재 디렉터리에 있는 서브 디렉터리만 보고 싶은 경우 (filter 메서드 사용)
	 * 1. filter 메서드는 파일 스트림에서 디렉터리만 추출
	 * 2. Files 클래스의 isDirectory 메소드 레퍼런스를 제공
	 * 3. filter 메소드의 리턴 타입은 Predicate 클래스 타입
	 * @throws IOException
	 */
	public static void example2() throws IOException
	{
		Files.list(Paths.get("."))
				.filter(Files::isDirectory)
				.forEach(System.out::println);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		example1();
		example2();
	}

}
