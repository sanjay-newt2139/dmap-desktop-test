package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
	public static void main2(String[] args) {
		String a = "8080,1,2,3,4,5,6,7,8,9,10"; // 50, 100-200, 250, 300-650
		String b = "100-300, 250, 350-500, 200-400, 350"; //100-500
		String c = "400-500,300-650,2,2-9,1"; // 1-9,300-650
		String d = "22,1522,40500-41000,8000-9000,8090,8095,8099";
		String e = "554,445,139,49152-65535, 80,8080,49000-50000";
		
		
		
		
		System.out.println(validate(a));
		System.out.println(validate(b));
		System.out.println(validate(c));
		System.out.println(validate(d));
		System.out.println(validate(e));
		
		
		
		
		String aa = "1.1.1";
		String[] ao = aa.split("\\.");
		System.out.println(aa.split("\\.").length);
		
		
	}
	
	public static void main(String[] args) {
		String xx = "boonyakn:BOONYAKIAT NGOUVISITKUL(4546)";
		if(xx != null && !(xx.trim().equals(""))){
			String xxx[] = xx.split(":");
			System.out.println(xxx[0]);
			System.out.println(xxx[1]);
		}
		
	}
	
	public static String validate(String str){
		String sp[] = str.replaceAll(" ", "").split(",");
		Map<Integer,Integer> result = new HashMap<Integer, Integer>();
		List<String> oo = new ArrayList<String>();
		for(String spData : sp){			
			int min = 0;
			int max = 0;
			String[] xx = spData.split("-");
			if(xx.length == 1){
				min = Integer.parseInt(xx[0]);
				max = Integer.parseInt(xx[0]);
			}else if(xx.length == 2){
				min = Integer.parseInt(xx[0]);
				max = Integer.parseInt(xx[1]);
			}
			
			while (min <= max) {
				result.put(min, min);
				min++;
			}
			
		}
		List<Integer> list = new ArrayList<Integer>(result.values());
		Collections.sort(list);
		Integer def = list.get(0);
		for (Integer a : list)
		{
			if(a == def || (a-def > 1)){
				oo.add(a + "-"+def);
			}
			def = a;
		}
		oo.add(list.get(list.size() - 1) + "-"+list.get(list.size() - 1));
		
		
		String resulti = "";
		for(int i = 0;i < (oo.size() -1);i++){
			String[] x1 = oo.get(i).split("-");
			String[] x2 = oo.get(i+1).split("-");
			if(x1[0].equals(x2[1])){
				resulti = resulti + "," + x1[0];
			}else{
				resulti = resulti + "," + x1[0] + "-" + x2[1];
			}
			
		}
		
		return resulti.equals("")?"":resulti.substring(1);
	}
	
}
