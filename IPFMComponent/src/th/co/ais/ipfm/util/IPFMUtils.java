package th.co.ais.ipfm.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

/** @modelguid {D77975CF-BD99-44BD-8A50-19D2785604E8} */
public class IPFMUtils {
	/** @modelguid {0895D85A-02B0-415F-A238-594CB398C5FF} */
	private static Logger log = Logger.getLogger(IPFMUtils.class); 

	/**
	 * Check OS
	 * @modelguid {ED0BA99F-D281-49A0-9C92-7ADFF91BA2FE}
	 */
	public static String checkOs() throws Exception {
		String code = null;
		String osName = System.getProperty("os.name");
		if (osName.equals("Windows NT")) {
			code = "TIS620";
		} else
			if (osName.equals("Solaris")) {
				code = "TIS620";
			} else
				code = "TIS620";
		return code;
	}
	/**
	 *  Convert byte  to string
	 * @param inputstr the String value
	 * @modelguid {9AF4AB4A-2120-4902-9230-D12520195AD8}
	 */
	public static String cnvByteToString(String inputstr) throws Exception {
		String code = checkOs();
		String outputstr = null;
		String osName = System.getProperty("os.name");
		try {
			if (osName.equals("Solaris")) {
				byte[] b = inputstr.getBytes(code);
				outputstr = new String(b);
			} else {
				outputstr = inputstr;
			}
		} catch (java.io.UnsupportedEncodingException e) {
			log.debug("Unsupported Encoding");
		}
		return outputstr;
	}
	/**
	 * Convert java.util.Date to date string using given pattern.
	
		1. DD/MM/YYYY 				= 25/01/2002
		2. YYYY/MM/DD 				= 2002/01/25
		3. DD/MM/YYYY HH24:MI:SS	= 25/01/2002 16:36:45
		4. DD/MM/YYYY HH:MM:SS 		= 25/01/2002 16:36:45
		5. YYYYMMDD                 = 20020125
	 
	 * @param inputDate the date value.
	 * @param targetFormat the targetFormat : Example : DD/MM/YYYY .
	 * @modelguid {21D61038-910B-4BE4-8FCC-EAD8177F2622}
	 */

	public static String cnvDateToString(
			java.util.Date inputDate,
			String targetFormat)
			throws Exception {
		return cnvDateToStringAD(inputDate, targetFormat);
	}
	
	public static String cnvDateToStringAD(
		java.util.Date inputDate,
		String targetFormat)
		throws Exception {
		targetFormat = targetFormat.toUpperCase();
		String retDate = "";
		String hh = "";
		String mm = "";
		String ss = "";
		if (inputDate != null) {
			java.util.Calendar calendarObj = java.util.Calendar.getInstance(Locale.ENGLISH);
			calendarObj.setTime(inputDate);

			int day = calendarObj.get(java.util.Calendar.DAY_OF_MONTH);
			int month = calendarObj.get(java.util.Calendar.MONTH) + 1;
			int year = calendarObj.get(java.util.Calendar.YEAR);
			int hours = calendarObj.get(java.util.Calendar.HOUR_OF_DAY);
			int minutes = calendarObj.get(java.util.Calendar.MINUTE);
			int seconds = calendarObj.get(java.util.Calendar.SECOND);

			/*			Debug.println(" day = " + day + " month = " + month + " year = " + year +  "\n"
							+ " hours = " + hours + " minutes = " + minutes + " seconds = "+ seconds);*/

			if (day < 10)
				retDate = "0" + day;
			else
				retDate = (new Integer(day)).toString();

			if (month < 10) {
				if (targetFormat.equals("YYYYMMDD")) {
					retDate = year+ "0" + month + retDate;
				}
				if (targetFormat.equals("DD/MM/YYYY")) {
					retDate = retDate + "/0" + month + "/" + year;
				}
				if (targetFormat.equals("YYYY/MM/DD")) {
					retDate = year + "/0" + month + "/" + retDate;
				}
				if (targetFormat.equals("MM/DD/YYYY")) {
					retDate = "/0" + month + "/" + retDate +"/"+ year;
				}
				if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
					|| targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
					if (hours < 10)
						hh = "0" + Integer.toString(hours);
					else
						hh = Integer.toString(hours);
					if (minutes < 10)
						mm = "0" + Integer.toString(minutes);
					else
						mm = Integer.toString(minutes);
					if (seconds < 10)
						ss = "0" + Integer.toString(seconds);
					else
						ss = Integer.toString(seconds);

					retDate = retDate + "/0" + month + "/" + year + " " + hh + ":" + mm + ":" + ss;
				}
			} else {
				if (targetFormat.equals("YYYYMMDD")) {
					retDate = year + "" + month + "" + retDate;
				}
				if (targetFormat.equals("DD/MM/YYYY")) {
					retDate = retDate + "/" + month + "/" + year;
				}

				if (targetFormat.equals("YYYY/MM/DD")) {
					retDate = year + "/" + month + "/" + retDate;
				}
				if (targetFormat.equals("MM/DD/YYYY")) {
					retDate = month + "/" + retDate +"/"+ year;
				}
				if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
					|| targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
					if (hours < 10)
						hh = "0" + Integer.toString(hours);
					else
						hh = Integer.toString(hours);
					if (minutes < 10)
						mm = "0" + Integer.toString(minutes);
					else
						mm = Integer.toString(minutes);
					if (seconds < 10)
						ss = "0" + Integer.toString(seconds);
					else
						ss = Integer.toString(seconds);

					retDate = retDate + "/" + month + "/" + year + " " + hh + ":" + mm + ":" + ss;
				}
			}
		} else {
			if (targetFormat.equals("DD/MM/YYYY")) {
				retDate = "00/00/0000";
			}
			if (targetFormat.equals("YYYY/MM/DD")) {
				retDate = "0000/00/00";
			}
			if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
				|| targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
				retDate = "00/00/0000 00:00:00";
			}
		}
		return retDate;
	}
	
	public static String cnvDateToStringBE(
			java.util.Date inputDate,
			String targetFormat)
			throws Exception {
			targetFormat = targetFormat.toUpperCase();
			String retDate = "";
			String hh = "";
			String mm = "";
			String ss = "";
			if (inputDate != null) {
				java.util.Calendar calendarObj = java.util.Calendar.getInstance(Locale.ENGLISH);
				calendarObj.setTime(inputDate);

				int day = calendarObj.get(java.util.Calendar.DAY_OF_MONTH);
				int month = calendarObj.get(java.util.Calendar.MONTH) + 1;
				int year = calendarObj.get(java.util.Calendar.YEAR);
				int hours = calendarObj.get(java.util.Calendar.HOUR_OF_DAY);
				int minutes = calendarObj.get(java.util.Calendar.MINUTE);
				int seconds = calendarObj.get(java.util.Calendar.SECOND);
				
				// convert year to BE
				year = year + 543;
				/*			Debug.println(" day = " + day + " month = " + month + " year = " + year +  "\n"
								+ " hours = " + hours + " minutes = " + minutes + " seconds = "+ seconds);*/

				if (day < 10)
					retDate = "0" + day;
				else
					retDate = (new Integer(day)).toString();

				if (month < 10) {
					if (targetFormat.equals("YYYYMMDD")) {
						retDate = year+ "0" + month + retDate;
					}
					if (targetFormat.equals("DD/MM/YYYY")) {
						retDate = retDate + "/0" + month + "/" + year;
					}
					if (targetFormat.equals("YYYY/MM/DD")) {
						retDate = year + "/0" + month + "/" + retDate;
					}
					if (targetFormat.equals("MM/DD/YYYY")) {
						retDate = "/0" + month + "/" + retDate +"/"+ year;
					}
                                        if (targetFormat.equals("DD/MM/YYYY HH24:MI")
						|| targetFormat.equals("DD/MM/YYYY HH:MM")) {
						if (hours < 10)
							hh = "0" + Integer.toString(hours);
						else
							hh = Integer.toString(hours);
						if (minutes < 10)
							mm = "0" + Integer.toString(minutes);
						else
							mm = Integer.toString(minutes);

						retDate = retDate + "/0" + month + "/" + year + " " + hh + ":" + mm;
					}
					if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
						|| targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
						if (hours < 10)
							hh = "0" + Integer.toString(hours);
						else
							hh = Integer.toString(hours);
						if (minutes < 10)
							mm = "0" + Integer.toString(minutes);
						else
							mm = Integer.toString(minutes);
						if (seconds < 10)
							ss = "0" + Integer.toString(seconds);
						else
							ss = Integer.toString(seconds);

						retDate = retDate + "/0" + month + "/" + year + " " + hh + ":" + mm + ":" + ss;
					}
				} else {
					if (targetFormat.equals("YYYYMMDD")) {
						retDate = year + "" + month + "" + retDate;
					}
					if (targetFormat.equals("DD/MM/YYYY")) {
						retDate = retDate + "/" + month + "/" + year;
					}

					if (targetFormat.equals("YYYY/MM/DD")) {
						retDate = year + "/" + month + "/" + retDate;
					}
					if (targetFormat.equals("MM/DD/YYYY")) {
						retDate = month + "/" + retDate +"/"+ year;
					}
                                        if (targetFormat.equals("DD/MM/YYYY HH24:MI")
						|| targetFormat.equals("DD/MM/YYYY HH:MM")) {
						if (hours < 10)
							hh = "0" + Integer.toString(hours);
						else
							hh = Integer.toString(hours);
						if (minutes < 10)
							mm = "0" + Integer.toString(minutes);
						else
							mm = Integer.toString(minutes);

						retDate = retDate + "/" + month + "/" + year + " " + hh + ":" + mm;
					}
					if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
						|| targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
						if (hours < 10)
							hh = "0" + Integer.toString(hours);
						else
							hh = Integer.toString(hours);
						if (minutes < 10)
							mm = "0" + Integer.toString(minutes);
						else
							mm = Integer.toString(minutes);
						if (seconds < 10)
							ss = "0" + Integer.toString(seconds);
						else
							ss = Integer.toString(seconds);

						retDate = retDate + "/" + month + "/" + year + " " + hh + ":" + mm + ":" + ss;
					}
				}
			} else {
				if (targetFormat.equals("DD/MM/YYYY")) {
					retDate = "00/00/0000";
				}
				if (targetFormat.equals("YYYY/MM/DD")) {
					retDate = "0000/00/00";
				}
                                if (targetFormat.equals("DD/MM/YYYY HH24:MI")
					|| targetFormat.equals("DD/MM/YYYY HH:MM")) {
					retDate = "00/00/0000 00:00";
				}
				if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
					|| targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
					retDate = "00/00/0000 00:00:00";
				}
			}
			return retDate;
		}
	
	/**
	 *  cnvSectionMask
	 * @param inpMark the string value
	 * @modelguid {BD8AD4AB-61AE-405F-A99B-92FD20F1DBDD}
	 */
	public static String cnvSectionMark(String inpMark) throws Exception {
		String mark = null;
		int intMark = Integer.parseInt(inpMark);

		switch (intMark) {
			case 1 :
				mark = ".";
				break;
			case 2 :
				mark = ",";
				break;
			case 3 :
				mark = "-";
				break;
		}
		return mark;
	}
	/**
	 * Convert date string to date BuddhistEra using given pattern and language.
	 * Example. if you assigned language ="T"
	 	1.SHORT       = 25/1/2545
		2.MEDIUM      = 25 ?.?. 2545
		3.LONG        = 25 ?????? 2545
		4.FULL        = ??????????? 25 ?????? ?.?. 2545
		5.FULLMEDIUM  = ??????????? 25 ?.?. 2545
		
		if you assigned language ="E"
		1.SHORT       = 25/1/2002
		2.MEDIUM      = 25 ?.?. 2002
		3.LONG        = 25 ?????? 2002
		4.FULL        = ??????????? 25 ?????? ?.?. 2002
		5.FULLMEDIUM  = ??????????? 25 ?.?. 2002
	 * @param strDate the date string Example. 05/02/2002
	 * @param format the target format such as SHORT,MEDIUM,LONG,FULL,FULLMEDIUM. 
	 * @param language the language such as  E or T.
	 * @return the formatted date string.
	 * @modelguid {7E771B77-1756-4843-8634-1B3344435DAB}
	 */
	public static String cnvStringDateToBuddhistEra(
		String strDate,
		String format,
		String language)
		throws Exception {
		String dateThai = "";
		if (strDate.equals("00/00/0000")) {
			strDate = "";
			return strDate;
		}
		try {
			if (!validateDate(strDate))
				return "InValid Date ";

			String [] monthThai = { "??????","??????????","??????","??????","???????","????????","???????","???????","???????","??????","?????????","???????"} ;
			String [] shortMonthThai = { "?.?.","?.?.","??.?.","??.?.","?.?.","??.?.","?.?.","?.?.","?.?.","?.?.","?.?.","?.?."} ;
			String [] dayThai ={"???????","??????","??????","???","????????","?????","?????"};
			String [] monthEnglish = {"January","February","March","April","May","June","July","August","September","October","November","December"} ;
			String [] shortMonthEng = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"} ;			
			String [] dayEng ={"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
			
			java.util.Date newDate = cnvStringToDate(strDate);
			Calendar calendar = Calendar.getInstance(Locale.ENGLISH) ;
			calendar.setTime(newDate) ;
			int dayOfWeek =    calendar.get(Calendar.DAY_OF_WEEK) ;
			int day = calendar.get(Calendar.DAY_OF_MONTH) ;
			int month =  calendar.get(Calendar.MONTH) ;
			int yearAD = calendar.get(Calendar.YEAR) ;
			int yearBC = yearAD + 543 ;
			//log.debug("  dayOfWeek ="+dayOfWeek+" day ="+day+" month= "+month+" yearAD="+yearAD);
			//String dateStr = (new SimpleDateFormat("dd/MM/yyyy")).format(newDate);
			//log.debug(" DateStr = "+dateStr);
			String monthStr="";
			if (language.equalsIgnoreCase("T")) {
				if (format.equalsIgnoreCase("SHORT")) {
					if(month<9){
						dateThai =  cnvByteToString(Integer.toString(day)+"/0"+Integer.toString(month+1)+"/"+Integer.toString(yearBC)) ;
					} else {
						dateThai =  cnvByteToString(Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(yearBC)) ;
					}	
					log.debug("DateThai =  " + dateThai);
					return dateThai;
				}
				if (format.equalsIgnoreCase("MEDIUM")) {
					monthStr = shortMonthThai[month] ; 
					dateThai =cnvByteToString( Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearBC) );
					return dateThai;
				}
				if (format.equalsIgnoreCase("LONG")) {
					monthStr = monthThai[month] ; 
					dateThai =cnvByteToString( Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearBC) );
					return dateThai;
				}
				if (format.equalsIgnoreCase("FULL")) {
					monthStr = monthThai[month] ; 
					dateThai =cnvByteToString( "???"+dayThai[dayOfWeek-1]+"??? "+ Integer.toString(day)+" "+monthStr+"  ?.?. "+Integer.toString(yearBC) );
					return dateThai;
				}
				if (format.equalsIgnoreCase("FULLMEDIUM")) {
					monthStr = shortMonthThai[month] ; 
					dateThai =cnvByteToString( "???"+dayThai[dayOfWeek-1]+"??? "+ Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearBC) );
					return dateThai;
				}
			} else {
				if (format.equalsIgnoreCase("SHORT")) {
					dateThai =  Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(yearAD) ;
					return dateThai;
				}
				if (format.equalsIgnoreCase("MEDIUM")) {
					monthStr = shortMonthEng[month] ; 
					dateThai = Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearAD) ;
					return dateThai;
				}
				if (format.equalsIgnoreCase("LONG")) {
					monthStr = monthEnglish[month] ; 
					dateThai = Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearAD) ;
					return dateThai;
				}
				if (format.equalsIgnoreCase("FULL")) {
					monthStr = monthEnglish[month] ; 					
					dateThai =dayEng[dayOfWeek-1]+"  "+ Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearAD) ;					
					return dateThai;
				}
				if (format.equalsIgnoreCase("FULLMEDIUM")) {
					monthStr = shortMonthEng[month] ; 					
					dateThai =dayEng[dayOfWeek-1]+"  "+ Integer.toString(day)+" "+monthStr+" "+Integer.toString(yearAD) ;										
					return dateThai;
				}
			}
		} catch (Exception ex) {
			log.debug("Error : " + ex);
		}
		return null;
	}
	/** @modelguid {FD8C6C51-3F91-4869-91F9-B4D475454A3F} */
	public static String cnvStringToByte(String inputstr) throws Exception {
		String code = checkOs();
		String outputstr = null;
		try {
			byte[] b = inputstr.getBytes();
			outputstr = new String(b, code);
		} catch (java.io.UnsupportedEncodingException e) {
			log.debug("Unsupported Encoding");
		}
		return outputstr;
	}
	/**
	 * Convert date string to date value.
	 * @return date value.
	 * @param inpDate the date string in the format of "dd/mm/yyyy". Example. "15/01/2002".
	 * @modelguid {56D44B38-5330-484F-93C1-7720854F7A5F}
	 */
	public static java.util.Date cnvStringToDate(String inpDate) throws Exception {
		java.util.Date date = null;
		boolean convert = false;
		if (inpDate == null || inpDate.length() == 0 || inpDate.equals("null")) {
			return date;
		}
		if ((inpDate != null) || (inpDate.length() >= 10)) {
			int ind1 = inpDate.indexOf('/');
			int ind2 = inpDate.lastIndexOf('/');
			if ((ind1 == 2) && (ind2 == 5))
				convert = true;
		}
		Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
		if (convert) {
			int day = Integer.parseInt(inpDate.substring(0, 2));
			int month = Integer.parseInt(inpDate.substring(3, 5));
			int year = Integer.parseInt(inpDate.substring(6, 10));

			if (inpDate.length() > 10) {
				int hh = Integer.parseInt(inpDate.substring(11, 13));
				int mm = Integer.parseInt(inpDate.substring(14, 16));
				int ss = Integer.parseInt(inpDate.substring(17, 19));

				calendar.set(year, month - 1, day, hh, mm, ss);
			} else {
				calendar.set(year, month - 1, day,0,0,0);
			}
		}
        return new Date((calendar.getTimeInMillis()/1000)*1000);
		//return calendar.getTime();
	}
	/**
	 * Convert the time string pattern to time int.
	 * @return the time in the int format.
	 * @param time the time string.Example. 10:30
	 * @modelguid {A0D82783-A280-471C-827C-CFCBA5158E90}
	*/
	public static int cnvStringToTimeInt(String time) {
		if (time == null || time.length() == 0)
			time = "0:00";
		time = time + ":";
		Vector timeVector = separateString(time, ":");
		time = (String) timeVector.elementAt(0) + (String) timeVector.elementAt(1);
		return Integer.parseInt(time);
	}
	/**
	 * Convert the time int pattern to time string.
	 * @return the time string.
	 * @param time the time int.
	 * @modelguid {204BB937-4922-48D4-A8FC-09524983275F}
	*/
	public static String cnvTimeToString(int time) {
		if (time < 100)
			time = time * 100;

		Integer hours = new Integer(time / 100);
		Integer minute = new Integer(time % 100);
		String min = minute.toString();
		if (min.equals("0"))
			min = "00";
		String result = hours.toString() + ":" + min;
		return result;
	}
	/**
	 * Convert the time string without ":" to time String pattern with ":".
	 * Example. cnvTimeToString("0830") will returns 08:30 
	 * @return the time in the int format.
	 * @param time the time string.
	 * @modelguid {574AD416-70ED-431C-B7E7-37B2F0E07768}
	*/
	public static String cnvTimeToString(String time) {
		try {
			int timeInt = Integer.parseInt(time);
			String result = cnvTimeToString(timeInt);
			return result;
		} catch (NumberFormatException ex) {
			return time;
		}
	}
	/*
	 * Change Default Era to BuddhistEra.
	 * @return the date string foramt.
	 * @param style the style.
	 * @param myDate the date value.
	 * @modelguid {4D0B12DC-5A41-42F2-98D6-410028535162}
	**/
	public static String getDateFormatterStyleBuddhistEra(int style, Date myDate) {
		
		String ChristianEra = DateFormat.getDateInstance(style).format(myDate);
		log.debug(" << ChristianEra Date >> = "+ChristianEra);
		
		int indexOfDay 		= ChristianEra.indexOf("/");
		
		if(indexOfDay>0)
		{
			int indexOfMonth	= ChristianEra.lastIndexOf("/");
			int day 		= Integer.parseInt(ChristianEra.substring(0,indexOfDay));
			int month	= Integer.parseInt(ChristianEra.substring(indexOfDay+1,indexOfMonth));			

			int firstIndex = ChristianEra.length() - 4;
			int yearNumber = Integer.parseInt(ChristianEra.substring(firstIndex));
			
			String dayStr ="", monthStr ="";
			if(day<10)
				dayStr = "0"+day;
			else
				dayStr = "" + day;
			if(month<10)
				monthStr = "0" + month;
			else
				monthStr = "" + month;
			ChristianEra = dayStr+ "/" + monthStr + "/" + yearNumber;
			log.debug(" << New ChristianEra =  day/month/yyyy  = " + ChristianEra  + "  >> " );			
		}

		int firstIndex = ChristianEra.length() - 4;
		int yearNumber = Integer.parseInt(ChristianEra.substring(firstIndex));
		int buddhistYear = yearNumber + 543;
		
		String buddhistEra = "";
		
		if (style == DateFormat.FULL) {
			buddhistEra =
				ChristianEra.substring(0, firstIndex - 5)
					+ "?.?. "
					+ Integer.toString(buddhistYear);
		} else {
			buddhistEra =
				ChristianEra.substring(0, firstIndex) + Integer.toString(buddhistYear);
		}
		return buddhistEra;
	}
	/** @modelguid {D55AD325-A39E-42B8-BD9D-69CB3EDF7E98} */
	public static String ifBlank(String inputData, String outputData){
		 
		if (inputData == null || inputData.trim().equals(""))
			return outputData;
		else
			return inputData;
	}
	/** @modelguid {5FF39024-EDBC-47B6-8D10-A5506565795F} */
	public static String ifNull(String inputData, String outputData){
		 
		if (inputData == null)
			return outputData;
		else
			return inputData;
	}
	/** @modelguid {969B3308-C2EE-42B0-B440-C89F987776F3} */
	public static String numberFormat(int input) {
		String output = "";
		String remain = Integer.toString(input);
		if (remain.length() > 3) {
			for (int i = 0; i < remain.length() && remain.length() > 3; i++) {
				int index = remain.length();
				int position = index - 3;
				String str1 = remain.substring(0, position);
				output = "," + remain.substring(position, remain.length()) + output;
				remain = str1;
				if (remain.length() < 3)
					output = remain + output;
			}
			return output;
		}
		return Integer.toString(input);
	}
	
        
	/** @modelguid {64A6AB90-6D32-47FE-AA88-47789C8E9BFF} */
	public static String numberFormat(double input,String format) {
			String output = "";
			output=(new DecimalFormat(format)).format(input);
			return output;
	}

        public static String numberFormat(long input,String format) {
                    String output = "";
                    output=(new DecimalFormat(format)).format(input);
                    return output;
        }
        
        public static String bigDecimalToStringFormat(BigDecimal bigDecimal,String format){
            DecimalFormat decimalFormat = new DecimalFormat(format);
            return decimalFormat.format(bigDecimal);
        }

	/** @modelguid {C8151723-B1CF-4CE5-AB1D-13816F46CB40} */
	public static double cnvStringToNumber(String input){
		String outputStr="0";
		if (( input != null) && (input.length()>0 ))
			outputStr = replaceStrWithStr(input,",","");
		return Double.parseDouble(outputStr);
	}	

        public static BigDecimal cnvStringToBigDecimal(String input, int scale){
		String outputStr="0";
		if (( input != null) && (input.length()>0 ))
			outputStr = replaceStrWithStr(input,",","");
		BigDecimal result = new BigDecimal(outputStr);
                return result.setScale(scale, BigDecimal.ROUND_FLOOR);
	}
        
        public static BigDecimal cnvStringToBigDecimalWithRoundingMode(String input, int scale,int roundingMode){
		String outputStr="0";
		if (( input != null) && (input.length()>0 ))
			outputStr = replaceStrWithStr(input,",","");
		BigDecimal result = new BigDecimal(outputStr);
                return result.setScale(scale,roundingMode);
	}
        
        public static long cnvStringToLongNumber(String input){
            String outputStr="0";
            if (( input != null) && (input.length()>0 ))
                    outputStr = replaceStrWithStr(input,",","");

            return Long.parseLong(outputStr);
        }       
        public static double cnvStringToDouble(String input){
            String outputStr="0";
            if (( input != null) && (input.length()>0 ))
                    outputStr = replaceStrWithStr(input,",","");
            return Double.parseDouble(outputStr);
        }
        public static int cnvStringToIntNumber(String input){
            String outputStr="0";
            if (( input != null) && (input.length()>0 ))
                    outputStr = replaceStrWithStr(input,",","");
            return Integer.parseInt(outputStr);
        }

	
	// for separate input string follow by input  and add to return vector
	/** @modelguid {D94E2FF4-F0F0-4BB1-A683-06FC45BBC391} */
	public static String replaceStrWithStr(
		String inputData,
		String originalStr,
		String replaceStr) {

		StringBuffer outputData = new StringBuffer();
		if (inputData.length() > 0) {
			while (inputData.length() > 0) {
				int index = inputData.indexOf(originalStr);
				if (index == -1)
					return outputData.append(inputData).toString();
				else {
					outputData.append(inputData.substring(0, index));
					outputData.append(replaceStr);
				}
				inputData = inputData.substring(index + originalStr.length());
			}
		}
		return outputData.toString();
	}
	// for separate input string and add to return vector
	/** @modelguid {5AD42D18-3E41-43BD-82B6-ED1F99885738} */
	public static Vector separateString(String inputData) {
		Vector inputVector = new Vector();
		if (inputData.length() > 0) {
			while (inputData.length() > 0) {
				int index = inputData.indexOf('^');
				String zzz = inputData.substring(0, index);
				if (zzz.length() > 0)
					inputVector.addElement(zzz);
				else
					inputVector.addElement(null);
				inputData = inputData.substring(index + 1);
			}
		}
		return inputVector;
	}
	// for separate input string follow by input  and add to return vector
	/** @modelguid {F0729C02-4D70-4C66-B3FE-3DA558D4E213} */
	public static Vector separateString(String inputData, String separator) {
		Vector inputVector = new Vector();
		if (inputData.length() > 0) {
			while (inputData.length() > 0) {
				int index = inputData.indexOf(separator);
				log.debug(" index ="+index);
				if(index==-1){
					if (inputData.length() > 0)
						inputVector.addElement(inputData);
					else
						inputVector.addElement(null);		
					inputData = "";
				}else {
					log.debug(" inputData ="+inputData);
					String zzz = inputData.substring(0, index);
					log.debug(" zzz ="+zzz);
					if (zzz.length() > 0)
						inputVector.addElement(zzz);
					else
						inputVector.addElement(null);					
					inputData = inputData.substring(index + 1);
				}
			}
		}
		return inputVector;
	}

	/** @modelguid {9EDCCE2A-6EBE-4652-AA69-AD7B738EEB75} */
	public static Vector separateSQLString(String inputData, String separator) {
		Vector inputVector = new Vector();
//		int length = inputData.length();
		if (inputData.length() > 0) {
			while (inputData.length() > 0) {
				int index = -1;
				index = inputData.indexOf(separator);
				if ( index ==  -1)
				{
					inputVector.addElement(inputData);
					inputData = "";
				}
				else
				{					
					String zzz = inputData.substring(0, index);
					inputVector.addElement(zzz);
					//log.debug(" zzz ="+zzz);					
					inputData = inputData.substring(index + 1);					
				}					
			}
		}
		return inputVector;
	}

	/**
	 * Validate the date string is corrected date value.
	 	Example.
		1. 33/04/2002  is false
		2. 28/02/2002  is true
		3. 28/13/2002  is false
		4. 29/02/2002  is false 
	 * @return boolean true if corrected date.
	 * @param inputDate the date string.
	 * @modelguid {B551AE20-AFDF-475F-99D0-8F0317F1BCBB}
	 */
	public static boolean validateDate(String inputDate) {
		if (inputDate.indexOf("/") < 0)
			return false;

		java.util.Calendar calendarObj = java.util.Calendar.getInstance(Locale.ENGLISH);

		int dayInt = Integer.parseInt(inputDate.substring(0, inputDate.indexOf("/")));
		inputDate = inputDate.substring(inputDate.indexOf("/") + 1);
		int monthInt = Integer.parseInt(inputDate.substring(0, inputDate.indexOf("/")));
		int yearInt = Integer.parseInt(inputDate.substring(inputDate.indexOf("/") + 1));

		calendarObj.set(yearInt, monthInt - 1, dayInt);
		int day = calendarObj.get(java.util.Calendar.DAY_OF_MONTH);
		int month = calendarObj.get(java.util.Calendar.MONTH) + 1;
		int year = calendarObj.get(java.util.Calendar.YEAR);

		//	Debug.println("<<source>> = " + dayInt + "/" + monthInt +"/" + yearInt  + " <<new>> = " + day + "/" + month +"/" + year);

		if (dayInt == day && monthInt == month && yearInt == year)
			return true;
		else
			return false;

	}

	/**
	 * Build the day,month and year into the date string using given pattern.
	 * @param pDD the day string.
	 * @param pMM the month string.
	 * @param pYY the year string.
	 * @param pFormat the date format pattern.
	 * @param pYearLength the length of year.
	 **/
	/**
	* Example1 : buildNewFormat("25","01","2545","dd/MM/yyyy",4) returns 25/01/2545
	* Example2 : buildNewFormat("25","01","2002","dd/MM/yyyy",4) returns 25/01/2002
	* Example3 : buildNewFormat("25","01","02","dd/MM/yyyy",2) returns 25/01/02
	* @modelguid {39EE6B34-5B8B-4430-965C-D689A7EA81F6}
	**/
	private static String buildNewFormat(
		String pDD,
		String pMM,
		String pYY,
		String pFormat,
		int pYearLength) {

		pFormat = pFormat.toUpperCase();
		char cFormat[] = pFormat.toCharArray();
		int i;
		StringBuffer result = new StringBuffer();

		for (i = 0; i < cFormat.length; i++) {
			if (cFormat[i] == 'D') {
				result.append(pDD);
				i++;
			} else
				if (cFormat[i] == 'M') {
					result.append(pMM);
					i++;
				} else
					if (cFormat[i] == 'Y') {
						result.append(pYY);
						i = i + pYearLength;
					} else
						result.append(cFormat[i]);

		}
		return result.toString();

	}
	/**
	 * Converts the date-time string from old pattern into target pattern.
	 * Example :changeDateFormat("25/01/2545","dd/MM/yyyy","yyyy/mm/dd") returns 2545/01/25
	 * @return the formatted date-time string or null if the input date is not corrected.
	 * @param pDateValue the date-time string to be formatted into new pattern.
	 * @param formatSource the source pattern.
	 * @param formatTarget the target pattern.
	 * @modelguid {CDD398F0-F645-470D-BFCD-B90D6A2A5253}
	 **/
	public static String changeDateFormat(
		String pDateValue,
		String formatSource,
		String formatTarget) {

		String result = null;
		try {
			// Convert format content to upper case
			formatSource = formatSource.trim().toUpperCase();
			formatTarget = formatTarget.trim().toUpperCase();

			// Find each position of day, month and year of source format
			int indSrcFirstD = formatSource.indexOf('D');
			int indSrcLastD = formatSource.lastIndexOf('D');
			int indSrcFirstM = formatSource.indexOf('M');
			int indSrcLastM = formatSource.lastIndexOf('M');
			int indSrcFirstY = formatSource.indexOf('Y');
			int indSrcLastY = formatSource.lastIndexOf('Y');

			// determine target year length; 2 or 4 digits
			int indTrgLastY = formatTarget.lastIndexOf('Y');
			int indTrgFirstY = formatTarget.indexOf('Y');
			int trgYearLength = indTrgLastY - indTrgFirstY;

			// put data into target format
			String sDD = pDateValue.substring(indSrcFirstD, indSrcLastD + 1);
			String sMM = pDateValue.substring(indSrcFirstM, indSrcLastM + 1);
			String sYY = pDateValue.substring(indSrcFirstY, indSrcLastY + 1);

			// get result using internal private method
			result = buildNewFormat(sDD, sMM, sYY, formatTarget, trgYearLength);

		} catch (Exception ex) {
		    log.debug("changeDateFormat::Exception::"+ex.toString());
		}

		return result;

	}
	/**
	 * Get the current date string using given pattern.
	 * Example : currentDate("dd/MM/yyyy"); returns  25/01/2002 
	 * @return date-time string. 
	 * @param pDateFormat the date format pattern.
	 * @modelguid {23BB92C0-7A2C-4FBE-B072-640816E787CC}
	 */
	public static String currentDate(String pDateFormat) {
		String result = null;
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pDateFormat,Locale.ENGLISH);
			result = dateFormatter.format(new java.util.Date());
		} catch (Exception ex) {
                    log.debug("currentDate::Exception::"+ex.toString());
		}

		return result;
	}
	
	public static String currentDateBE(String pDateFormat) {
		String result = currentDate(pDateFormat);
		result = dateStringAD2BE(result,pDateFormat);
		return result;
	}
	/**
	 * Get the current time string using given pattern.
	 * Example : currentTime("HH:mm:ss") ; returns 23:25:12
	 * @return the current time string.
	 * @param pTimeFormat the time format pattern.
	 * @modelguid {432BE8AD-C2B8-41B1-8957-87B3D2595269}
	 **/
	public static String currentTime(String pTimeFormat) {
		String result = null;
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pTimeFormat);
			result = dateFormatter.format(new java.util.Date());
		} catch (Exception ex) {
                    log.debug("currentTime::Exception::"+ex.toString());
		}

		return result;
	}
	/**
	 * Converts date-time value to date-time string using given pattern.
	 * Example : dateSql2DateString("2002-01-25","dd/MM/yyyy HH:mm:SS"); return 25/01/2002 00:00:00
	 * @return the formatted date-time string.
	 * @param pDateValue the date-time value to be formatted into a date-time string.
	 * @param pDateFormat the date format pattern.
	 * @modelguid {509CF43D-933F-4105-9D7D-6CBD48D440C1}
	 **/
	public static String dateSql2DateString(
		java.sql.Date pDateValue,
		String pDateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(pDateFormat,Locale.ENGLISH);
		return formatter.format(pDateValue);
	}
	/**
	 * Converts date-time string to date-time value using given pattern.
	 * Example: java.util.Date dateUtil = dateString2DateUtil("25/01/02 10:30","dd/MM/yy HH:mm");
	 * return ==> Fri Jan 25 10:30:00 GMT+07:00 2002
	 * @return the date-time value.
	 * @param pDateValue the date-time string to be formatted into a date-time value.
	 * @param pDateFormat the date format pattern of the date-time string to be formatted.
	 * @modelguid {4048E2F8-2CEB-4693-8658-85FFF2B64AF8}
	 **/
	public static Date dateString2DateUtil(
		String pDateValue,
		String pDateFormat) {

		java.util.Date result = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pDateFormat,Locale.ENGLISH);
			ParsePosition pos = new ParsePosition(0);
			result = formatter.parse(pDateValue, pos);
		} catch (Exception ex) {
                    log.debug("dateString2DateUtil::Exception::"+ex.toString());
		}

		return result;
	}
	/**
	 * Converts date-time string from Ad to BE using given pattern.
	 * Example : dateStringAd2Be(25/01/2002,"dd/MM/yyyy") returns 25/01/2545 
	 * @return the formatted date-time string in BE.
	 * @param pDateValue the date-time string to be formatted into BE.
	 * @param pDateFormat the date format pattern.
	 * @modelguid {EF7DD7E3-73DF-4F75-B327-DFFAE82D5982}
	 **/
	public static String dateStringAD2BE(String pDateValue, String pDateFormat) {
		if ((pDateValue != null) && (pDateValue.length()>0) )
		{
			// Convert format content to upper case
			pDateFormat = pDateFormat.trim().toUpperCase();

			// Find each position of day, month and year of source format
			int indSrcFirstD = pDateFormat.indexOf('D');
			int indSrcLastD = pDateFormat.lastIndexOf('D');
			int indSrcFirstM = pDateFormat.indexOf('M');
			int indSrcLastM = pDateFormat.lastIndexOf('M');
			int indSrcFirstY = pDateFormat.indexOf('Y');
			int indSrcLastY = pDateFormat.lastIndexOf('Y');
			int trgYearLength = indSrcLastY - indSrcFirstY;
			// put data into target format
			String sDD = pDateValue.substring(indSrcFirstD, indSrcLastD + 1);
			String sMM = pDateValue.substring(indSrcFirstM, indSrcLastM + 1);
			String sYY = pDateValue.substring(indSrcFirstY, indSrcLastY + 1);
			int iYY = Integer.parseInt(sYY);
			iYY = iYY + 543;
			sYY = String.valueOf(iYY);
			return buildNewFormat(sDD, sMM, sYY, pDateFormat, trgYearLength);
		}
		else	
			return "";		
	}
	/** 
	 * Converts date-time string from BE to AD using given format pattern.
	 * Example : dateStringBE2AD("25/01/2545","dd/MM/yyyy") returns  25/01/2002
	 * @return the formatted date-time string in BE.
	 * @param pDateValue the date-time string to be formatted into AD.
	 * @param pDateFormat the date format pattern.
	 * @modelguid {FC8880FB-8D37-4411-95EE-49FA7C1B11D7}
	 */
	public static String dateStringBE2AD(String pDateValue, String pDateFormat) {
		
		if ((pDateValue != null) && (pDateValue.length()>0) )
		{
			// Convert format content to upper case
			pDateFormat = pDateFormat.trim().toUpperCase();

			// Find each position of day, month and year of source format
			int indSrcFirstD = pDateFormat.indexOf('D');
			int indSrcLastD = pDateFormat.lastIndexOf('D');
			int indSrcFirstM = pDateFormat.indexOf('M');
			int indSrcLastM = pDateFormat.lastIndexOf('M');
			int indSrcFirstY = pDateFormat.indexOf('Y');
			int indSrcLastY = pDateFormat.lastIndexOf('Y');
			int trgYearLength = indSrcLastY - indSrcFirstY;

			// put data into target format
			String sDD = pDateValue.substring(indSrcFirstD, indSrcLastD + 1);
			String sMM = pDateValue.substring(indSrcFirstM, indSrcLastM + 1);
			String sYY = pDateValue.substring(indSrcFirstY, indSrcLastY + 1);
			int iYY = Integer.parseInt(sYY);
			iYY = iYY - 543;
			sYY = String.valueOf(iYY);
	
			return buildNewFormat(sDD, sMM, sYY, pDateFormat, trgYearLength);
		}
		else
			return "";	
	}
	/**
	 * Converts date-time value to date-time string using given pattern.
	 * Example : dateUtil2DateString(Fri Jan 25 16:37:15 GMT+07:00 2002,"dd/MM/yyyy HH:mm:ss") = 25/01/2002 16:37:15
	 * @return the formatted date-time string.
	 * @param pDateValue the date-time value to be formatted into a date-time string.
	 * @param pDateFormat the date format pattern.
	 * @modelguid {3098BBE6-9BAE-4C7F-A20C-C1A77D5C0953}
	 */
	public static String dateUtil2DateString(
		java.util.Date pDateValue,
		String pDateFormat) {
		if (pDateValue != null)  
		{			
			SimpleDateFormat formatter = new SimpleDateFormat(pDateFormat,Locale.ENGLISH);
			return formatter.format(pDateValue);
		}
		else
			return "";	
	}
	
	/** @modelguid {95CE7FC5-3005-46AD-B807-EE29C004FB5E} */
	public static String dateSql2DateStringBE(
		java.sql.Date pDateValue,
		String pDateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(pDateFormat);
		return dateStringAD2BE(formatter.format(pDateValue), pDateFormat);
	}
	
	
	/**
	 * Insert the method's description here.
	 * Creation date: (1/1/01 12:43:30)
	 * @return java.lang.String
	 * @modelguid {F24D89F3-ABA4-4DDD-88B8-23CA5DAB7458}
	 */
	public static String getDayForPrint(String aDD) {
		int iDD;
		String sDD;
		try {
			iDD = Integer.parseInt(aDD);
			if (iDD < 10)
				sDD = " " + iDD;
			else
				sDD = aDD;
		} catch (Exception ex) {
			sDD = aDD;
		}
		return sDD;
	}
	/**
	 * Converts month from int to the thai month description.
	 * @return month string in thai description.
	 * @param aMM the month which you want to get name in thai.
	 * @modelguid {30EAD5E3-C5C5-47E8-90DA-25A5495D5F5E}
	 */
	public static String getThaiMonth(String aMM) {
		String month[] =
                {
                        "���Ҥ�",
                        "����Ҿѹ��",
                        "�չҤ�",
                        "����¹",
                        "����Ҥ�",
                        "�Զع�¹",
                        "�á�Ҥ�",
                        "�ԧ�Ҥ�",
                        "�ѹ��¹",
                        "���Ҥ�",
                        "��Ȩԡ�¹",
                        "�ѹ�Ҥ�" };
                    String sMonth;
		try {
			int iMM = Integer.parseInt(aMM) - 1;
			sMonth = month[iMM].trim();
		} catch (Exception ex) {
			sMonth = "            ";
		}

		return sMonth;

	}

	public static String getAbbrThaiMonth(String aMM) {
		String month[] =
			{
                        "�.�.",
                        "�.�.",
                        "��.�.",
                        "��.�.",
                        "�.�.",
                        "��.�.",
                        "�.�.",
                        "�.�.",
                        "�.�.",
                        "�.�.",
                        "�.�.",
                        "�.�." };
		String sMonth;
		try {
			int iMM = Integer.parseInt(aMM) - 1;
			sMonth = month[iMM].trim();
		} catch (Exception ex) {
			sMonth = "            ";
		}

		return sMonth;

	}

	
	/**
	 * Converts date-time value to date-time string using the given pattern .
	 * Example : timeStamp2DateString(2002-01-25 20:25:00.0, "dd/MM/yyyy HH:mm:ss") = 25/01/2002 20:25:00
	 * @return the formatted date-time string.
	 * @param pDateValue the date-time value to be formatted into a date-time string.
	 * @param pDateFormat the date format pattern.
	 * @modelguid {28304412-2139-43A3-BA5A-414F8252E94D}
	 **/
	public static String timeStamp2DateString(
		java.sql.Timestamp pDateValue,
		String pDateFormat) {

		SimpleDateFormat formatter = new SimpleDateFormat(pDateFormat);
		return formatter.format(pDateValue);

	}
	/**
	 * Validate date-time string using the given pattern .
	 * Example. validateDate("31/11/2545", "dd/MM/yyyy") = false
	 * @return true if date-time string is the correctted date which corresponsed with the given pattern.
	 * @param pDateValue the date-time string.
	 * @param pDateFormat the date format pattern.
	 * @modelguid {22903711-D814-4791-8E2C-1EF8E63CF0D3}
	 **/
	public static boolean validateDate(String pDateValue, String pDateFormat) {
		boolean result = true;
		int iDD = 0;
		int iMM = 0;
		int iYY = 0;
		int aDays[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int indFirstD = pDateFormat.indexOf('D');
		int indLastD = pDateFormat.lastIndexOf('D');
		int indFirstM = pDateFormat.indexOf('M');
		int indLastM = pDateFormat.lastIndexOf('M');
		int indFirstY = pDateFormat.indexOf('Y');
		int indLastY = pDateFormat.lastIndexOf('Y');
		try {
			iDD = Integer.parseInt(pDateValue.substring(indFirstD, indLastD + 1));
			iMM = Integer.parseInt(pDateValue.substring(indFirstM, indLastM + 1));
			iYY = Integer.parseInt(pDateValue.substring(indFirstY, indLastY + 1));
		} catch (Exception ex) {
			result = false;
		}

		// check Febuary has 28 or 29 days
		if (iYY > 2400)
			iYY = iYY - 543;
		if (iMM == 2)
			if ((iYY % 4 == 0) && !(iYY % 100 == 0))
				aDays[2] = 29;
		// check date
		if (result) {
			if (iMM > 0 && iMM < 13)
				if (iYY > 1900 && iYY < 2700)
					if (iDD > 0 && iDD <= aDays[iMM]) {						 
					} else {
						result = false;
                                        }
				else
					result = false;
			else
				result = false;

		}

		return result;
	}

	/** @modelguid {B8025572-6875-4FC0-83CA-1F8EEA5A8E25} */
	public static byte[] stringToBytes(String str) {
		char[] ch = str.toCharArray();
		byte[] b = new byte[ch.length];
		int ptr = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 0x0e00 && ch[i] <= 0x0eff) {
				b[ptr++] = (byte) (ch[i] - 0x0e00 + 0x00a0);
			} else {
				b[ptr++] = (byte) (ch[i] - 0x0000);
			}
		}
		return b;
	}

	/*
		return false if found special character.
	 * @modelguid {243DCE72-C98A-4F67-B218-6E52E6CA7187}
	*/
	public static boolean isNameEng(String s) {
		byte[] b = s.getBytes();
		int i = 0;
		for (i = 0; i < b.length; i++) {
			int bi = ((int) (b[i])) & 0x00ff;
			//Debug.println(Integer.toHexString(bi));
			//Debug.println("<0x41");
			if (bi < 0x41 && bi != 0x20)
				return false;
			// >= 0x41
			//Debug.println("<0x61");
			if ((bi > 0x5a) && (bi < 0x61))
				return false;
			if (bi > 0x7a)
				return false;
			// >=61
			//Debug.println(">0x7a && <0xa1");
			/*			if ( (bi>0x7a) && (bi<=0xd9)) return false;
						if ( (bi>=0xe0) && (bi<=0xec)) return false;
						//Debug.println(">0xd9 && <0xe0");
						if ( (bi>0xd9) && (bi<0xe0)) return false;
						//Debug.println(">0xec");
						if (bi>0xec) return false;
			*/
		}
		return true;
	}
	/*
		return false if found special character.
	 * @modelguid {86C0CD97-EE5A-43C5-BE6E-78A6DBDD1D55}
	*/
	public static boolean isNameThai(String s) {
		byte[] b = s.getBytes();
		int i = 0;
		for (i = 0; i < b.length; i++) {
			int bi = ((int) (b[i])) & 0x00ff;
			//Debug.println(Integer.toHexString(bi));
			//Debug.println("<0x41");
			//			if ( bi<0x41) return false;
			// >= 0x41
			//Debug.println("<0x61");
			//			if (bi<0x61) return false;
			// >=61
			//Debug.println(">0x7a && <0xa1");
			//			if ( (bi>0x7a) && (bi<0xa1)) return false;
			if (bi < 0xa1 && bi != 0x20)
				return false;
			//Debug.println(">0xd9 && <0xe0");
			if ((bi > 0xd9) && (bi < 0xe0))
				return false;
			//Debug.println(">0xec");
			if (bi > 0xec)
				return false;
		}
		return true;
	}

	/*
	strspn searches the string <code>s<code> for the first occurrence of 
	a character that included in the string <code>set<code>
	return: 
		position of the first occurence if found 
		-1 for not found
	 * @modelguid {CA9158CB-49BD-49D3-8AA1-DDC0B879AAA1}
	*/
	public static int strspn(String s, String set) {
		byte[] bs = s.getBytes();
		byte[] bset = set.getBytes();
		int i, j;
		for (i = 0; i < bs.length; i++) {
			for (j = 0; j < bset.length; j++) {
				if (bs[i] == bset[j])
					break;
			}
			if (j < bset.length)
				break;
		}
		if (i < bs.length)
			return i;
		else
			return -1;
	}

	public static String lastDayOfMonth(String dateStr , String lang){
		String lastDay = "";
		try {
			if (dateStr != null && dateStr.trim().length()>0){
				if (lang== null) lang = "T" ;
				if (!(lang.equalsIgnoreCase("T") || lang.equalsIgnoreCase("E"))) lang = "T" ;
				if (lang.equalsIgnoreCase("T"))
					dateStr = IPFMUtils.dateStringBE2AD(dateStr,"dd/mm/yyyy");
				Date d = IPFMUtils.cnvStringToDate(dateStr);
				Calendar cal = Calendar.getInstance(Locale.ENGLISH);
				cal.setTime(d);
				cal.set(Calendar.DAY_OF_MONTH,1);
				cal.add(Calendar.MONTH,1) ;
				cal.add(Calendar.DAY_OF_MONTH,-1) ;
				Date newDate = cal.getTime();
				if (lang.equalsIgnoreCase("T"))
					lastDay =   new SimpleDateFormat("dd/MM/",Locale.ENGLISH).format(newDate) + Integer.toString(  cal.get(Calendar.YEAR) + 543) ;
				else	
					lastDay =   new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).format(newDate);					
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return lastDay ;
	}
	
	
	/**
	 * Insert the method's description here.
	 * Creation date: (30/11/00 22:22:06)
	 * @param args java.lang.String[]
	 * @modelguid {D30F57ED-CE1C-4919-A152-162ADB2239BF}
	 */
	public static void main(String[] args) {

		try {
			
			String dateStr = "";
			if (args.length > 0)
				dateStr = args[0];
			else
				dateStr = "25/01/2002";

			Date utilDate = IPFMUtils.cnvStringToDate(dateStr);

			String dateTemp = IPFMUtils.buildNewFormat("25", "01", "2002", "dd/MM/yyyy", 4);

			String strChangeDateFormat =
				IPFMUtils.changeDateFormat("25/01/2545", "dd/MM/yyyy", "yyyy/mm/dd");

			String strDate = IPFMUtils.currentDate("dd/MM/yyyy");

			String strTime = IPFMUtils.currentTime("HH:mm:ss");

			java.sql.Date dateSql = java.sql.Date.valueOf("2002-01-25");
			dateStr = IPFMUtils.dateSql2DateString(dateSql, "dd/MM/yyyy HH:mm:SS");

			utilDate = IPFMUtils.dateString2DateUtil("25/01/02 10:30", "dd/MM/yy HH:mm");

			java.util.Date dateUtil = new java.util.Date();
			String strUDate = IPFMUtils.dateUtil2DateString(dateUtil, "dd/MM/yyyy HH:mm:ss");


			java.sql.Timestamp timeStamp =
				java.sql.Timestamp.valueOf("2002-01-25 20:25:00.0");
			String strDateSql9 =
				IPFMUtils.timeStamp2DateString(timeStamp, "dd/MM/yyyy HH:mm:ss");
			boolean bValid = IPFMUtils.validateDate("31/11/2545", "dd/MM/yyyy");

		} catch (Exception ex) {
		}

	}
	/** @modelguid {AFADB088-0DA8-46D0-A660-1818DBFAA869} */
	public static java.sql.Date dateStringBE2DateSql(String pDateValue, String pDateFormat) {

		// Convert format content to upper case
		pDateFormat = pDateFormat.trim().toUpperCase();

		// Find each position of day, month and year of source format
		int indSrcFirstD = pDateFormat.indexOf('D');
		int indSrcLastD = pDateFormat.lastIndexOf('D');
		int indSrcFirstM = pDateFormat.indexOf('M');
		int indSrcLastM = pDateFormat.lastIndexOf('M');
		int indSrcFirstY = pDateFormat.indexOf('Y');
		int indSrcLastY = pDateFormat.lastIndexOf('Y');
		int trgYearLength = indSrcLastY - indSrcFirstY;

		// put data into target format
		String sDD = pDateValue.substring(indSrcFirstD, indSrcLastD + 1);
		String sMM = pDateValue.substring(indSrcFirstM, indSrcLastM + 1);
		String sYY = pDateValue.substring(indSrcFirstY, indSrcLastY + 1);
		int iYY = Integer.parseInt(sYY);
		iYY = iYY - 543;
		sYY = String.valueOf(iYY);

		String sDate = buildNewFormat(sDD, sMM, sYY, "yyyy-mm-dd", trgYearLength);
		return java.sql.Date.valueOf(sDate);
	}
    public static boolean isNumberic(String num) {
        try {        
            Double.parseDouble(num);        
            return true;    
        } catch (NumberFormatException e) {
            return false;    
        }
    }
    
    public static boolean isNumbericInteger(String num) {
        try {        
            Integer.parseInt(num);        
            return true;    
        } catch (NumberFormatException e) {
            return false;    
        }
    }
    
    public static double calculateRounded10Amount(double amount) {
		BigDecimal result = new BigDecimal(amount);
		BigDecimal ten = new BigDecimal(10);
		
		result = result.divide(ten);
		result = result.setScale(0, BigDecimal.ROUND_UP);
		result = result.multiply(ten);
		
		return result.doubleValue();
	}
    public static double calculateRoundedAmount(double amount) {
		BigDecimal result = new BigDecimal(amount);
		result = result.setScale(0, BigDecimal.ROUND_UP);
		return result.doubleValue();
	}
    public static double setScaleNAmount(double amount, int scale) {
		BigDecimal result = new BigDecimal(amount);
		result.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return result.doubleValue();
	}
    public static String stringCapitalize(String inputStr) {
        String[] strArray = inputStr.trim().replaceAll("\\n|\\r"," ").split(" ");
        String temp  = "";
        String first = "";
        String last  = "";
        String word  = "";
        for(int i=0;i<strArray.length;i++)
        {
            if(strArray[i].trim().length()>0)
            {
                word  = strArray[i].trim();
                first = new String(word.substring(0,1));
                last  = new String(word.substring(1));
                //first = first.toUpperCase();
                //last  = last.toLowerCase();                    
                temp+=first+last+" ";
            }
        }
        return temp.trim();
    }
    
    public static String stringCapitalize2(String inputStr) {
        String[] strArray = inputStr.trim().replaceAll("\\n|\\r"," ").split(" ");
        String temp  = "";
        String first = "";
        String last  = "";
        String word  = "";
        for(int i=0;i<strArray.length;i++)
        {
            if(strArray[i].trim().length()>0)
            {
                word  = strArray[i].trim();
                first = new String(word.substring(0,1));
                last  = new String(word.substring(1));
                first = first.toUpperCase();
                last  = last.toLowerCase();                    
                temp+=first+last+" ";
            }
        }
        return temp.trim();
    }
    
    public static String prepareItemName(String itemName){
        return itemName.replaceAll("'", "''");
    }
            
    public static boolean compareName(String name1, String name2){
        boolean result = false;
        if (name1 == null || name2 == null) return result;
        name1 = name1.replace(" ",""); 
        name2 = name2.replace(" ",""); 
        if (name1.trim().toUpperCase().compareTo(name2.trim().toUpperCase())==0)result = true;
        
        return result;
    }
    
    public static boolean pidCheckDigit(String id){
        if (id.length() != 13) {
            return false;
        }
        String fp ="";
        String sp = id;
        int ldg = Integer.parseInt(sp.substring(12));
        int sum = 0;
        int mult = 0;
        for (int i =0; i<12; i++){
            fp = sp.substring(0,1);
            sp = sp.substring(1);
            mult = Integer.parseInt(fp) * (13 - i);
            sum = sum + mult;
            //System.out.println(i + " " + fp + " " + mult + " " + sum);
        }
        int chkdg = 11 - (sum % 11);
        System.out.println("chkdg::"+chkdg+"::ldg::"+ldg);
        if(chkdg > 9) 
            chkdg = chkdg - 10;
        
        if (chkdg == ldg) return true;
        else return false;
    }

	/**
	 * Calculate time between two date .
	 * Example. dateDuration(startTime,endTime) will returns in format 08:30:00
	 * @return the time in the String format.
	*/
    public static String dateDuration(Date startTime, Date endTime) throws Exception {
        long  diff = endTime.getTime() - startTime.getTime();
        String result =String.valueOf( diff / (60 * 60 * 1000))+":"
                + String.valueOf((diff % (60 * 60 * 1000))/(60 * 1000)+100).substring(1) +":"
                + String.valueOf((((diff % (60 * 60 * 1000))%(60 * 1000))/1000)+100).substring(1) ;
        return result;
    }
    
    public static String validateServicePort(String str){
    	String resultValidate = "";
    	try{
				String sp[] = str.replaceAll(" ", "").split(",");
				Map<Integer,Integer> result = new HashMap<Integer, Integer>();
				List<String> serviceList = new ArrayList<String>();
				for(String spData : sp){			
					int min = 0;
					int max = 0;
					String[] ser = spData.split("-");
					if(ser.length == 1){
						min = Integer.parseInt(ser[0]);
						max = Integer.parseInt(ser[0]);
					}else if(ser.length == 2){
						min = Integer.parseInt(ser[0]);
						max = Integer.parseInt(ser[1]);
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
						serviceList.add(a + "-"+def);
					}
					def = a;
				}
				serviceList.add(list.get(list.size() - 1) + "-"+list.get(list.size() - 1));
				
				for(int i = 0;i < (serviceList.size() -1);i++){
					String[] serviceSp1 = serviceList.get(i).split("-");
					String[] serviceSp2 = serviceList.get(i+1).split("-");
					if(serviceSp1[0].equals(serviceSp2[1])){
						resultValidate = resultValidate + "," + serviceSp1[0];
					}else{
						resultValidate = resultValidate + "," + serviceSp1[0] + "-" + serviceSp2[1];
					}
					
				}
				resultValidate = resultValidate.equals("")?"":resultValidate.substring(1);
    	}catch(Exception e){
    		resultValidate = str;
    	}
		
		return resultValidate;
	}

}
