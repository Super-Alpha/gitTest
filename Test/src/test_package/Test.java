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

//方法的重载：在一个类中两个方法拥有相同的名字，但是有不同的参数列表
//一个源文件中只能有一个public类；但可以拥有多个非public类

//java中的继承，不继承private属性和方法

//java中的接口就是一些方法的集合，但没有方法的具体实现

//如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类；抽象类不能实例化对象，只能通过继承的方式来被使用

//一个接口可以继承另一个接口

//枚举是一个特殊的类，一般表示一组常量

// "=="比较的是两个变量或实例是不是指向同一个内存空间，“equals”比较是两个变量或实例所指向的内存空间的值是否相等

//在函数中定义的一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配空间的；堆内存用于存放由new创建的对象和数组，在堆中分配内存，由GC来自动回收内存。

//final修饰的类叫做最终类，该类不能被继承；修饰的方法不能被重写；修饰的常量必须初始化，初始化之后值不能被修改

//字节流按8位传输以字节为单位输入输出数据；字符流按16位传输以字符为单位输入输出

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
		System.out.println("吃");
	}
	
	public void sleep() {
		System.out.println("睡");
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










