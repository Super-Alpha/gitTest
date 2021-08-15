package test_package;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Arrays;


public class Animal{
    
    public static void main(String[] args) {
        
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	arrayList.add(1);
    	
    	LinkedList<String> linkedList = new LinkedList<String>();
    	linkedList.add("abc");
    	
    	HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(1);
        hashSet.add(1);
        
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("China", 80);
        
        Integer str1=123;
        Integer str2=123;
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        
        Cat c1 = new Cat("ÍõÀÚ");
        Cat c2 = new Cat("ÍõÀÚ");
        System.out.println(c1.equals(c2)); // false
    }
}




























