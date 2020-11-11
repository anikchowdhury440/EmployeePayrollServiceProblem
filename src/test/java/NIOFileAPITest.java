import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {
	private static String PATH = "C:\\Users\\Anik Chowdhury\\Desktop\\Fellowship\\TestFileIO";
	private static String DIRECTORY = "TempFile";
	private static String DIRECTORY2 = "TempFile2";
	
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		
		//Check File Exists
		Path filePath = Paths.get(PATH);
		Assert.assertTrue(Files.exists(filePath));
		
		//Delete File and Check File Not Exist
		Path playPath = Paths.get(PATH + "\\" + DIRECTORY);
		if(Files.exists(playPath)) {
			FileUtils.deleteFiles(playPath.toFile());
		}
		Assert.assertTrue(Files.notExists(playPath));
		
		//Create Directory
		Files.createDirectories(playPath);
		Assert.assertTrue(Files.exists(filePath));
		
		//Create Files
		IntStream.range(1,10).forEach(num -> {
			Path tempFile = Paths.get(playPath + "\\temp" + num);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			}
			catch (IOException e){}
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		//List Files, Directories as well as files with extension
		Files.newDirectoryStream(playPath).forEach(System.out::println);
	}
	
	@Test
	public void givenDirectoryWhenWatchedListsAllTheActivities() throws IOException {
		Path dir = Paths.get(PATH + "\\" + DIRECTORY2);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new Java8WatchServiceExample(dir).processEvents();
	}
}
