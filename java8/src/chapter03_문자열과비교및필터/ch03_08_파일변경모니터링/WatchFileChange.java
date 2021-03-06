package chapter03_문자열과비교및필터.ch03_08_파일변경모니터링;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WatchFileChange {
	
	/**
	 * step1 현재 디렉터리에서 파일 변경을 살펴보는 예제
	 */
	public static void example1() throws IOException
	{
		final Path path = Paths.get(".");
		final WatchService watchService =
				path.getFileSystem()
					.newWatchService();
		
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		
		System.out.println("Report any file changed within next 1 minute...");
	}
	
	/**
	 * step2 와치 서비스(WatchService) 등록
	 * @throws InterruptedException 
	 */
	public static void example2() throws IOException, InterruptedException
	{
		final Path path = Paths.get(".");
		final WatchService watchService =
				path.getFileSystem()
					.newWatchService();
		
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		
		System.out.println("Report any file changed within next 1 minute...");
		final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
		
		if(watchKey != null)
		{
			watchKey.pollEvents()
					.stream()
					.forEach(event -> System.out.println(event.context()));
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		example2();
	}

}
