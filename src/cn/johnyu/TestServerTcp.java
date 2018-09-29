package cn.johnyu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerTcp {

	public static void main(String[] args) throws Exception{
		ServerSocket server=new ServerSocket(9000);
		//thread block
		Socket socket=server.accept();
		InputStream in=socket.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		OutputStream out=socket.getOutputStream();
		//thread block
		String line=reader.readLine();
		out.write("I am Server!\n".getBytes());
		
		System.out.println(line);
		
		in.close();
		socket.close();
		server.close();

	}

}
