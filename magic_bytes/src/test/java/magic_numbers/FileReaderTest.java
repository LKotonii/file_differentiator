package magic_numbers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import magic_numbers.file_reading.FileReader;
import magic_numbers.file_reading.SupportedExtension;

class FileReaderTest {

	@Test
	void magicNumbersOfFileTest() {
		// given 
		Path path = Paths.get("/Neuron.jpg");
		String neuron_jpg = "FFD8FFE000104A4649460001";
		
		// when 
		String s = FileReader.magicNumbersOfFile(path);
		
		//then
		assertEquals(s,neuron_jpg );
		
	}

	@Test
	void fileExtensionTest() {
		// given 
		String pdf = "something.pdf";
		
		// when 
		SupportedExtension ext = FileReader.fileExtension(pdf);
		
		assertNull(ext);
	}
	
	@Test
	void fileExtensionTestForSupportedExt() {
		// given 
		String gif = "something.gif";
		
		// when 
		SupportedExtension ext = FileReader.fileExtension(gif);
		
		assertEquals(ext, SupportedExtension.GIF);
	}
}
