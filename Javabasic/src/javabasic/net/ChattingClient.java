package javabasic.net;

 
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChattingClient { // 서버클라이언트 모델 _ 소켓이 있어야 한다.
	
	public static void main(String[] args) {
		
		Socket s = null; 
		try {
			s = new Socket("192.168.8.13", 9999); // 통신을 위해선 IP와 포트가 필요
//			s = new Socket("192.168.8.12", 4444); // localhost == 192.168.8.12
//			s = new Socket("127.0.0.1", 4444); // 누구나 가지고 있는 기본 IP
			if(s != null) {
				System.out.println("채팅서버에 연결되었습니다!" + s);
//				OutputStream os = s.getOutputStream(); // 문자 보내는 OutputStream
//				OutputStreamWriter osw = new OutputStreamWriter(os);
//				osw.write("Hello~ I'm realchoky~~~");
//				osw.flush();
				
		}
		} catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		
		
		
	} // main

} // class
