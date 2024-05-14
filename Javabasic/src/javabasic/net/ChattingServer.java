package javabasic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer {

	public static final int SERVERSOCKET_PORT = 6666;

	public static void main(String[] args) {

		// cmd 에서 netstat -na 로 사용중인 포트 확인 가능

		ServerSocket ss = null;
		try {
			ss = new ServerSocket(SERVERSOCKET_PORT); // 6666는 포트 번호(0~1024는 지정X)
			if (ss != null) {
				System.out.println("ServerSocket 생성됨");
			}
			if (true) {
				Socket svSocket = ss.accept(); // 블락킹 메소드_ accept이 되야 이후 서버에서 Server측 Socket을 만든다. 즉 서버에서 계속 대기하고 있음.
				if (svSocket != null) {
					System.out.println("서버 측 Socket 생성됨! : " + svSocket);
				}
//				InputStream is = svSocket.getInputStream();
//				BufferedReader br = new BufferedReader(new InputStreamReader(is));
//				System.out.println(br.readLine());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
