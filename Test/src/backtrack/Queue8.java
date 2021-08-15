package backtrack;

import java.util.function.IntToDoubleFunction;
import com.firefly.api.R.id;

public class Queue8 {
	
	int max = 8;//表示皇后的数量
	int[] array = new int[max]; //array[i]==val,表示第i行val列的皇后位置
	static int count = 0;
	
	public static void main(String[] args) {
		
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.print(count);
	}
	
	//放置皇后 n代表行
	private void check(int n) {
		
		if(n==max) {		
			print();
			count+=1;
			return;
		}
		///没看出回溯过程
		for (int i=0;i<max;i++) {
			
			//先把当前皇后n，放到该行的第i列
			array[n]=i;
			//判断当前放置第n个皇后到i列时，是否冲突
			if(judge(n)) {
				//若不冲突，则放置第n+1个皇后
				check(n+1);
			}
			//如果有冲突或check(n+1)行不通（即执行for循环），就继续执行for循环,将第n个皇后，放置在本行的后移的一个位置
		}
	}
	
	/**
	 * 当放置第n个皇后时，判断是否与之前放置的皇后冲突
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		//array[i]==array[n] 表示第i个皇后与第n个皇后在同一列
		//Math.abs(n-i)==Math.abs(array[n]-array[i]) (即斜率，若斜率相同，则代表处于同一对角线上)表示第n个皇后的对角线上有元素
		//因为是每一行求皇后位置，所以在行方向上，不会有处于同一行的冲突
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
