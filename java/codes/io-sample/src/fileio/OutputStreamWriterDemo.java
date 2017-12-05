package fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	private static final String txt = 
			"我所思兮在太山。\r\n" + 
			"欲往从之梁父艰，侧身东望涕沾翰。\r\n" + 
			"美人赠我金错刀，何以报之英琼瑶。\r\n" + 
			"路远莫致倚逍遥，何为怀忧心烦劳。" ;
	
 	public static void main(String[] args) throws IOException {
		OutputStream outputStream = new FileOutputStream("output-utf8.txt");

		try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8")) {
		    outputStreamWriter.write(txt);
		}
	}
}
