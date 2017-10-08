package br.com.barcadero.adm.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionUtil {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("raimundo");
		list.add("joão");
		list.add("maria");
		list.add("Jose");
		list.add("Bruno");
		System.out.println(">>>>> list befor remove item raimundo <<<<<<");
		
		for (String string : list) {
			System.out.println(string);
		}
		
		list = removeItem(list, "raimundo");
		
		System.out.println(">>>>> list after remove item raimundo <<<<<<");
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	
	public static List<String> removeItem(List<String> list, Object toRemove) {
		for (Iterator<String> iter = list.listIterator(); iter.hasNext(); ) {
		    Object  object = iter.next();
		    if (object.equals(toRemove)) {
		        iter.remove();
		    }
		}
		return list;
	}
}
