package tcp.mthread;

import java.net.*;
import java.io.*;
import java.util.*;

public class MyServer
{
	public static void main(String[] args)
		throws IOException
	{
		ServerSocket ss = new ServerSocket(3333);
		while(true)
		{
			Socket s = ss.accept();
			new Thread(new ServerThread(s)).start();
		}
	}
}
