package javabasic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystemNotFoundException;

public class ObjectExer {

	public static void main(String[] args) {

		Person hong = new Person("홍길동", 20, "123456-7890123");
		Person kang = new Person("강감찬", 30, "987654-3210987");

		File file = null;
		FileOutputStream fos = null; // 파일을 쓰는 스트림
		ObjectOutputStream oos = null; // 객체를 내보내는 스트림
		FileInputStream fis = null; // 파일을 읽는 스트림
		ObjectInputStream ois = null; // 파일을 받는 스트림

		try {
			file = new File("D:\\embeded\\git\\Javabasic\\src\\assets\\object.dat");
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(hong); // write Object 직렬화 메소드
			oos.writeObject(kang); // write Object 직렬화 메소드

			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			Object hongObj = ois.readObject(); // readObject 역직렬화 메소드
			Object kangObj = ois.readObject(); // readObject 역직렬화 메소드
			
			Person readHong = (Person)hongObj; // hongObj는 Object 타입으로 원래 타입인Person으로 바꾸기
			Person readKang = (Person)kangObj; // hongObj는 Object 타입으로 원래 타입인Person으로 바꾸기
			System.out.println(readHong);
			System.out.println(readKang);

		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (FileSystemNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
