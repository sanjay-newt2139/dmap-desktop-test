package th.co.ais.ehr.service;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

// For encrypt decrypt Authen DB
public class CSSDAuthen {
    private static HashMap errorMessage = new HashMap();
    private static boolean isInit = false;
    private static String _HASH ="SHA1";
    
    public static void printData(){
    	System.out.println("0x03 = " + 0x03);
    	System.out.println("0x0c = " + 0x0c);
    	System.out.println("0x30 = " + 0x30);
    	System.out.println("0xc0 = " + 0xc0);
    	
    	System.out.println("0x03 |0x0c |0x30| 0xc0 = " + (0x03 |0x0c |0x30| 0xc0));
    	String a = encrypt("username");
    	System.out.println("Encrypt = " + a);
    	System.out.println("Decrypt = " + decrypt(a));
    	
    }
    

	public static String encrypt(String text){
		
		byte [] results = null;
		String vector ="!@1B%cqD4(F+g7H/"; 
		BASE64Encoder encoder = null;
		
		try{
			byte [] plainTextBytes=text.getBytes("UTF-8");
			byte [] saltBytes =GenerateSalt();
			
			byte[] plainTextBytesWithSalt = new byte[plainTextBytes.length +saltBytes.length];
	
			System.arraycopy( saltBytes, 0,plainTextBytesWithSalt, 0,saltBytes.length);	
			System.arraycopy( plainTextBytes, 0,plainTextBytesWithSalt, saltBytes.length,plainTextBytesWithSalt.length-saltBytes.length);
	
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");	
			
			//setup key
			encoder = new BASE64Encoder();
			
			byte[] password = getKey();
		  	byte [] password32 = password;
		  	byte[] vectorbyte =vector.getBytes("ASCII");
			SecretKeySpec keySpec = new SecretKeySpec(password32, "AES");
			
			//the below may make this less secure, hard code byte array the IV in both java and .net clients
			IvParameterSpec ivSpec = new IvParameterSpec(vectorbyte);
			//cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
			cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);
			results = cipher.doFinal(plainTextBytesWithSalt);
		}catch(Exception e){
			e.printStackTrace();
		}
			return encoder.encode(results);
	}
	
	public static String encrypt(String text,byte[] password){
		
		byte [] results = null;
		String vector ="!@1B%cqD4(F+g7H/"; 
		BASE64Encoder encoder = null;
		
		try{
			byte [] plainTextBytes=text.getBytes("UTF-8");
			byte [] saltBytes =GenerateSalt();
			
			byte[] plainTextBytesWithSalt = new byte[plainTextBytes.length +saltBytes.length];
	
			System.arraycopy( saltBytes, 0,plainTextBytesWithSalt, 0,saltBytes.length);	
			System.arraycopy( plainTextBytes, 0,plainTextBytesWithSalt, saltBytes.length,plainTextBytesWithSalt.length-saltBytes.length);
	
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");	
			
			//setup key
			encoder = new BASE64Encoder();
			
		  	byte [] password32 = password;
		  	byte[] vectorbyte =vector.getBytes("ASCII");
			SecretKeySpec keySpec = new SecretKeySpec(password32, "AES");
			
			//the below may make this less secure, hard code byte array the IV in both java and .net clients
			IvParameterSpec ivSpec = new IvParameterSpec(vectorbyte);
			//cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
			cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);
			results = cipher.doFinal(plainTextBytesWithSalt);
		}catch(Exception e){
			e.printStackTrace();
		}
			return encoder.encode(results);
	}
	
	public static String decrypt(String text){
		
		byte [] results;
		String data = "";
		String vector ="!@1B%cqD4(F+g7H/"; 
		byte [] password;
		
		try{
			password = getKey();	
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");	
		  	byte[] vectorbyte =vector.getBytes("ASCII");
		  	byte [] password32 = password;
		  	
		  	SecretKeySpec keySpec = new SecretKeySpec(password32, "AES");
		  	IvParameterSpec ivSpec = new IvParameterSpec(vectorbyte);
		  	cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
			BASE64Decoder decoder = new BASE64Decoder();
			results = cipher.doFinal(decoder.decodeBuffer(text));
			int saltLen =   (results[0] & 0x03) |
			(results[1] & 0x0c) |
			(results[2] & 0x30) |
			(results[3] & 0xc0);
			
			byte [] plainTextBytes = new byte[results.length - saltLen];
				
			
			System.arraycopy(results, saltLen, plainTextBytes, 
				0, results.length - saltLen);
			
			data = new String(plainTextBytes,"UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			data = e.getMessage();
		}
			//System.out.println("Decryption value is " + data);
			return data;
	}
	
	public static String decrypt(String text,byte [] password){
		
		byte [] results;
		String data = "";
		String vector ="!@1B%cqD4(F+g7H/"; 
		
		try{
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");	
		  	byte[] vectorbyte =vector.getBytes("ASCII");
		  	byte [] password32 = password;
		  	
		  	SecretKeySpec keySpec = new SecretKeySpec(password32, "AES");
		  	IvParameterSpec ivSpec = new IvParameterSpec(vectorbyte);
		    cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
			BASE64Decoder decoder = new BASE64Decoder();
			results = cipher.doFinal(decoder.decodeBuffer(text));
			
			int saltLen =   (results[0] & 0x03) |
			(results[1] & 0x0c) |
			(results[2] & 0x30) |
			(results[3] & 0xc0);
	
			byte [] plainTextBytes = new byte[results.length - saltLen];	
			System.arraycopy(results, saltLen, plainTextBytes, 
				0, results.length - saltLen);
			
			data = new String(plainTextBytes,"UTF-8");
		}catch(Exception e){	
			data = e.toString();
		}
			System.out.println("Decryption value is " + data);
			return data;
	}
	
	
	
	
	/*public static byte [] md5sum(byte [] buffer) {
	    try {
	        MessageDigest md5 = MessageDigest.getInstance("MD5");
	        md5.update(buffer);
	        return md5.digest();
	    } catch (NoSuchAlgorithmException e) {
	        errorExit("AES Algorithm not available on this VM");
	    }
	    return null;
	}*/
	
	/*public static void errorExit(String s) {
	    System.out.println(s);
	    System.exit(0);
	}*/
	
	
	private static byte[] GenerateSalt()
	{
		// We don't have the length, yet.
		int saltLen = 0;
		saltLen = GenerateRandomNumber(4, 8);
	
		// Allocate byte array to hold our salt.
		byte[] salt = new byte[saltLen];
	
		// Populate salt with cryptographically strong bytes.
		//RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider();
	
		//rng.GetNonZeroBytes(salt);
	
		// Split salt length (always one byte) into four two-bit pieces and
		// store these pieces in the first four bytes of the salt array.
	
		try{
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.nextBytes(salt); 
		}catch(Exception e){
			e.printStackTrace();
		}
		salt[0] = (byte)((salt[0] & 0xfc) | (saltLen & 0x03));
		salt[1] = (byte)((salt[1] & 0xf3) | (saltLen & 0x0c));
		salt[2] = (byte)((salt[2] & 0xcf) | (saltLen & 0x30));
		salt[3] = (byte)((salt[3] & 0x3f) | (saltLen & 0xc0));

		return salt;
	}
	
	private static int GenerateRandomNumber(int min,int max)
	{
		//Random rand = new Random();
		SecureRandom rand = new SecureRandom();
	//	 No. 1 Random integers
		//int randnum = rand.nextInt();
	//	 No. 2 Generating random integers from 0 to 10
		
		
		int randnum = rand.nextInt();
		 if(randnum < 0){
			 randnum= randnum * -1;
		 }
		randnum = (randnum%(max-min))+min;
		return randnum;
	}
	
//	
	private static void  initKey(){
		errorMessage = new HashMap();
		if(_HASH=="MD5"){
			errorMessage.put( "0",new byte[] {(byte)57 ,(byte)236 ,(byte)11 ,(byte)221 ,(byte)100 ,(byte)69 ,(byte)37 ,(byte)26 ,(byte)136 ,(byte)7 ,(byte)68 ,(byte)103 ,(byte)242 ,(byte)155 ,(byte)137 ,(byte)85 ,(byte)159 ,(byte)222 ,(byte)126 ,(byte)35 ,(byte)169 ,(byte)43 ,(byte)18 ,(byte)70 ,(byte)218 ,(byte)169 ,(byte)173 ,(byte)124 ,(byte)58 ,(byte)72 ,(byte)47 ,(byte)195});
			errorMessage.put( "1",new byte[] {(byte)74 ,(byte)41 ,(byte)247 ,(byte)244 ,(byte)221 ,(byte)77 ,(byte)31 ,(byte)22 ,(byte)184 ,(byte)151 ,(byte)26 ,(byte)120 ,(byte)56 ,(byte)46 ,(byte)219 ,(byte)53 ,(byte)228 ,(byte)217 ,(byte)242 ,(byte)121 ,(byte)29 ,(byte)87 ,(byte)55 ,(byte)219 ,(byte)65 ,(byte)139 ,(byte)37 ,(byte)35 ,(byte)187 ,(byte)75 ,(byte)196 ,(byte)175});
			errorMessage.put( "2",new byte[] {(byte)193 ,(byte)198 ,(byte)216 ,(byte)202 ,(byte)23 ,(byte)148 ,(byte)253 ,(byte)198 ,(byte)202 ,(byte)18 ,(byte)221 ,(byte)61 ,(byte)134 ,(byte)143 ,(byte)199 ,(byte)31 ,(byte)232 ,(byte)125 ,(byte)158 ,(byte)64 ,(byte)100 ,(byte)20 ,(byte)40 ,(byte)172 ,(byte)102 ,(byte)208 ,(byte)16 ,(byte)29 ,(byte)146 ,(byte)204 ,(byte)162 ,(byte)108});
			errorMessage.put( "3",new byte[] {(byte)123 ,(byte)81 ,(byte)37 ,(byte)199 ,(byte)1 ,(byte)162 ,(byte)137 ,(byte)15 ,(byte)239 ,(byte)124 ,(byte)196 ,(byte)97 ,(byte)177 ,(byte)1 ,(byte)70 ,(byte)13 ,(byte)110 ,(byte)226 ,(byte)19 ,(byte)81 ,(byte)174 ,(byte)18 ,(byte)149 ,(byte)52 ,(byte)10 ,(byte)9 ,(byte)105 ,(byte)126 ,(byte)251 ,(byte)21 ,(byte)23 ,(byte)10 });
			errorMessage.put( "4",new byte[] {(byte)122 ,(byte)57 ,(byte)93 ,(byte)241 ,(byte)149 ,(byte)191 ,(byte)49 ,(byte)143 ,(byte)169 ,(byte)190 ,(byte)101 ,(byte)36 ,(byte)209 ,(byte)193 ,(byte)147 ,(byte)231 ,(byte)127 ,(byte)70 ,(byte)32 ,(byte)255 ,(byte)115 ,(byte)226 ,(byte)174 ,(byte)218 ,(byte)57 ,(byte)83 ,(byte)119 ,(byte)161 ,(byte)98 ,(byte)34 ,(byte)226 ,(byte)11});
			errorMessage.put( "5",new byte[] {(byte)203 ,(byte)75 ,(byte)220 ,(byte)32 ,(byte)54 ,(byte)111 ,(byte)123 ,(byte)103 ,(byte)20 ,(byte)156 ,(byte)240 ,(byte)151 ,(byte)116 ,(byte)162 ,(byte)193 ,(byte)211 ,(byte)237 ,(byte)244 ,(byte)240 ,(byte)73 ,(byte)243 ,(byte)15 ,(byte)185 ,(byte)111 ,(byte)199 ,(byte)38 ,(byte)43 ,(byte)121 ,(byte)156 ,(byte)25 ,(byte)192 ,(byte)213});
			errorMessage.put( "6",new byte[] {(byte)140 ,(byte)35 ,(byte)116 ,(byte)225 ,(byte)119 ,(byte)0 ,(byte)118 ,(byte)111 ,(byte)17 ,(byte)73 ,(byte)211 ,(byte)193 ,(byte)143 ,(byte)182 ,(byte)34 ,(byte)15 ,(byte)1 ,(byte)182 ,(byte)43 ,(byte)50 ,(byte)121 ,(byte)78 ,(byte)122 ,(byte)207 ,(byte)52 ,(byte)60 ,(byte)128 ,(byte)35 ,(byte)77 ,(byte)55 ,(byte)156 ,(byte)70});
			errorMessage.put( "7",new byte[] {(byte)188 ,(byte)24 ,(byte)58 ,(byte)149 ,(byte)149 ,(byte)39 ,(byte)34 ,(byte)177 ,(byte)224 ,(byte)133 ,(byte)21 ,(byte)62 ,(byte)18 ,(byte)217 ,(byte)194 ,(byte)135 ,(byte)73 ,(byte)159 ,(byte)37 ,(byte)98 ,(byte)202 ,(byte)156 ,(byte)129 ,(byte)233 ,(byte)252 ,(byte)200 ,(byte)148 ,(byte)210 ,(byte)221 ,(byte)193 ,(byte)6 ,(byte)122});
			errorMessage.put( "8",new byte[] {(byte)162 ,(byte)139 ,(byte)203 ,(byte)28 ,(byte)125 ,(byte)252 ,(byte)238 ,(byte)202 ,(byte)64 ,(byte)72 ,(byte)15 ,(byte)176 ,(byte)189 ,(byte)49 ,(byte)159 ,(byte)98 ,(byte)4 ,(byte)61 ,(byte)217 ,(byte)243 ,(byte)79 ,(byte)5 ,(byte)87 ,(byte)17 ,(byte)165 ,(byte)202 ,(byte)108 ,(byte)179 ,(byte)184 ,(byte)221 ,(byte)90 ,(byte)138});
			errorMessage.put( "9",new byte[] {(byte)49 ,(byte)188 ,(byte)188 ,(byte)158 ,(byte)36 ,(byte)122 ,(byte)235 ,(byte)143 ,(byte)173 ,(byte)60 ,(byte)143 ,(byte)183 ,(byte)18 ,(byte)144 ,(byte)53 ,(byte)88 ,(byte)34 ,(byte)9 ,(byte)41 ,(byte)15 ,(byte)115 ,(byte)7 ,(byte)83 ,(byte)203 ,(byte)30 ,(byte)138 ,(byte)116 ,(byte)155 ,(byte)56 ,(byte)155 ,(byte)28 ,(byte)169});
		}else if(_HASH=="SHA1") {
			errorMessage.put( "0",new byte[] {(byte)57 ,(byte)236 ,(byte)11 ,(byte)221 ,(byte)100 ,(byte)69 ,(byte)37 ,(byte)26 ,(byte)136 ,(byte)7 ,(byte)68 ,(byte)103 ,(byte)242 ,(byte)155 ,(byte)137 ,(byte)85 ,(byte)159 ,(byte)222 ,(byte)126 ,(byte)35 ,(byte)169 ,(byte)43 ,(byte)18 ,(byte)70 ,(byte)218 ,(byte)169 ,(byte)173 ,(byte)124 ,(byte)58 ,(byte)72 ,(byte)47 ,(byte)195});
			errorMessage.put( "1",new byte[] {(byte)74 ,(byte)41 ,(byte)247 ,(byte)244 ,(byte)221 ,(byte)77 ,(byte)31 ,(byte)22 ,(byte)184 ,(byte)151 ,(byte)26 ,(byte)120 ,(byte)56 ,(byte)46 ,(byte)219 ,(byte)53 ,(byte)228 ,(byte)217 ,(byte)242 ,(byte)121 ,(byte)29 ,(byte)87 ,(byte)55 ,(byte)219 ,(byte)65 ,(byte)139 ,(byte)37 ,(byte)35 ,(byte)187 ,(byte)75 ,(byte)196 ,(byte)175});
			errorMessage.put( "2",new byte[] {(byte)193 ,(byte)198 ,(byte)216 ,(byte)202 ,(byte)23 ,(byte)148 ,(byte)253 ,(byte)198 ,(byte)202 ,(byte)18 ,(byte)221 ,(byte)61 ,(byte)134 ,(byte)143 ,(byte)199 ,(byte)31 ,(byte)232 ,(byte)125 ,(byte)158 ,(byte)64 ,(byte)100 ,(byte)20 ,(byte)40 ,(byte)172 ,(byte)102 ,(byte)208 ,(byte)16 ,(byte)29 ,(byte)146 ,(byte)204 ,(byte)162 ,(byte)108});
			errorMessage.put( "3",new byte[] {(byte)123 ,(byte)81 ,(byte)37 ,(byte)199 ,(byte)1 ,(byte)162 ,(byte)137 ,(byte)15 ,(byte)239 ,(byte)124 ,(byte)196 ,(byte)97 ,(byte)177 ,(byte)1 ,(byte)70 ,(byte)13 ,(byte)110 ,(byte)226 ,(byte)19 ,(byte)81 ,(byte)174 ,(byte)18 ,(byte)149 ,(byte)52 ,(byte)10 ,(byte)9 ,(byte)105 ,(byte)126 ,(byte)251 ,(byte)21 ,(byte)23 ,(byte)10 });
			errorMessage.put( "4",new byte[] {(byte)122 ,(byte)57 ,(byte)93 ,(byte)241 ,(byte)149 ,(byte)191 ,(byte)49 ,(byte)143 ,(byte)169 ,(byte)190 ,(byte)101 ,(byte)36 ,(byte)209 ,(byte)193 ,(byte)147 ,(byte)231 ,(byte)127 ,(byte)70 ,(byte)32 ,(byte)255 ,(byte)115 ,(byte)226 ,(byte)174 ,(byte)218 ,(byte)57 ,(byte)83 ,(byte)119 ,(byte)161 ,(byte)98 ,(byte)34 ,(byte)226 ,(byte)11});
			errorMessage.put( "5",new byte[] {(byte)203 ,(byte)75 ,(byte)220 ,(byte)32 ,(byte)54 ,(byte)111 ,(byte)123 ,(byte)103 ,(byte)20 ,(byte)156 ,(byte)240 ,(byte)151 ,(byte)116 ,(byte)162 ,(byte)193 ,(byte)211 ,(byte)237 ,(byte)244 ,(byte)240 ,(byte)73 ,(byte)243 ,(byte)15 ,(byte)185 ,(byte)111 ,(byte)199 ,(byte)38 ,(byte)43 ,(byte)121 ,(byte)156 ,(byte)25 ,(byte)192 ,(byte)213});
			errorMessage.put( "6",new byte[] {(byte)140 ,(byte)35 ,(byte)116 ,(byte)225 ,(byte)119 ,(byte)0 ,(byte)118 ,(byte)111 ,(byte)17 ,(byte)73 ,(byte)211 ,(byte)193 ,(byte)143 ,(byte)182 ,(byte)34 ,(byte)15 ,(byte)1 ,(byte)182 ,(byte)43 ,(byte)50 ,(byte)121 ,(byte)78 ,(byte)122 ,(byte)207 ,(byte)52 ,(byte)60 ,(byte)128 ,(byte)35 ,(byte)77 ,(byte)55 ,(byte)156 ,(byte)70});
			errorMessage.put( "7",new byte[] {(byte)188 ,(byte)24 ,(byte)58 ,(byte)149 ,(byte)149 ,(byte)39 ,(byte)34 ,(byte)177 ,(byte)224 ,(byte)133 ,(byte)21 ,(byte)62 ,(byte)18 ,(byte)217 ,(byte)194 ,(byte)135 ,(byte)73 ,(byte)159 ,(byte)37 ,(byte)98 ,(byte)202 ,(byte)156 ,(byte)129 ,(byte)233 ,(byte)252 ,(byte)200 ,(byte)148 ,(byte)210 ,(byte)221 ,(byte)193 ,(byte)6 ,(byte)122});
			errorMessage.put( "8",new byte[] {(byte)162 ,(byte)139 ,(byte)203 ,(byte)28 ,(byte)125 ,(byte)252 ,(byte)238 ,(byte)202 ,(byte)64 ,(byte)72 ,(byte)15 ,(byte)176 ,(byte)189 ,(byte)49 ,(byte)159 ,(byte)98 ,(byte)4 ,(byte)61 ,(byte)217 ,(byte)243 ,(byte)79 ,(byte)5 ,(byte)87 ,(byte)17 ,(byte)165 ,(byte)202 ,(byte)108 ,(byte)179 ,(byte)184 ,(byte)221 ,(byte)90 ,(byte)138});
			errorMessage.put( "9",new byte[] {(byte)49 ,(byte)188 ,(byte)188 ,(byte)158 ,(byte)36 ,(byte)122 ,(byte)235 ,(byte)143 ,(byte)173 ,(byte)60 ,(byte)143 ,(byte)183 ,(byte)18 ,(byte)144 ,(byte)53 ,(byte)88 ,(byte)34 ,(byte)9 ,(byte)41 ,(byte)15 ,(byte)115 ,(byte)7 ,(byte)83 ,(byte)203 ,(byte)30 ,(byte)138 ,(byte)116 ,(byte)155 ,(byte)56 ,(byte)155 ,(byte)28 ,(byte)169});
		}
	} 
	
	private static String getIndexKey(){
		int indexkey = 0; 
		try{
			GregorianCalendar todayCal = new GregorianCalendar();
	
			String date = new Integer(todayCal.get(Calendar.DATE)).toString();
			String month = new Integer(todayCal.get(Calendar.MONTH)+1).toString();
			String year = new Integer(todayCal.get(Calendar.YEAR)).toString();
			
			String today = year + month + date;
			char[] charDate = today.toCharArray();
			indexkey = 0;
			for(int i=0;i<charDate.length;i++){
				indexkey += Integer.parseInt(new Character(charDate[i]).toString());
			}	
			indexkey = indexkey % 10;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new Integer(indexkey).toString();
	}
	
	private static byte[] getKey(){
		byte[] key = new byte[32];
		try{
			if(!isInit){
				initKey();
				isInit = true;
			}
			
			String index = getIndexKey();
			
			key = (byte[])errorMessage.get(index);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}
}