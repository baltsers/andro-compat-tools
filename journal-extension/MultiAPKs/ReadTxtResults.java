import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTxtResults {
	public static void main(String[] args) throws IOException {
//		HashMap<Integer, String> hm = getSDKValue("   	 -- SDK 3 :   34");
//		System.out.println("hm = "+hm);
//		//< 1 >:   Effect: Failure [INSTALL_FAILED_NO_MATCHING_ABIS]           Times:75
//		System.out.println("hm = "+getEffect("< 1 >:   Effect: Failure [INSTALL_FAILED_NO_MATCHING_ABIS]           Times:75"));
		String s2=getEffectStr("C:/VMWARE/share/InstallationMalware2018ApiMP19.txt");
		System.out.println("s2 = "+s2);
		writeStringToFile(s2, "C:/VMWARE/share/InstallationMalware2018ApiMP19.csv", false);
	}

	
//    public static HashMap<Integer, String> getSDKValue(String longStr) {
//    	HashMap<Integer, String> hm = new HashMap<>();
//        if (longStr.indexOf("-- SDK ")>=0)
//    	{
//        	String str2=longStr.replace("-- SDK ", "").trim();
//        	String[] str2S= str2.split(" : ");
//        	if (str2S.length>=2) {
//            	String SDKName=str2S[0].trim();
//            	String SDKValue=str2S[1].trim();
//            	//System.out.println("SDKName= = "+SDKName+" SDKValue= = "+SDKValue);
//            	if (isNumeric(SDKName) && isNumeric(SDKValue)) {
//            		
//            		hm.put(Integer.valueOf(SDKName), SDKValue);
//            	}
//        	}
//
//        	
//    	}
//        return hm;
//    }
    
    public static int getSDKName(String longStr) {
    	//HashMap<Integer, String> hm = new HashMap<>();
    	int resultI=0;
        if (longStr.indexOf("-- SDK ")>=0)
    	{
        	String str2=longStr.replace("-- SDK ", "").trim();
        	String[] str2S= str2.split(" : ");
        	if (str2S.length>=2) {
            	String SDKName=str2S[0].trim();
            	String SDKValue=str2S[1].trim();
            	//System.out.println("SDKName= = "+SDKName+" SDKValue= = "+SDKValue);
            	if (isNumeric(SDKName) && isNumeric(SDKValue)) {
            		resultI=Integer.valueOf(SDKName);
            		//hm.put(Integer.valueOf(SDKName), SDKValue);
            	}
        	}        	
    	}
        return resultI;
    }
    
    public static String getSDKString(String longStr) {
    	//HashMap<Integer, String> hm = new HashMap<>();
    	String resultS="";
        if (longStr.indexOf("-- SDK ")>=0)
    	{
        	String str2=longStr.replace("-- SDK ", "").trim();
        	String[] str2S= str2.split(" : ");
        	if (str2S.length>=2) {
            	String SDKName=str2S[0].trim();
            	String SDKValue=str2S[1].trim();
            	//System.out.println("SDKName= = "+SDKName+" SDKValue= = "+SDKValue);
            	if (isNumeric(SDKName) && isNumeric(SDKValue)) {
            		//resultI=Integer.valueOf(SDKName);
            		return SDKValue;
            		//hm.put(Integer.valueOf(SDKName), SDKValue);
            	}
        	}        	
    	}
        return resultS;
    }
    
    public static String getEffect(String longStr) {
		//String regex = "\\[.*?]";
		Pattern pattern = Pattern.compile("(\\[[^\\]]*\\])");
		//Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
		Matcher m = pattern.matcher(longStr);
		if (m.find()) {
			return m.group().substring(1, m.group().length()-1);
		}
		return "";
	
    }
    
    
    public static String getEffectStr(String srcFile) {  	
    	String resultS="";
        FileReader reader = null;  
        BufferedReader br = null;  
        try {           
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String EffectName="";
            str = br.readLine();
            HashMap<Integer, String> SDKNameValue = new HashMap<>();
			for (int i=0; i<=27; i++) {
				SDKNameValue.put(i, "");
			}
			str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	System.out.println("strtrim = "+strtrim+" EffectName = "+EffectName);
            	if (strtrim.indexOf("Effect: Failure [")>1)  {
            		if (EffectName.length()>1)  {
            			resultS+=EffectName;
            			for (int i=0; i<=27; i++) {
            				resultS+=","+SDKNameValue.get(i);
            			}
            			resultS+="\n";
            			EffectName="";
            		}
            		
            		EffectName=getEffect(strtrim);
        			for (int i=0; i<=27; i++) {
        				SDKNameValue.put(i, "");
        			}
        			System.out.println("resultS = "+resultS);
            	}      	
            	else if (strtrim.indexOf("-- SDK ")>=0) {
            		
            		//HashMap<Integer, String> hm=getSDKValue(strtrim);
            		//System.out.println("hm = "+hm);
            		int SDKLevel=getSDKName(strtrim);
            		String SDKValue=getSDKString(strtrim);
            		if (SDKLevel>=0 && SDKLevel<=27 && SDKNameValue.get(SDKLevel).length()<1 && isNumeric(SDKValue)) {
            			SDKNameValue.put(SDKLevel,SDKValue);
            		}
            		//SDKNameValue.putAll(hm); SDKNameValue.get(SDKLevel).length()>0
            		//System.out.println("SDKNameValue = "+SDKNameValue);
            	}
            		
            	str = br.readLine();
            }	
            
    		if (EffectName.length()>1)  {
    			resultS+=EffectName+",";
    			for (int i=0; i<=27; i++) {
    				resultS+=","+SDKNameValue.get(i);
    			}
    			resultS+="\n";
    			System.out.println("resultS = "+resultS);
    			EffectName="";
    		}
            br.close();  
            reader.close();  
   
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return resultS;
    }   
    
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            //System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static void writeStringToFile(String str, String dest, boolean isAppend) {  
        FileWriter writer = null;  
        BufferedWriter bw = null;  
   
        try {  
            File file = new File(dest);  
            if (!file.exists()) {  
                file.createNewFile();  
            }  
            writer = new FileWriter(dest, isAppend); 
            bw = new BufferedWriter(writer);  
            bw.write(str);    
            bw.close();  
            writer.close();  	
            //System.out.println("str="+str+" dest="+dest);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
