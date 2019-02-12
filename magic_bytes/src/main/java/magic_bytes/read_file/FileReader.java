package magic_bytes.read_file;

import java.util.ArrayList;
import java.util.List;

public class FileReader {
	
	// method returns list of all possible hexadecimal signature for SupportedExtension
	static List<String> defaultMagicNumbers(SupportedExtension fileExtension) {
		ArrayList<String> magicNumbers = new ArrayList<>();
		switch (fileExtension) {
		case GIF:
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
}
