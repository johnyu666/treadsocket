package cn.johnyu;

public class Test2 {

	public static void main(String[] args) {
		//Thread t=new MyThread();
		//t.run();
		new Thread(new MyThread()).start();
		while(true) {
			System.out.println(Thread.currentThread().getName()+"88888888888888888");
		}

	}
}

class MyThread extends Object implements Runnable{
	@Override
	public void run() {
		while(true)
		System.out.println(Thread.currentThread().getName()+"....");
	}
}
