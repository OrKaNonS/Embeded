package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

public class GsonEx6 {
	
	public static void main(String[] args) throws Exception{
		
		// URI 객체 생성 후 URL로 연결
				String uriStr = "https://apis.data.go.kr/B490007/hrdkapi/NCS001?serviceKey=zdcLWo1S7NHYWqvcfEoiha9REwwXCbFApvxzGS7jvyb72D3x4UASxWn3uKv%2FcVa2aEkk5Yc8X2mwsBAlN2GvKQ%3D%3D&pageNo=1&numOfRows=10&USG_YN=N&NCS_DEGR=22&NCS_LCLAS_CD=04";
				URL url = new URI(uriStr).toURL();
				URLConnection conn = url.openConnection();
				if(conn != null) {
//					System.out.println("연결됨");
				}
				
				// BufferedReader 로 읽어오기
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String jsonStr = "";
				String line = "";
				while((line=br.readLine()) != null) {
					jsonStr += line;					
				}
				System.out.println(jsonStr);
				
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				Map<String, Object> jsonmap = gson.fromJson(jsonStr, Map.class);
				System.out.println(jsonmap);
				Map<String, Object> response = (Map<String, Object>)jsonmap.get("response");
				System.out.println(response);
				Map<String, Object> body = (Map<String, Object>)response.get("body");
				System.out.println(body);
				Map<String, Object> items = (Map<String, Object>)body.get("items");
				System.out.println(items);
				List<Object> item = (List<Object>)items.get("item");
				Map<String, Object> itemMap = (Map<String, Object>)item.get(0);
				System.out.println(itemMap.get("NCS_LCLAS_CD"));
				System.out.println(itemMap.get("NCS_LCLAS_CDNM"));
				System.out.println(itemMap.get("NCS_DEGR"));
				System.out.println(itemMap.get("USG_YN"));
				
				
//					System.out.println("이름 : " + human.getName());
//					System.out.println("나이 : " + human.getAge());
//					}
//				}
		
	} // main

} // class
