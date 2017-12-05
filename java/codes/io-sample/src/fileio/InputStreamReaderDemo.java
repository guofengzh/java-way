package fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("input-utf-8.txt");
		try (Reader inputStreamReader = new InputStreamReader(inputStream, "UTF-8")) {

			int data = inputStreamReader.read();
			while (data != -1) {
				doSomethingWithData(data);
				data = inputStreamReader.read();
			}
		}
	}

	private static void doSomethingWithData(int data) {
		System.out.print((char) data);
	}
}
