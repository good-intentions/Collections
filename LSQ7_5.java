package collections;

import java.util.LinkedList;

public class LSQ7_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> nums = new LinkedList<>();
		for(int i = 0; i < 5_000_000; i++) {
			nums.add(i);
		}
		int a = 0;
		for(int i = 0; i < 5_000_000; i++) {
			a = nums.get(i);
		}
		
		System.out.print(a);
	}

}
