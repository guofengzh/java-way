package fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		OutputStream output = null ;
		try {
			output = new FileOutputStream("output-text.txt");
			
			int i = 0;
			while (i++ < 10) {
				int data = getMoreData();
				output.write(data);
			}
		} finally {
			if (output != null )
				output.close(); 
		}
	}

	private static int getMoreData() {
		return 'A';
	}
}
