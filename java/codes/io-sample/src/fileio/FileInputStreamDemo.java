package fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		InputStream input = null;
		try {
			input = new FileInputStream("input-text.txt");

			int data = input.read();
			while (data != -1) {
				doSomethingWithData(data);

				data = input.read();
			}
		} finally {
			if (input != null)
				input.close();
		}

	}

	private static void doSomethingWithData(int data) {
		System.out.print((char)data);
	}
}
