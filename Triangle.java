package TestJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Triangle path to the largest sum. 
 * 06-01-2012
 * @author mramos
 *
 */
public class Triangle {
	
	/**
	 * Triangle
By starting at the top of the triangle and moving to adjacent numbers on the row below, the maximum total from top to bottom is 27.

        5
      9  6
    4   6  8
  0   7  1   5

I.e. 5 + 9 + 6 + 7 = 27.

Write a program in a language of your choice to find the maximum total from top to bottom in triangle.txt, a text file containing a triangle with 100 rows. Send your solution and resume to [123456 AT yodle dot com], replacing 123456 with the maximum sum for the triangle.
	 * @param args
	 */
	public static void main(String[] args){
		
		String s = "5";
		String s1 = "9 6";
		String s3 = "4 6 8";
		String s4 = "0 7 1 5";
		String s5 ="1 4 9 3 5";
		String s6 ="2 4 6 8 3 5";
		
		java.util.List<String> all = new java.util.ArrayList<String>();
		all.add(s);
		all.add(s1);
		all.add(s3);
		all.add(s4);
		all.add(s5);
		all.add(s6);
		//java.util.List<String> all  = readFile(args[0]);
		
		testTriangleMaxTotal(all.toArray(new String[all.size()]));
	}
	

	
	public static List<String> readFile(String file){
		
		Charset charset = Charset.forName("US-ASCII");
		List<String> readLines = new ArrayList<String>();
		BufferedReader sbc = null;
		try {
			sbc = Files.newBufferedReader(java.nio.file.Paths.get(file), charset);
			String line = null;
		    while ((line = sbc.readLine()) != null){
		    	readLines.add(line);
		    }
		}catch (IOException x) {
		    System.out.println("caught exception: " + x);
		    System.exit(-1);
		}
		finally{
			if (sbc != null)
				try {
					sbc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return readLines;
	}
	
	public static void testTriangleMaxTotal(String[] data){
		
		System.out.println( calculate(data, 0, 0, 0));
	}
	
	public static int calculate(String[] data, int rFocus, int cFocus, int calc){
		
		if (data.length == rFocus)
			return calc;
		
		for (int i=rFocus; i<data.length; i++){
			String[] amount = data[i].split(" ");
			int dc = 0;
			if (amount.length == 1){
				dc = Integer.valueOf(amount[cFocus]);
			}
			else {
				
				if (calc + Integer.valueOf(amount[cFocus+1]) < calc + Integer.valueOf(amount[cFocus])){
					calc = calc + Integer.valueOf(amount[cFocus]);
				}
				else{
					calc = calc + Integer.valueOf(amount[cFocus+1]);
					cFocus = cFocus+1;
				}
				
			}	
		//			int dv = Integer.valueOf(data[i]);
			int fv=calculate(data, i+1, cFocus, dc + calc);
			if (fv > 0) return fv;
		}
		
		return 0;
	}
	
}
