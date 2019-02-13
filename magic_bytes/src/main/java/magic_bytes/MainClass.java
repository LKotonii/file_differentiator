package magic_bytes;

import java.nio.file.Path;
import java.nio.file.Paths;

import magic_bytes.exception.ExtensionNotHandledException;
import magic_bytes.read_file.FileReader;
import magic_bytes.read_file.FileValidator;
import magic_bytes.read_file.SupportedExtension;

public class MainClass {

	static void readFile(Path path) throws ExtensionNotHandledException {
		if (FileValidator.extensionIsTrue(path)) {
			System.out.print("The declared extension and actual extension are same");
		} else {
			String s = path.toString();
			StringBuilder declaredExtension = new StringBuilder("");
			int dot = s.lastIndexOf('.');
			for (int i = dot; i < s.length(); i++) {
				declaredExtension.append(s.charAt(i));
			}
			SupportedExtension ext = null;
			try {
				ext = FileReader.fileExtension(s);
			} catch (Exception exc) {
				exc.getLocalizedMessage();
			}
			if (ext != null) {
				System.out.println("Declared Extension is: " + declaredExtension + ", but real extension is: " + ext);
			} else {
				System.out.println("Unhandled extension");
			}
		}
	}

	public static void main(String[] args) {

		try {
			readFile(Paths.get("/src/test/resources/poem.txt.jpg"));
		} catch (ExtensionNotHandledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
