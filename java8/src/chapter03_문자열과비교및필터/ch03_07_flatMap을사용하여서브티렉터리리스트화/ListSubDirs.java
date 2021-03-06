package chapter03_문자열과비교및필터.ch03_07_flatMap을사용하여서브티렉터리리스트화;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSubDirs {
	
	/**
	 * step1 for문을 사용한 서브 디렉터리 리스트화
	 * - 서브 디렉터리가 파일을 포함하고 있따면, 그 파일들을 리스트에 추가
	 * - 서브 디렉터리가 파일을 포함하고 있지 않다면 서브 디렉터리 자체를 추가함
	 * - 마지막으로 전체 파일의 수를 출력함
	 * 
	 * 문제점
	 * 1. 가변성을 갖고 있음
	 * 2. 코딩 스타일이 명령적
	 */
	public static void example1() throws IOException
	{
		List<File> files = new ArrayList<File>();
		
		File[] filesInCurrentDir = new File(".").listFiles();
		
		for(File file : filesInCurrentDir)
		{
			File[] filesInSubDir = file.listFiles();
			if(filesInSubDir!=null)
			{
				files.addAll(Arrays.asList(filesInSubDir));
			}
			else
			{
				files.add(file);
			}
		}
		
		System.out.println("Count : " + files.size());
	}
	
	/**
	 * step2 flatMap() 메서드를 사용하여 서브 디렉터리안에 파일 탐색
	 * 1. 주어진 파일을 위한 자식의 스트림을 리턴하는 람다 표현식을 이 메서드에 파라미터로 전달했다.
	 * 2. flatMap()은 현재 디렉터리의 서브 디렉터리의 모든 자식에 대한 컬렉션의 플랫된 맵을 리턴한다.
	 * 3. flatMap()은 많은 노력을 제거해주며 단항 조합이라고 하는 두 개의 오퍼레이션의 순서를 하나의
	 * 과정으로 조합해준다.
	 */
	public static void example2() throws IOException
	{
		List<File> files =
				Stream.of(new File(".").listFiles())
					.flatMap(file -> file.listFiles() == null ?
								Stream.of(file) : Stream.of(file.listFiles()))
					.collect(Collectors.toList());
		System.out.println("Count: " + files.size());
					
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		example1();
	}

}
