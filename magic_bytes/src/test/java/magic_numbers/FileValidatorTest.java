package magic_numbers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import exceptions.ExtensionNotHandledException;
import magic_numbers.file_reading.FileValidator;

class FileValidatorTest {

	@Test
	void extensionIsTrueTest() throws ExtensionNotHandledException {
		// given 
		Path path = Paths.get("/home/rats/Documents/projects/magic_numbers/src/test/resources/testGif.gif");
		
		// when
		boolean validated = FileValidator.extensionIsTrue(path);
		// then 
		assertTrue(validated);
	
	}
	
	@Test
	void extensionIsFalseTest() throws ExtensionNotHandledException {
		Path path = Paths.get("/home/rats/Documents/projects/magic_numbers/src/test/resources/poem.txt.jpeg");
		// when
				boolean validated = FileValidator.extensionIsTrue(path);
				// then 
				assertFalse(validated);
	}
	

}
