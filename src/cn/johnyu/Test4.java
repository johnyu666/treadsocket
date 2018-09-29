package cn.johnyu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Test4 {
	//client
	public static void main(String[] args) throws Exception{
		InetAddress addr=InetAddress.getByName("127.0.0.1");
		
		Socket sk=new Socket(addr,9000);
		OutputStream out=sk.getOutputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(sk.getInputStream(), "UTF-8"));
		
		out.write("Hello World!\n".getBytes());
		System.out.println(reader.readLine());
		out.close();
		sk.close();
		
	}

}
