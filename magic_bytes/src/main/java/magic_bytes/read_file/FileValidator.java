package magic_bytes.read_file;

import java.nio.file.Path;

import magic_bytes.exception.ExtensionNotHandledException;

public class FileValidator {
	public static boolean extensionIsTrue(Path path) throws ExtensionNotHandledException {

		SupportedExtension fileExt = FileReader.fileExtension(path.toString());

		if (fileExt != null) {
			for (String s : FileReader.defaultMagicNumbers(fileExt)) {
				if (FileReader.magicNumbersOfFile(path).startsWith(s)) {
					return true;
				}
			}
		} else {
			throw new ExtensionNotHandledException();

		}
		return false;
	}
}
