package cn.com.myproject.qd;

/**
 *
 *@author xx
 *@date 2022/9/14 13:21
 **/
public class StringMax {

	private String str;

	public void s (String str) {
		this.str = str;
	}

	public static void main(String[] args) {

		printMem();
		String str1 = "";
		for (int i = 0; i < 100000; i++) {
			str1 = str1 + i;
		}
		//System.out.println(str1);
		printMem();
		System.out.println("--------------------------------");
		StringMax max = new StringMax();
		max.s(str1);
		//System.out.println(max.str);
		printMem();
		System.out.println("--------------------------------");

		String str2 = max.str;
		System.out.println("--------------------------------");
		printMem();
		//System.out.println(str2);
	}

	public static void printMem() {
		//当前JVM占用的内存总数(M)
		double total = (Runtime.getRuntime().totalMemory()) / (1024.0 * 1024);

		//JVM最大可用内存总数(M)

		double max = (Runtime.getRuntime().maxMemory()) / (1024.0 * 1024);

		//JVM空闲内存(M)

		double free = (Runtime.getRuntime().freeMemory()) / (1024.0 * 1024);

		//可用内存内存(M)

		double mayuse=(max - total + free);

		//已经使用内存(M)

		double used = (total-free);
		System.out.println("Total :" + total + " used :" + used);
	}
}
