package th.co.ais.ipfm.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.LazyInitializationException;

public class IPFMDataValidateUtil {
	public static final String OCS_COUNTRY_CODE_PREFIX="66";
	public static final String MOBILE_NO_PREFIX ="08";
	public static int MOBILE_NO_LENGTH = 10;
	public static String mobileRegex = IPFMDataValidateUtil.MOBILE_NO_PREFIX+"[0-9]{"+(IPFMDataValidateUtil.MOBILE_NO_LENGTH-IPFMDataValidateUtil.MOBILE_NO_PREFIX.length())+"}";
	
	public static final String MOBILE_NO_PREFIX_TOT ="0";
	public static String mobileRegexTOT = IPFMDataValidateUtil.MOBILE_NO_PREFIX_TOT+"[0-9]{"+(IPFMDataValidateUtil.MOBILE_NO_LENGTH-IPFMDataValidateUtil.MOBILE_NO_PREFIX_TOT.length())+"}";
	
	public static final String HOME_NO_PREFIX ="0";
	public static int HOME_NO_LENGTH = 9;
	public static String homeRegex = IPFMDataValidateUtil.HOME_NO_PREFIX+"[0-9]{"+(IPFMDataValidateUtil.HOME_NO_LENGTH-IPFMDataValidateUtil.HOME_NO_PREFIX.length())+"}";
	
	public static String numberRegex = "[0-9]{0,}";
	public static String numberRegexNoDigit = "[0-9]{0,}";
	public static String numberRegexOneDigit = "[0-9]{0,}[.]{1}[0-9]{1}"; 
	public static String numberRegexTwoDigit = "[0-9]{0,}[.]{1}[0-9]{2}";	

	public static boolean validateNumberDigit(String number, int precision, int scale){
		String format = "[0-9]{0," + String.valueOf(precision-scale) + "}[.]{1}[0-9]{0," + String.valueOf(scale) +"}"; 
		if (!number.trim().matches(format)){
			return false;	
		}	
		return true;
	}
	
	public static boolean validateNumberNoDigit(String number, int precision){
		String format = "[0-9]{0," + String.valueOf(precision) + "}";
		if (!number.trim().matches(format)){
			return false;	
		}	
		return true;
	}
	
	public static boolean validateNumberNoDigit(String number){
		if (!number.trim().matches(numberRegexNoDigit)){
			return false;	
		}	
		return true;
	}
	
	public static boolean validateNumber(String number){
		if (!number.trim().matches(numberRegex)){
			return false;	
		}
		return true;
	}
	public static boolean validateMobileNo(String mobileNo) throws Exception{
		//String regex = "08"+"[0-9]{"+(8)+"}"; 
		//หมายความว่า เริ่มต้นด้วย 08 และตามด้วยตัวอักษร 0-9 ไป 8 ตัว
		if (mobileNo.trim().length()>0){
			if (!mobileNo.trim().matches(mobileRegex)){
				return false;	
			}
		}	
		return true;
	}
	
	public static boolean validateMobileNoTOT(String mobileNo) throws Exception{
		//String regex = "0"+"[0-9]{"+(9)+"}"; 
		//หมายความว่า เริ่มต้นด้วย 0 และตามด้วยตัวอักษร 0-9 ไป 9 ตัว
		if (mobileNo.trim().length()>0){
			if (!mobileNo.trim().matches(mobileRegexTOT)){
				return false;	
			}
		}	
		return true;
	}
	
	public static boolean validateHomeNo(String homeNo) throws Exception{
		//String regex = "0"+"[0-9]{"+(8)+"}"; 
		//หมายความว่า เริ่มต้นด้วย 0 และตามด้วยตัวอักษร 0-9 ไป 8 ตัว
		if (homeNo.trim().length()>0){
			if (!homeNo.trim().matches(homeRegex)){
				return false;	
			}
		}	
		return true;
	}
	
	/**
	 * return false if collection has no data (size 0) or instance is null
	 * @param collection
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isCollectionEmpty(Collection collection) throws Exception {
		org.hibernate.collection.PersistentSet s = new org.hibernate.collection.PersistentSet();
	  try{
		if(collection == null || collection.isEmpty()) {
			return true;
		}
		} catch(LazyInitializationException lazyEx) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param sEmail
	 * @return boolean
	 */
	public static boolean validateEmailFormat(String sEmail){
		if(sEmail == null || sEmail.length() < 1){
			return false;
		}
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = sEmail;
		Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.matches()){
			return true;
		}
		return false;
	}

	public static boolean validateIPFormat(String ipAddress) {
		try {
		if (ipAddress==null || ipAddress.trim().length()==0) return false;
		String[] ipDigit = ipAddress.split("\\.");
		if (ipDigit.length != 4) return false;
		if (!validateNumber(ipDigit[0])) return false;
		if (!validateNumber(ipDigit[1])) return false;
		if (!validateNumber(ipDigit[2])) return false;
		if (!validateNumber(ipDigit[3])) return false;
		int digit1 = Integer.parseInt(ipDigit[0]);
		int digit2 = Integer.parseInt(ipDigit[1]);
		int digit3 = Integer.parseInt(ipDigit[2]);
		int digit4 = Integer.parseInt(ipDigit[3]);
		
		if(ipDigit[0].trim().length()>1 && (digit1==0 || ipDigit[0].trim().startsWith("0"))) return false;
		if(ipDigit[1].trim().length()>1 && (digit2==0 || ipDigit[1].trim().startsWith("0"))) return false;
		if(ipDigit[2].trim().length()>1 && (digit3==0 || ipDigit[2].trim().startsWith("0"))) return false;
		if(ipDigit[3].trim().length()>1 && (digit4==0 || ipDigit[3].trim().startsWith("0"))) return false;
		
		if (digit1<0 || digit1>255) return false;
		if (digit2<0 || digit2>255) return false;
		if (digit3<0 || digit3>255) return false;
		if (digit4<0 || digit4>255) return false;
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	public static boolean validateMaskFormat(String string) {
		if (!validateNumber(string)) return false;
		int mask = Integer.parseInt(string);
		if (mask<0 || mask>32) return false;
		return true;
	}

	public static boolean validateIPVersion(String ipVersion) {
		if (ipVersion!=null && (ipVersion.equalsIgnoreCase("4"))) return true;
		return false;
	}
}
