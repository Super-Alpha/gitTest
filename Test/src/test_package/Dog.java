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

// ���ڳ�������ԣ�����Ҫ����̳У������������г��󷽷������������ʵ�ָ÷�������������Ϊ������

abstract class cls{
	
	private String name;
	
	public cls() {
		
	}
	
	public void setName(String string) {
		
		this.name=string;
	}
	
	
	//���췽�����෽����������Ϊ���󷽷�
	
	public String getName() {
		
		return this.name;
	}
	//�������еĳ��󷽷�ֻ�������������������壻
	public abstract void method();
	
	protected abstract void func();
	
}
















