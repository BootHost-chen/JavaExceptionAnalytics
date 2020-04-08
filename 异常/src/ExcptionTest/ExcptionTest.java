package ExcptionTest;

import Excption.log;

public class ExcptionTest {
	public static void main(String[] args) {
		log log=new log();
		String[] a=null;
		int b=10;
		try {
			for (String string : a) {
				System.out.println(string);
			}
			System.out.println(b%0);
		} catch (Exception e) {
			log.setout(e);
			System.out.println(e);
		}
			

	}
}
