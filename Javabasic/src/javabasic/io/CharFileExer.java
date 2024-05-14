package javabasic.io;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFileExer {

	public static void main(String[] args) {

		FileWriter fw = null;
		FileWriter fw2 = null;
		FileReader fr = null;

		try {
			fw = new FileWriter("D:\\embeded\\git\\Javabasic\\src\\assets\\diary.txt");
			fr = new FileReader("D:\\embeded\\git\\Javabasic\\src\\assets\\diary.txt");
			fw2 = new FileWriter("D:\\embeded\\git\\Javabasic\\src\\assets\\diary_copy.txt");
			fw.write("5월 10일 일기 \n\n 오늘도 열심히 공부했다? \n\n 내일은 수원갔다가 부평갔다가 바쁘것구만 \n\n 다음주는 좀 쉴 수 있겠지.....");
			fw.flush();
			char[] readChars = new char[8];
			int readCount = 0;
			while ((readCount = fr.read(readChars, 0, readChars.length)) > -1) {
				fw2.write(readChars, 0, readCount);
			} 
			fw2.flush();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw2.close();
				fr.close();
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	} // main

} // class
