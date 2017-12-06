package tcp.echo;

import java.net.*;
import java.io.*;

class MyClient {
	public static void main(String args[]) throws Exception {
		Socket s = new Socket("localhost", 3333);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		String str = "", str2 = "";
		while (!str.equals("stop")) {
			str = console.readLine();
			dout.writeUTF(str);
			dout.flush();
			str2 = din.readUTF();
			System.out.println("Server says: " + str2);
		}

		dout.close();
		s.close();
	}
}