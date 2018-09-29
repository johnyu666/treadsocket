package cn.johnyu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test1 {

	public static void main(String[] args) throws Exception{
//		OutputStream out=new FileOutputStream("abc.txt");
//		
//		out.write("a中国".getBytes(),0,2);
//		out.close();
//		
//		InputStream in=new FileInputStream("abc.txt");
//		int m=in.read();
//		System.out.println((char)m);
//		in.close();
//		
//		InputStream in=new FileInputStream("aa.pptx");
//		OutputStream out=new FileOutputStream("bb.pptx");
//		byte[] buf=new byte[in.available()];
//		in.read(buf);
//		out.write(buf);
//		int b=0;
//		while((b=in.read())!=-1) {
//			out.write(b);
//		}
		
//		long start=System.currentTimeMillis();
//		byte[] buf=new byte[64];
//		int len=0;
//		while((len=in.read(buf))!=-1) {
//			out.write(buf,0,len);
//		}
//		long end=System.currentTimeMillis();
//		System.out.println("cost:"+(end-start));
		
		
		
		BufferedInputStream bin=new BufferedInputStream(new FileInputStream("aa.pptx"),1024);
		BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream("cc.pptx"),1024);
		int b=0;
		long start=System.currentTimeMillis();
		while((b=bin.read())!=-1) {
			bout.write(b);
		}
		long end=System.currentTimeMillis();
		System.out.println("cost:"+(end-start));
		bin.close();
		bout.close();
		
		

	}

}










