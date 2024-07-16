package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//실습 : 테느워크상의 JSON 데이터(문자열)을 받아서 객체로 변환 후 출력
// https://jsonplaceholder.typicode.com/posts/1

public class GsonEx4 {
	
	public static void main(String[] args) throws Exception{
		
		// URI 객체 생성 후 URL로 연결
		String uriStr = "https://jsonplaceholder.typicode.com/posts/1";
		URL url = new URI(uriStr).toURL();
		URLConnection conn = url.openConnection();
		if(conn != null) {
			System.out.println("연결됨");
		}
		
		// BufferedReader 로 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String jsonStr = "";
		String line = "";
		while((line=br.readLine()) != null) {
			jsonStr += line;
			
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Post post = gson.fromJson(jsonStr, Post.class);
		System.out.println(post);
		
	} // main	

} // class
