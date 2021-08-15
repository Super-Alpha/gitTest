package backtrack;

import java.util.function.IntToDoubleFunction;
import com.firefly.api.R.id;

public class Queue8 {
	
	int max = 8;//��ʾ�ʺ������
	int[] array = new int[max]; //array[i]==val,��ʾ��i��val�еĻʺ�λ��
	static int count = 0;
	
	public static void main(String[] args) {
		
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.print(count);
	}
	
	//���ûʺ� n������
	private void check(int n) {
		
		if(n==max) {		
			print();
			count+=1;
			return;
		}
		///û�������ݹ���
		for (int i=0;i<max;i++) {
			
			//�Ȱѵ�ǰ�ʺ�n���ŵ����еĵ�i��
			array[n]=i;
			//�жϵ�ǰ���õ�n���ʺ�i��ʱ���Ƿ��ͻ
			if(judge(n)) {
				//������ͻ������õ�n+1���ʺ�
				check(n+1);
			}
			//����г�ͻ��check(n+1)�в�ͨ����ִ��forѭ�������ͼ���ִ��forѭ��,����n���ʺ󣬷����ڱ��еĺ��Ƶ�һ��λ��
		}
	}
	
	/**
	 * �����õ�n���ʺ�ʱ���ж��Ƿ���֮ǰ���õĻʺ��ͻ
	 * @param n ��ʾ��n���ʺ�
	 * @return
	 */
	private boolean judge(int n) {
		//array[i]==array[n] ��ʾ��i���ʺ����n���ʺ���ͬһ��
		//Math.abs(n-i)==Math.abs(array[n]-array[i]) (��б�ʣ���б����ͬ���������ͬһ�Խ�����)��ʾ��n���ʺ�ĶԽ�������Ԫ��
		//��Ϊ��ÿһ����ʺ�λ�ã��������з����ϣ������д���ͬһ�еĳ�ͻ
		for(int i =0 ; i<n; i++) {
			if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	
	
	private void print() {
		
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
