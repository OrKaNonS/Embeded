package javabasic.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URLExer {
	public static void main(String[] args) {

		// URI 객체 생성
		URI uri = null;
		try {
			uri = new URI("https://www.google.com");
		} catch (URISyntaxException use) {
			use.printStackTrace();
		}

		// URL로 변경
		URL url = null;
		try {
			url = uri.toURL();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}
		URLConnection conn = null;
		try {
			conn = url.openConnection();
			if (conn != null) {
				System.out.println("연결되었습니다!");
				System.out.println(conn);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		InputStream is = null;
		try {
			is = conn.getInputStream();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(is));	
		BufferedWriter bw = null;
		File file = new File("D:\\embeded\\\\git\\Javabasic\\src\\assets\\google0513.txt");



		String readedLine = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			while ((readedLine = br.readLine()) != null) {
				bw.write(readedLine + "\n");
				// System.out.println(readedLine);
				// assets/google0513.txt파일로 저장해보자

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
