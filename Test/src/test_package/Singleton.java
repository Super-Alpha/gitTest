package test_package;

public class Singleton {
	
	
	private static Singleton singleton;
	
	private Singleton() {
		
	}
	
	
	public static Singleton getSingleton() {
		if (singleton==null) {
			singleton=new Singleton();
			try {
				singleton.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return singleton;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
