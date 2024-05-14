package javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileExer {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("D:\\embeded\\git\\Javabasic\\src\\assets\\food.jpg");
			fos = new FileOutputStream("D:\\embeded\\git\\Javabasic\\src\\assets\\food_copy.jpg");

			byte[] readByte = new byte[1024];
			while (true) {
				int readCount = fis.read(readByte);
				fos.write(readByte);
				int readByteLeng = readByte.length;
				if (readCount < readByteLeng)
					break;

			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
