package test_package;
import java.util.Scanner;


public class Dog extends cls{
	
	
	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
//		String string = scanner.nextLine();
//		String[] stringArray = string.split(" ");
//		float[] num = new float[stringArray.length];
//		
//		for(int i=0;i<stringArray.length;i++) {
//			num[i]=Float.parseFloat(stringArray[i]);
//		}
//		
//		for(int j=0;j<num.length;j++){
//			System.out.print(num[j]+",");
//		}
//		
//		scanner.close();
		Dog dog = new Dog();
		dog.setName("beibei");
		System.out.print(dog.getName());
	}
	
	
	public void method() {
		
		System.out.println("This is a method!");
		
	}
	
	public void func() {
		
		System.out.println("This is a func!");
		
	}
}

// 对于抽象类而言，必须要子类继承；若抽象类中有抽象方法，则子类必须实现该方法或声明自身为抽象类

abstract class cls{
	
	private String name;
	
	public cls() {
		
	}
	
	public void setName(String string) {
		
		this.name=string;
	}
	
	
	//构造方法、类方法不能声明为抽象方法
	
	public String getName() {
		
		return this.name;
	}
	//抽象类中的抽象方法只是声明，不包含方法体；
	public abstract void method();
	
	protected abstract void func();
	
}
















