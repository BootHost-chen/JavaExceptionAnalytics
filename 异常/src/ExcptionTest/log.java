package ExcptionTest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class log {
	public static void setout(Exception exception) {
//		String Linux = "Linux";// 系统类型1
//		String Windows = "Windows";// 系统类型2
		String os_name = System.getProperty("os.name");// 获取当前操作系统
		String exctpion_String;// 过度字符串

		Date date = new Date();// 创建时间实例
		SimpleDateFormat sDateFormat = new SimpleDateFormat();// 创建时间格式实例
		sDateFormat.applyPattern("yyyy-MM--dd HH:mm:ss a");// 设置当前时间格式

		StringWriter sWriter = new StringWriter();// 创建String Writer将得到的异常信息放入自己的缓存区
		File file = new File("log.log");// log文件路径
		FileOutputStream fileOutputStream = null;// ouputStream输出对象
		BufferedOutputStream bufferedOutputStream = null;// 缓存区输出对象
		byte[] b;// 缓存区
		exception.printStackTrace(new PrintWriter(sWriter));// 获取异常信息放入sWriter中
		exctpion_String = exception.getStackTrace()[0].getClassName() + ".java\n" + sDateFormat.format(date) + "\n"
				+ sWriter.toString() + "\n\n";
		b = exctpion_String.getBytes();// 将整合后的异常信息放入缓存区

		System.out.println("操作系统为" + os_name);

		try {
			fileOutputStream = new FileOutputStream(file, true);// 将log地址放入，并且设置为追加
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);// 将outputStream对象放入BufferedOutputSream
			bufferedOutputStream.write(b);// 写入
			bufferedOutputStream.flush();// 更新
			System.out.println("操作成功");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
//	public static void main(String[] args) {
//		log.setout();
//	}
}
