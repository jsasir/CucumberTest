package QuickTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class RoughCalc {
	
	  public static void main(String[] args)
	  {
//		  Double doubleArr = null;
		  ArrayList<String> expected_txtVal = new ArrayList<String>(Arrays.asList("$122,365.24","$599.00","$850,139.99","$23,329.50","$566.27"));
		  ArrayList<Double> doubleArr = new ArrayList<Double>();
		  	  for (int i=0; i <= expected_txtVal.size()-1; i++){
		  		doubleArr.add(i, Double.parseDouble(expected_txtVal.get(i).replaceAll("[^\\d.]+", "").toString()));
		  	  }
		  	  System.out.println(doubleArr);
//			  StringBuilder sb = new StringBuilder(expected_txtVal.get(i));
//			  expected_txtVal.remove(i);
////			  expected_txtVal.add(i, Integer.parseInt(sb.deleteCharAt(0).toString()));
//			  intArr.add(i, Float.parseFloat(sb.deleteCharAt(0).toString()));
//		  }
//		  String oldStr = "$122,365.24"; 
//		  Double intArr = Double.parseDouble(oldStr.replaceAll("[^\\d.]+", "").toString());
//		  System.out.println(intArr+100000);
		  
		  
	} 

	}


