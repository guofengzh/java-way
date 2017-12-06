package tcp.mthread;

import java.io.*;
import java.net.*;

public class ServerThread implements Runnable {
	Socket s = null;
	DataInputStream din;
	DataOutputStream dout;
	BufferedReader console;

	public ServerThread(Socket s) throws IOException {
		this.s = s;
		din = new DataInputStream(s.getInputStream());
		dout = new DataOutputStream(s.getOutputStream());
		console = new BufferedReader(new InputStreamReader(System.in));
	}

	public void run() {
		try {
			String str = "", str2 = "";
			while (!str.equals("stop")) {
				str = din.readUTF();
				System.out.println("client says: " + str);
				str2 = console.readLine();
				dout.writeUTF(str2);
				dout.flush();
			}
			din.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
