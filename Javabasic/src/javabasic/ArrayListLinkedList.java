package javabasic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedList {

	public static void main(String[] args) {

		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();

		long alStartTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			al.add("ArrayList" + i);
		}
		long alEndtime = System.currentTimeMillis();

		long alStartTime2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			System.out.println(al.get(i));
		}
		long alEndtime2 = System.currentTimeMillis();

		long llStartTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			ll.add("LinkedList" + i);
		}
		long llEndtime = System.currentTimeMillis();

		long llStartTime2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			ll.add("LinkedList" + i);
			System.out.println(ll.get(i));
		}
		long llEndtime2 = System.currentTimeMillis();

		System.out.println("ArrayList add : " + (alEndtime - alStartTime));
		System.out.println("ArrayList get : " + (alEndtime2 - alStartTime2));
		System.out.println("LinkedList add : " + (llEndtime - llStartTime));
		System.out.println("LinkedList get : " + (llEndtime2 - llStartTime2));

	}

}
