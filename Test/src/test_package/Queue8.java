package test_package;

public class Queue8 {
	
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("һ����%d�ⷨ",count);

	}
	
	//���õ�n���ʺ�
	private void check(int n) {
		if (n==max) {
			print();
			return;
		}
		//�ӵ�һ�п�ʼ�ڷ�
		for (int i = 0; i<max; i++) {
			array[n]=i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}
	
	//�жϵ�ǰ�ڷŵĻʺ��֮ǰ�ڷŵĻʺ��Ƿ��ͻ
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
