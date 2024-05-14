/*
 * IO 실습 1)
 * assets폴더에 이미지 파일 하나, 문자파일 하나를 준비  
 *  
 *  1. 사용자에게 1또는 2를 입력받는다.
 *  2. 사용자가 1을 입력하면 이미지파일을 복사해서 assets에 저장
 *  3. 사용자가 2을 입력하면 문자파일을 복사해서 assets에 저장
 *  * 파일명이 image.jpg > 복사한 파일명은 image_copy.jpg
 *  * 파일명이 text.txt > 복사한 파일명은 text_copy.txt
 *  
 */

package javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyer {

	public static void main(String[] args) {

		FileInputStream fis2 = null;
		FileOutputStream fos2 = null;

		FileWriter fw3 = null;
		FileReader fr2 = null;

		// 사용자에게 1 또는 2를 입력 받는다. (int로 하면 안되는가??)
		Scanner scanner = new Scanner(System.in);
		System.out.println("1이나 2를 입력해주세요!");
		String inputValue = scanner.next();

		if (inputValue.equals("1")) {
			// 이미지파일 복사
			try {
				fis2 = new FileInputStream("D:\\embeded\\git\\Javabasic\\src\\assets\\testimage.jpg");
				fos2 = new FileOutputStream("D:\\embeded\\git\\Javabasic\\src\\assets\\testimage_copy.jpg");

				byte[] readByte = new byte[1024];
				while (true) {
					int readCount = fis2.read(readByte);
					fos2.write(readByte);
					int readByteLeng = readByte.length;
					if (readCount < readByteLeng)
						break;
				}

			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			// 텍스트 파일 복사
		} else if (inputValue.equals("2")) {

			try {
				fr2 = new FileReader("D:\\embeded\\git\\Javabasic\\src\\assets\\testtxt.txt");
				fw3 = new FileWriter("D:\\embeded\\git\\Javabasic\\src\\assets\\testtxt_copy.txt");
				char[] readChars2 = new char[8];
				int readCount2 = 0;
				while ((readCount2 = fr2.read(readChars2)) > -1) {
					fw3.write(readChars2, 0, readCount2);
				}
				fw3.flush();
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					fw3.close();
					fr2.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}

	} // main

} // class
