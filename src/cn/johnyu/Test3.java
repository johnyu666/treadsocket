package cn.johnyu;

import java.util.LinkedList;
import java.util.Queue;

public class Test3 {

	public static void main(String[] args) {
		Queue<String> base=new LinkedList<String>();
		new Thread(new Producer(base)).start();
		new Thread(new Consumer(base)).start();

	}
}
class Producer implements Runnable{
	private Queue<String> base;
	
	public Producer(Queue<String> base) {
		super();
		this.base = base;
	}

	@Override
	public void run() {
		
		while(true) {
			synchronized (base) {
				if(base.size()<3) {
					double d=Math.random();
					base.add(d+"");
					System.out.println("pro :\t"+d);
					base.notify();
				}
				else {
					try {
						base.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
		}
	}
}

class Consumer implements Runnable{
	private Queue<String> base;
	
	public Consumer(Queue<String> base) {
		super();
		this.base = base;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (base) {
				if(!base.isEmpty()) {
					String d=base.poll();
					System.out.println("consume :\t"+d);
					base.notify();
				}
				else {
					try {
						base.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
