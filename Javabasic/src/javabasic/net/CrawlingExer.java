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
import java.util.ArrayList;
import java.util.List;

/*
 * 웹크롤링 실습) 
 * 개요 : 네이버 쇼핑에서 쌀에 대한 상품명, 판매가, 적립포인트를 크롤링해서 assets/rice.txt에 저장
 * 경로 : https://www.okjmall.com/goods/goods_list.php?cateCd=015	
 * 
 */

public class CrawlingExer {
	public static void main(String[] args) {
		
		URI uri = null;
		try {
			uri = new URI("https://www.okjmall.com/goods/goods_list.php?cateCd=015");
		} catch(URISyntaxException use) {
			use.printStackTrace();
		}
		
		URL url = null;
		try {
			url = uri.toURL();
		} catch(MalformedURLException mue) {
			mue.printStackTrace();
		}
		
		URLConnection conn = null;
		try {
			conn = url.openConnection();
			if(conn != null) {
				System.out.println("연결되었습니다.");
				System.out.println(conn);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		InputStream is = null;
		try {
			is = conn.getInputStream();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		BufferedWriter bw = null;
		File file = new File("D:\\embeded\\\\git\\Javabasic\\src\\assets\\rice.txt");
		
		String readedLine = null;
		try {
			List<ProductInfo> piList = new ArrayList<ProductInfo>();
			
			bw = new BufferedWriter(new FileWriter(file));
			
			while ((readedLine = br.readLine()) != null) {
				
				// 상품명
				String prodStartStr = "<strong class=\"item_name\">";
				int prodStartIndex = readedLine.indexOf(prodStartStr);
				int prodEndIndex = readedLine.indexOf("</strong>", prodStartIndex);
				String prodName = null;
				if(prodStartIndex > -1 && prodEndIndex > -1) {
					prodName = readedLine.substring(prodStartIndex + prodStartStr.length(), prodEndIndex);
					bw.write(prodName);
					bw.write('\n');
				}
					
				 
				// 가격추출					
				String priceStartStr = "<span  style=\"\">";
				int priceStartIndex = readedLine.indexOf(priceStartStr);
				int priceEndIndex = readedLine.indexOf(" </span>", priceStartIndex);
				String prodPrice = null;
				if(priceStartIndex > -1 && priceEndIndex > -1) {
					prodPrice = readedLine.substring(priceStartIndex + priceStartStr.length(), priceEndIndex);
					bw.write(prodPrice);
					bw.write('\n');
				}
				
				// 마일리지					
				String pointStartStr = "\" alt=\"마일리지\" title=\"마일리지\" />";
				int pointStartIndex = readedLine.indexOf(pointStartStr);
				int pointEndIndex = readedLine.indexOf("원", pointStartIndex);
				String prodPoint = null;
				if(pointStartIndex > -1 && pointEndIndex > -1) {
					prodPoint = readedLine.substring(pointStartIndex + pointStartStr.length(), pointEndIndex);
					bw.write(prodPoint);
					bw.write('\n');
				}
				
//				piList.add(new ProductInfo(prodName,
//											Integer.parseInt(prodPrice),
//											Integer.parseInt(prodPoint)));
				
//				bw.write(readedLine.trim() + "\n");
			
			if(prodName != null && prodPrice != null && prodPoint != null) {
				prodPrice = prodPrice.replace(",", "");
				prodPoint = prodPoint.replace(",", "");
				piList.add(new ProductInfo(prodName,
						Integer.parseInt(prodPrice),
						Integer.parseInt(prodPoint))
						);
				prodName = null;
				prodPrice = null;
				prodPoint = null;
				
			}
			}
			
			
			bw.flush();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		//System.out.println(((String)bw).substring(6, 13));

	
	} // main

} // class
