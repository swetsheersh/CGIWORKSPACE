package assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Assig_10 {
	//method
	public static boolean checkpos(String str) {
		str=str.toUpperCase();
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<str.length();i++) {
			Character ch=new Character(str.charAt(i));
			if(list.size()==0) {
				list.add(ch.hashCode());
			}
			else if(Collections.max(list)<ch.hashCode()) {
				list.add(ch.hashCode());
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		String str="AbcDeFghijklmnopqrstuvwxyzaas";
		System.out.println(checkpos(str));
		
	}
}
