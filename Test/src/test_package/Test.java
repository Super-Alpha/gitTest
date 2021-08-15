package test_package;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import BST.BinarySortTreeDemo;
import java.util.ArrayList;
import java.util.*;

public class Test extends Demo{
	
	
	public Test(String string,int id) {
		super(string, id);
		super.eat();
		this.eat();
	}
	
	
	public void eat() {
		System.out.print(true);
	}
	
	
	public static void main(String[] args){
//		ArrayList<String> arrayList = new ArrayList<String>();
//		arrayList.add(0, "str1");
//		arrayList.add(1, "str2");
		String string_1 = "123";
		String string_2 = "123";
		String string_3 = "234";
		Demo demo = new Demo("www", 12);
		Demo demo2 = new Demo("www", 12);
		
		System.out.println(demo==demo2);
		System.out.println(demo.equals(demo2));

		
		System.out.println(string_1.equals(string_2));
		
	}
		
}

//���������أ���һ��������������ӵ����ͬ�����֣������в�ͬ�Ĳ����б�
//һ��Դ�ļ���ֻ����һ��public�ࣻ������ӵ�ж����public��

//java�еļ̳У����̳�private���Ժͷ���

//java�еĽӿھ���һЩ�����ļ��ϣ���û�з����ľ���ʵ��

//���һ������û�а����㹻����Ϣ�����һ������Ķ�������������ǳ����ࣻ�����಻��ʵ��������ֻ��ͨ���̳еķ�ʽ����ʹ��

//һ���ӿڿ��Լ̳���һ���ӿ�

//ö����һ��������࣬һ���ʾһ�鳣��

// "=="�Ƚϵ�������������ʵ���ǲ���ָ��ͬһ���ڴ�ռ䣬��equals���Ƚ�������������ʵ����ָ����ڴ�ռ��ֵ�Ƿ����

//�ں����ж����һЩ�������͵ı����Ͷ�������ñ��������ں�����ջ�ڴ��з���ռ�ģ����ڴ����ڴ����new�����Ķ�������飬�ڶ��з����ڴ棬��GC���Զ������ڴ档

//final���ε�����������࣬���಻�ܱ��̳У����εķ������ܱ���д�����εĳ��������ʼ������ʼ��֮��ֵ���ܱ��޸�

//�ֽ�����8λ�������ֽ�Ϊ��λ����������ݣ��ַ�����16λ�������ַ�Ϊ��λ�������

class Demo{
	
	private String name;
	private int id;
	
	private char c = 'a';
	public String str="hello";

	protected int variable=123;
	protected String string="abx";
	
	public Demo(String myName,int myId) {
		this.name=myName;
		this.id= myId;
	}
	
	public void eat() {
		System.out.println("��");
	}
	
	public void sleep() {
		System.out.println("˯");
	}
	
	public String work() {
		return string;
	}
	
	public int getter() {
		return variable;
	}
}

class Exam extends Demo{

	public Exam(String myName, int myId) {
		super(myName, myId);
		// TODO Auto-generated constructor stub
	}
	
}

interface interFace{
	
	public static final int b=2;
	static int a=1;
	
	abstract void Function();
}

enum Color{
	red,green,blue;
}










