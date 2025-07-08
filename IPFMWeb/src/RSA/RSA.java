package RSA;
import java.io.File;
import java.math.BigInteger;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import th.co.ais.ipfm.web.action.AbstractAction;

public class RSA extends AbstractAction{
   //private final static BigInteger one      = new BigInteger("1");
   //private final static SecureRandom random = new SecureRandom();
   private BigInteger privateKey;
   private BigInteger publicKey;
   private BigInteger modulus;
   // generate an N-bit (roughly) public and private key
   RSA() {
       try {
	    FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
       
    	File file = new File(servletContext.getRealPath("/crypto/RSAkey.xml"));
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList RSAKeyValue = doc.getElementsByTagName("key");
        
        Node KeyValue = RSAKeyValue.item(0);
    
        if (KeyValue.getNodeType() == Node.ELEMENT_NODE) {
  
          Element KeyElmnt = (Element) KeyValue;
          NodeList fstNmElmntLst = KeyElmnt.getElementsByTagName("private");
          Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
          NodeList fstNm = fstNmElmnt.getChildNodes();
          privateKey = new BigInteger(((Node) fstNm.item(0)).getNodeValue());
          NodeList lstNmElmntLst = KeyElmnt.getElementsByTagName("module");
          Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
          NodeList lstNm = lstNmElmnt.getChildNodes();
          modulus    = new BigInteger(((Node) lstNm.item(0)).getNodeValue()); 
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
     
   }


   BigInteger encrypt(BigInteger message) {
      return message.modPow(publicKey, modulus);
   }

   BigInteger decrypt(BigInteger encrypted) {
      return encrypted.modPow(privateKey, modulus);
   }
   
   public static String reverseIt(String source) {
    int i, len = source.length();
    StringBuffer dest = new StringBuffer(len);

    for (i = (len - 1); i >= 0; i--)
      dest.append(source.charAt(i));
    return dest.toString();
  }

 
   public static String main(String s) {
      //int N = Integer.parseInt(args);
      RSA key = new RSA();
      // create random message, encrypt and decrypt
      //BigInteger message = new BigInteger(N-1, random);

      //// create message by converting string to integer
     
      BigInteger encrypt = new BigInteger(s);
      BigInteger decrypt = key.decrypt(encrypt);
      String binaryString = decrypt.toString(2);
      
     if ( binaryString.length() % 8 != 0)
     {
         if (binaryString.length() % 8 == 7)
         {
          binaryString = "0" + binaryString;
         }
         else if  (binaryString.length() % 8 == 6)
         {
         binaryString = "00" + binaryString;
         }
         else if  (binaryString.length() % 8 == 5)
         {
         binaryString = "000" + binaryString;
         }
         else if  (binaryString.length() % 8 == 4)
         {
         binaryString = "0000" + binaryString;
         }
         else if  (binaryString.length() % 8 == 3)
         {
         binaryString = "00000" + binaryString;
         }
         else if  (binaryString.length() % 8 == 2)
         {
         binaryString = "000000" + binaryString;
         }
         else
         {
         binaryString = "0000000" + binaryString;
         }  
     }
      String Result,bi;
      Result = "";
      //int dec;
      int kk, bit;
      bit = 0;
      int size = binaryString.length() / 8;
  
      for ( kk = 0; kk < size ; kk++)
      {
         bi = "";
         for (int jj = bit ; jj < bit + 8 ; jj++)
         {
            bi = bi + binaryString.charAt(jj);
         }
         bit = bit + 8;
          //String aChar = new Character((char)).toString();
         Result = Result + Character.toString ((char) Integer.parseInt(bi, 2));
      }
      return reverseIt(Result);
   }


@Override
public String init() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public String init(String programID) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean validate() {
	// TODO Auto-generated method stub
	return false;
}


}

