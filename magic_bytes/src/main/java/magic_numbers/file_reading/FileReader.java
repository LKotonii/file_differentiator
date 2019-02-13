package magic_numbers.file_reading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

	public static List<String> defaultMagicNumbers(SupportedExtension fileExtension) {
		ArrayList<String> magicNumbers = new ArrayList<>();
		switch (fileExtension) {
		case GIF:
			// add hexadecimal 
			magicNumbers.add("474946383961");
			magicNumbers.add("474946383761");
			break;
		case JPG:
			magicNumbers.add("FFD8FFDB");
			magicNumbers.add("FFD8FFE000104A4649460001");
			magicNumbers.add("FFD8FFEE");
			magicNumbers.add("FFD8FFE1????457869660000");
			break;
		case TXT:
			magicNumbers.add("EFBBBF");
			break;
		}
		return magicNumbers;
	}

	public static SupportedExtension fileExtension(String filename) {
		char[] chars = filename.toCharArray();
		StringBuilder extension = new StringBuilder("");
		// we need to get all chars after the last occurence of the dot in the filename which will be declared file extension
		for (int i = chars.length - 1; i > 1; i--) {
			if (chars[i] == '.') {
				break;
			} else
				extension.append(chars[i]);
		}
		switch (extension.toString()) {
		
		case "fig":
			return SupportedExtension.GIF;
		case "txt":
			return SupportedExtension.TXT;
		case "gpj":
			return SupportedExtension.JPG;
		case "gepj":
			return SupportedExtension.JPG;
		}
		return null;
	}

	public static String magicNumbersOfFile(Path filePath) {
		
		StringBuilder st = new StringBuilder("");
		try {
			byte[] bytes = Files.readAllBytes(filePath);
			for (int i = 0; i < 12; i++) {
				st.append(String.format("%02X", bytes[i]));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st.toString();
	}

}
