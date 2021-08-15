package test_package;

public class Queue8 {
	
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法",count);

	}
	
	//放置第n个皇后
	private void check(int n) {
		if (n==max) {
			print();
			return;
		}
		//从第一列开始摆放
		for (int i = 0; i<max; i++) {
			array[n]=i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}
	
	//判断当前摆放的皇后和之前摆放的皇后是否冲突
	private boolean judge(int n) {
		for (int i=0; i<n;i++) {
			if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	private void print() {
		count++;
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + "");
		}
		System.out.println();
	}
}
