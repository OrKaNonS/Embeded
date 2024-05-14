package javabasic.net.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChattingServer {
	
	// 클라이언트핸들러 리스트 = 클라이언트 소켓 리스트 = 클라이언트 송/수신 리스트
	private static List<ClientHandler> clients = new ArrayList<ClientHandler>(); // 클라이언트 목록 역할_누구누구 있는지 알아야 서버에서 받은 메시지를 전해줄 수 있음.
	
	public static void main(String[] args) throws IOException {
		
		// 서버소켓객체를 6666번 포트로 생성		
		ServerSocket serverSocket = new ServerSocket(6666);
		if(serverSocket != null) {
			System.out.println("서버 시작됨! 클라이언트 대기중!");
		}
		
		//무한히 블랑킹(accept) => accept는 접속요청이 오면 블락킹을 중지
		while(true) {
			//접속요청이 오면 클라이언트와 송수신 할 소켓이 생김
			Socket clientCommSocket = serverSocket.accept();
			System.out.println("클라이언트 접속 : " + clientCommSocket);
			
			// 클라이언트핸들러 생성(서버의 소켓과 클라이언트가 필요)
			ClientHandler clientHandler = new ClientHandler(clientCommSocket, clients);
			// 클라이언트 리스트에 클라이언트 저장
			clients.add(clientHandler);
			// 클라이언트핸들러 스레드 시작 = 송수신 시작
			new Thread(clientHandler).start();
		}
		
		
		
	} // main

} // class
