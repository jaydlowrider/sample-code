package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Various Code to test Sample..
 * 
 * KnapSack Problem, Power implementation, factorial
 * 
 * @author mramos 07/03/2011
 *
 */
public class KnapSack {
	
	public static void main(String[] args){
		
		KnapSack k = new KnapSack();
		k.testKnapSack();
		
		System.out.println("Power of 5 ^ 5 is " + power(5, 5));
		System.out.println("Factorial 5! is " + factorial(5));
		
		System.out.println("Shift to left 3 << 5 " + (3 << 5));
		System.out.println("Shift to right 3 >> 5 " + (96 >> 5));
	}
	
	private static int indexOf(char[] toSearch, char[] beingSearch){
		int index = 0;
		boolean found = false;
		for (int j = 0; j < toSearch.length; j++) {
			char mark = toSearch[j];
			int k = index;
			while (k < beingSearch.length - 1) {
				if (beingSearch[k++] == mark) {
					if (index == 0 || (index != 0 && (k - 1) == index)) {
						index = k;
						found  = true;
						break;
					} else {
						index = 0;
						found = false;
						break;
					}
				}
			}
		}
		return found && index - (toSearch.length - 1) <= 0 ? -1 : index
				- (toSearch.length - 1);
	}
	
	public static int power(int a, int b){
		
		if (b == 0)  return 1;
		return a * power(a, b-1);
	}
	
	public static int factorial(int a){
		if (a ==1) return 1;
		return a * factorial(a-1);
	}
	
	public void testKnapSack() {
		int[] data = { 11, 8, 7, 6, 5 };
		List<Integer> collector = new ArrayList<Integer>();
		knapSack(data, 20, 0, collector);
		System.out.println("Found the combination=" + collector.get(0) + ","
				+ collector.get(1) + "," + collector.get(2));
	}

	private int knapSack(int[] data, int target, int focus,
			List<Integer> collector) {
		if (target < 0) {
			return -1;
		}
		if (target == 0) {
			return 0;
		}
		for (int j = focus; j < data.length; j++) {
			int newtarget = target - data[j];
			int ret = knapSack(data, newtarget, j + 1, collector);
			if (ret == -1) {
				continue;
			}
			if (ret == 0) {
				collector.add(data[j]);
				return 0;
			}
		}
		return -1;
	}

}
