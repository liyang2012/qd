package cn.com.myproject.qd;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *@author xx
 *@date 2022/9/13 13:25
 **/
public class Test1 {
	public static AtomicInteger num = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = () -> {
			for (int i = 0; i < 200000000; i++) {
				num.getAndAdd(1);
			}
		};

		Thread t1 = new Thread(runnable, "1:");
		Thread t2 = new Thread(runnable, "2:");

		t1.start();
		t2.start();

		System.out.println("主线程开始睡觉了......");
		Thread.sleep(1000);
		System.out.println("主线程睡醒了......");
		System.out.println("主线程打印num: " + num);
	}
}
