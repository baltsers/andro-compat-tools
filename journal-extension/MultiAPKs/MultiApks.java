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

public class MultiApks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HashSet<String> APKs = new LinkedHashSet<String>();
//		APKs=getAPKs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware-2019-more.txt");
//		System.out.println("APKs.size()="+APKs.size()+"  APKs="+APKs);
		//System.out.println("getAPKName(00911444F5C54C7F778B7E5E2845DED1F838B714C802B92907C6E73F314BB60D.apk)="+getAPKName("00911444F5C54C7F778B7E5E2845DED1F838B714C802B92907C6E73F314BB60D.apk"));
//		String[] resultSS=getAPPAPK("00002100E99DD61C62888906022139942B487CE5CD0DA8798E0BD77A17352267,AAC96E573EAF8F25DBFE2E60E48E907E863FB524,334A7E090B46138854C5F2BBFA3C6610,2018-01-22 17:27:36,17250307,\"com.tradergenius\",4,0,2018-11-11 17:44:34,7793988,anzhi");
//		System.out.println("resultSS[0]="+resultSS[0]+" resultSS[1]="+resultSS[1]);
		
		
		
//		LinkedHashMap<String, HashSet> APPAPKs = new LinkedHashMap<String, HashSet>();
//		 LinkedHashMap<String, HashSet> APPAPKs2=getAPPAPKs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2019.csv", APPAPKs);
//		 System.out.println("APPAPKs2.size()="+APPAPKs2.size()); //+"  APPAPKs2="+APPAPKs2);
//		 LinkedHashMap<String, HashSet> APPAPKs3=getAPPAPKs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2019-more2.csv", APPAPKs2);
//		 System.out.println("APPAPKs3.size()="+APPAPKs3.size()); //+"  APPAPKs3="+APPAPKs3);
//		 LinkedHashMap<String, HashSet> APPAPKs4=getAPPAPKs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2019-more3.csv", APPAPKs3);
//		 System.out.println("APPAPKs4.size()="+APPAPKs4.size()); //+"  APPAPKs3="+APPAPKs3);
//		 
//		 LinkedHashMap<String, String> APKAPP1 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2019.csv");
//		 System.out.println("APKAPP1.size()="+APKAPP1.size());
//		 LinkedHashMap<String, String> APKAPP2 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2019-more2.csv");
//		 System.out.println("APKAPP2.size()="+APKAPP2.size());
//		 LinkedHashMap<String, String> APKAPP3 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2019-more3.csv");
//		 System.out.println("APKAPP3.size()="+APKAPP3.size());
//		 LinkedHashMap<String, String> APKAPPAll= new LinkedHashMap<String, String>();
//		 APKAPPAll.putAll(APKAPP1);
//		 APKAPPAll.putAll(APKAPP2);
//		 APKAPPAll.putAll(APKAPP3);
//		 System.out.println("APKAPPAll.size()="+APKAPPAll.size());
//		 
////		 readWriteAPPMultiPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api19",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api19App");
////		 for (int j=21; j<=27; j++) {
////			 readWriteAPPMultiPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api"+j+"One",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api"+j+"App");
////		 }
// 
//		 
//		 HashSet<String> PassAPPs = new HashSet<String>();
//		 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api19",APKAPPAll,PassAPPs);
//		 for (int j=21; j<=27; j++) {
//			 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api"+j+"One",APKAPPAll,PassAPPs);
//		 }
//
//		 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api19",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api19MP",PassAPPs);
//		 for (int j=21; j<=27; j++) {
//			 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api"+j+"One",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2019.api"+j+"MP",PassAPPs);
//		 }
		 
		 
			 
//			 LinkedHashMap<String, String> APKAPP1 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2018.csv");
//			 System.out.println("APKAPP1.size()="+APKAPP1.size());
//			 LinkedHashMap<String, String> APKAPP2 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/malware2018-more2.csv");
//			 System.out.println("APKAPP2.size()="+APKAPP2.size());
//			 LinkedHashMap<String, String> APKAPPAll= new LinkedHashMap<String, String>();
//			 APKAPPAll.putAll(APKAPP1);
//			 APKAPPAll.putAll(APKAPP2);
//			 System.out.println("APKAPPAll.size()="+APKAPPAll.size());
//			 
//		 
//			 HashSet<String> PassAPPs = new HashSet<String>();
//			 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2018.api19",APKAPPAll,PassAPPs);
//			 for (int j=21; j<=27; j++) {
//				 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2018.api"+j+"One",APKAPPAll,PassAPPs);
//			 }
//
//			 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2018.api19",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2018.api19MP",PassAPPs);
//			 for (int j=21; j<=27; j++) {
//				 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2018.api"+j+"One",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_malware2018.api"+j+"MP",PassAPPs);
//			 }		 
	
			 
//			 LinkedHashMap<String, String> APKAPP1 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/benign2018.csv");
//			 System.out.println("APKAPP1.size()="+APKAPP1.size());
//			 LinkedHashMap<String, String> APKAPP2 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/benign2018-more2.csv");
//			 System.out.println("APKAPP2.size()="+APKAPP2.size());
//			 LinkedHashMap<String, String> APKAPPAll= new LinkedHashMap<String, String>();
//			 APKAPPAll.putAll(APKAPP1);
//			 APKAPPAll.putAll(APKAPP2);
//			 System.out.println("APKAPPAll.size()="+APKAPPAll.size());
//			 
//		 
//			 HashSet<String> PassAPPs = new HashSet<String>();
//			 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2018.api19",APKAPPAll,PassAPPs);
//			 for (int j=21; j<=27; j++) {   
//				 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2018.api"+j+"One",APKAPPAll,PassAPPs);
//			 }
//
//			 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2018.api19",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2018.api19MP",PassAPPs);
//			 for (int j=21; j<=27; j++) {  //api21MP 33597
//				 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2018.api"+j+"One",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2018.api"+j+"MP",PassAPPs);
//			 }		
		 
//			 LinkedHashMap<String, String> APKAPP1 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/benign2019.csv");
//			 System.out.println("APKAPP1.size()="+APKAPP1.size());
//			 LinkedHashMap<String, String> APKAPP2 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/benign2019-more2.csv");
//			 System.out.println("APKAPP2.size()="+APKAPP2.size());
//			 LinkedHashMap<String, String> APKAPPAll= new LinkedHashMap<String, String>();
//			 APKAPPAll.putAll(APKAPP1);
//			 APKAPPAll.putAll(APKAPP2);
//			 System.out.println("APKAPPAll.size()="+APKAPPAll.size());
//			 
//		 
//			 HashSet<String> PassAPPs = new HashSet<String>();
//			 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2019.api19",APKAPPAll,PassAPPs);
//			 for (int j=21; j<=27; j++) {   
//				 PassAPPs = getPassAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2019.api"+j+"One",APKAPPAll,PassAPPs);
//			 }
//
//			 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2019.api19",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2019.api19MP",PassAPPs);
//			 for (int j=21; j<=27; j++) {  //api21MP 33597
//				 readWriteAPPMultiAllPassFails("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2019.api"+j+"One",APKAPPAll,"C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Installation_benign2019.api"+j+"MP",PassAPPs);
//			 }			 
			 
//			 LinkedHashMap<String, String> APKAPP1 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/benign2018.csv");
//			 System.out.println("APKAPP1.size()="+APKAPP1.size());
//			 LinkedHashMap<String, String> APKAPP2 = getAPKAPPMaps("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/benign2018-more2.csv");
//			 System.out.println("APKAPP2.size()="+APKAPP2.size());
//			 LinkedHashMap<String, String> APKAPPAll= new LinkedHashMap<String, String>();
//			 APKAPPAll.putAll(APKAPP1);
//			 APKAPPAll.putAll(APKAPP2);
//			 System.out.println("APKAPPAll.size()="+APKAPPAll.size());
//			 
//			 HashSet<String> PassAPPs = new HashSet<String>();  //getPassMonkeyAPPs(String inputPath, LinkedHashMap<String, String> APKAPPMap, HashSet<String> oldAPPs)
//			 PassAPPs = getPassMonkeyAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Benign20018/api19",APKAPPAll,PassAPPs);
//			 for (int j=21; j<=27; j++) {   
//				 PassAPPs = getPassMonkeyAPPs("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Benign20018/api"+j,APKAPPAll,PassAPPs);
//			 }
//			 
//			 updateFailedTracesMultiAllPass("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Benign20018/api19", APKAPPAll,PassAPPs); 
//			 for (int j=21; j<=27; j++) {   
//				 updateFailedTracesMultiAllPass("C:/Research/appcompatibilitystudy/Programs/MultiAPKs/Benign20018/api"+j, APKAPPAll,PassAPPs);
//			 }
		for (int i = 0; i < args.length; ++i) {
			String arg = args[i];
			System.out.println("args["+i+"]="+arg);
		}	
		if (args.length==1) 
		{
			updateFailedRunTimeTracesMultiAll(args[0],"benign2018");	
			updateFailedRunTimeTracesMultiAll(args[0],"benign2019");	
			updateFailedRunTimeTracesMultiAll(args[0],"malware2018");	
			updateFailedRunTimeTracesMultiAll(args[0],"malware2019");				
		}
		else if (args.length>1) 
		{
			updateFailedRunTimeTracesMultiAll(args[0],args[1]);			
		}	
			 
	}

	public static void updateFailedRunTimeTracesMultiAll(String runTimePath, String benignMalwareYear) { 
		 LinkedHashMap<String, String> APKAPP1 = getAPKAPPMaps(runTimePath+"/"+benignMalwareYear+".csv");
		 System.out.println("APKAPP1.size()="+APKAPP1.size());
		 LinkedHashMap<String, String> APKAPP2 = getAPKAPPMaps(runTimePath+"/"+benignMalwareYear+"-more2.csv");
		 System.out.println("APKAPP2.size()="+APKAPP2.size());
		 LinkedHashMap<String, String> APKAPP3 = new LinkedHashMap<String, String>();
		 if (benignMalwareYear.equals("malware2019"))
			 APKAPP3 = getAPKAPPMaps(runTimePath+"/malware2019-more3.csv");
		 //System.out.println("APKAPP3.size()="+APKAPP3.size());
		 LinkedHashMap<String, String> APKAPPAll= new LinkedHashMap<String, String>();
		 APKAPPAll.putAll(APKAPP1);
		 APKAPPAll.putAll(APKAPP2);
		 APKAPPAll.putAll(APKAPP3);
		 System.out.println("APKAPPAll.size()="+APKAPPAll.size());
		 
		 HashSet<String> PassAPPs = new HashSet<String>();  //getPassMonkeyAPPs(String inputPath, LinkedHashMap<String, String> APKAPPMap, HashSet<String> oldAPPs)
		 PassAPPs = getPassMonkeyAPPs(runTimePath+"/"+benignMalwareYear+"/api19",APKAPPAll,PassAPPs);
		 for (int j=21; j<=27; j++) {   
			 PassAPPs = getPassMonkeyAPPs(runTimePath+"/"+benignMalwareYear+"/api"+j,APKAPPAll,PassAPPs);
			 System.out.println("PassAPPs"+j);
		 }
		 
		 //updateFailedTracesMultiAllPass(runTimePath+"/"+benignMalwareYear+"/api19", APKAPPAll,PassAPPs); 
		 for (int j=26; j<=27; j++) {   
			 System.out.println("API"+j);
			 updateFailedTracesMultiAllPass(runTimePath+"/"+benignMalwareYear+"/api"+j, APKAPPAll,PassAPPs);
		 }
	}
    public static LinkedHashSet<String> getAPKs(String srcFile) {  	
        FileReader reader = null;  
        BufferedReader br = null;  
        LinkedHashSet<String> APKs = new LinkedHashSet<String>();
        try {           
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	if (strtrim.indexOf("====================================== Install INDIVIDUAL APP: ")>=0 || strtrim.endsWith(".apk"))
            	{
            		APKName=getAPKName(strtrim);
            		APKs.add(APKName);
            			
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  
   
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return APKs;
    }   
    
    public static LinkedHashMap<String, HashSet> getAPPAPKs(String srcFile, LinkedHashMap<String, HashSet> oldAPPAPKs) {  	
    	
        FileReader reader = null;  
        BufferedReader br = null;  
        LinkedHashMap<String, HashSet> APPAPKs = (LinkedHashMap<String, HashSet>) oldAPPAPKs.clone();
        try {           
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	String[] APPAPK=getAPPAPK(strtrim);
            	if (APPAPK[0].length()>1 &&  APPAPK[1].length()>1)  {
            		HashSet APKs= new HashSet<>();
            		if (APPAPKs.containsKey(APPAPK[0])) {
            			APKs=APPAPKs.get(APPAPK[0]);
            		}
            		APKs.add(APPAPK[1]);
        			APPAPKs.put(APPAPK[0],APKs);	
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  
   
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return APPAPKs;
    }   
    
    public static LinkedHashMap<String, String> getAPKAPPMaps(String srcFile) {  	
    	
        FileReader reader = null;  
        BufferedReader br = null;  
        LinkedHashMap<String, String> APKAPPs = new LinkedHashMap<>();
        try {           
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	String[] APPAPK=getAPPAPK(strtrim);
            	APKAPPs.put(APPAPK[1], APPAPK[0]);
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  
   
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return APKAPPs;
    }   
    
    public static ArrayList getPassFailAPKs(String srcFile) { 
        FileReader reader = null;  
        BufferedReader br = null;  
        HashSet<String> passedAPKs = new HashSet<String>();
        HashSet<String> failedAPKs = new HashSet<String>();
        ArrayList passedFailedAPKs = new ArrayList();
        
        try {  
            
   
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	if (strtrim.indexOf("====================================== Install INDIVIDUAL APP: ")>=0)
            	{
            		APKName=getAPKName(strtrim);
            		String APKString="";      
            		//System.out.println("APKName ="+APKName);
            		if (APKName.length()>1) {
            			
            			while (str!=null && str.length()>1)
            			{
            				strtrim=str.trim();
            				APKString+=strtrim+"\n";
            				str = br.readLine();
            			}
            			//System.out.println("APKString="+APKString);
            			if (APKString.indexOf("installed successfully")>1 && APKString.indexOf("unnstalled successfully")>1) {
            				passedAPKs.add(APKName);
            			}
            			else if (APKString.indexOf("Failure")>1 && APKString.indexOf("failed.")>1) {
            				failedAPKs.add(APKName);
            			}
            				
            		}
            			
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  

   
        } catch (IOException e) {  
            e.printStackTrace();         
       
        }
        failedAPKs.removeAll(passedAPKs);
        passedFailedAPKs.add(passedAPKs);
        passedFailedAPKs.add(failedAPKs);
        return passedFailedAPKs;
        
    }   
    
    public static ArrayList getPassFailAPKs(String srcFile, LinkedHashMap<String, String> APKAPPs, LinkedHashMap<String, HashSet> APPAPKs) { 
        FileReader reader = null;  
        BufferedReader br = null;  
        HashSet<String> passedAPKs = new HashSet<String>();
        HashSet<String> failedAPKs = new HashSet<String>();
        ArrayList passedFailedAPKs = new ArrayList();
        
        try {  
            
   
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	if (strtrim.indexOf("====================================== Install INDIVIDUAL APP: ")>=0)
            	{
            		APKName=getAPKName(strtrim);
            		String APKString="";      
            		//System.out.println("APKName ="+APKName);
            		if (APKName.length()>1) {
            			
            			while (str!=null && str.length()>1)
            			{
            				strtrim=str.trim();
            				APKString+=strtrim+"\n";
            				str = br.readLine();
            			}
            			//System.out.println("APKString="+APKString);
            			if (APKString.indexOf("installed successfully")>1 && APKString.indexOf("unnstalled successfully")>1) {
            				passedAPKs.add(APKName);
            			}
            			else if (APKString.indexOf("Failure")>1 && APKString.indexOf("failed.")>1) {
            				failedAPKs.add(APKName);
            				
            			}
            				
            		}
            			
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  

   
        } catch (IOException e) {  
            e.printStackTrace();         
       
        }
        failedAPKs.removeAll(passedAPKs);
        passedFailedAPKs.add(passedAPKs);
        passedFailedAPKs.add(failedAPKs);
        return passedFailedAPKs;
        
    }   
    
    public static String getAPKName(String longStr) {
        String resultS="";
        longStr=longStr.trim();
        if (longStr.indexOf("====================================== Install INDIVIDUAL APP: ")>=0)
    	{
        	resultS=longStr.replace("====================================== Install INDIVIDUAL APP: ", "").replace(".apk ===========================", "");
    	}
        else if (longStr.endsWith(".apk"))  {
        	longStr=longStr.replace(".apk", "");
        	String[] longStrs=longStr.split("/");
        	if (longStrs.length>0) {
        		resultS=longStrs[longStrs.length-1];
        	}
        	else 
        		resultS=longStr;
        }
        	
        return resultS;
    }
    
    public static String[] getAPPAPK(String longStr) {
        String[] resultSS={"",""};
        longStr=longStr.trim();
        String[] longStrs=longStr.split(",");
        if (longStrs.length>5) {
        	resultSS[0]=longStrs[5].replace("\"", "");
        	resultSS[1]=longStrs[0];
        }
        	
        return resultSS;
    }
    
    public static void readWriteAPPMultiPassFails(String srcFile, LinkedHashMap<String, String> APKAPPMap, String dstFile) { 
    	HashMap<String, String> PassAPKs = new LinkedHashMap<String, String>();	
    	HashMap<String, String> FailAPKs = new LinkedHashMap<String, String>();
        FileReader reader = null;  
        BufferedReader br = null;  
        
        FileWriter writer = null;  
        BufferedWriter bw = null;  
   
        if (APKAPPMap.size()<1)
        	return;
        try {  
            
   
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            String APPName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	APKName="";
            	APPName="";
            	if (strtrim.indexOf("====================================== Install INDIVIDUAL APP: ")>=0)
            	{
            		APKName=getAPKName(strtrim);
            		if (APKName.length()<1) 
            			continue;
            		if (APKAPPMap.containsKey(APKName)) {
            			APPName=APKAPPMap.get(APKName);
            			
            		}
            		String APKString="";      
            		//System.out.println("APKName ="+APKName);
            		if (APPName.length()>1) {
            			
            			while (str!=null && str.length()>1)
            			{
            				strtrim=str.trim();
            				APKString+=strtrim+"\n";
            				str = br.readLine();
            			}
            			//System.out.println("APKString="+APKString);
            			if (APKString.indexOf("installed successfully")>1 && APKString.indexOf("unnstalled successfully")>1) {
            				PassAPKs.put(APPName, APKString);
            				String curAPKFail= FailAPKs.get(APKName);
            				
            				if (curAPKFail!=null && curAPKFail.length()>1) {
            					FailAPKs.remove(APPName);
            				}
            			}
            			else if (APKString.indexOf("Failure")>1 && APKString.indexOf("failed.")>1) {
            				FailAPKs.remove(APPName);
            				FailAPKs.put(APPName, APKString);
            			}
            				
            		}
            			
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  
   
            System.out.println("PassAPKs ="+PassAPKs.size());
            System.out.println("FailAPKs ="+FailAPKs.size());
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        System.out.println("dstFile ="+dstFile+" dstFile.length()="+dstFile.length());
        if (dstFile.length()>1) {
	        try {  
	                    
		      File file = new File(dstFile);  
		      if (!file.exists()) {  
		          file.createNewFile();  
		      }  
		      writer = new FileWriter(dstFile, false);  
		      bw = new BufferedWriter(writer); 
		      
		      for ( String APPName : PassAPKs.keySet() ) {
					String APKString = (String) PassAPKs.get(APPName);
					bw.write(APKString);
					bw.write("\n");
			   }
		      for ( String APPName : FailAPKs.keySet() ) {
					String APKString = (String) FailAPKs.get(APPName);
					bw.write(APKString);
					bw.write("\n");
			   }			   
		      bw.close();  
		      writer.close(); 
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
        }
    }   
    
    public static HashSet<String> getPassAPPs(String srcFile, LinkedHashMap<String, String> APKAPPMap, HashSet<String> oldAPPs) { 
    	HashSet<String> PassAPPs = (HashSet<String>) oldAPPs.clone();	
        FileReader reader = null;  
        BufferedReader br = null;  
        
        FileWriter writer = null;  
        BufferedWriter bw = null;  
   
        try {  
            
   
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            String APPName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	APKName="";
            	APPName="";
            	if (strtrim.indexOf("====================================== Install INDIVIDUAL APP: ")>=0)
            	{
            		APKName=getAPKName(strtrim);
            		if (APKName.length()<1) 
            			continue;
            		if (APKAPPMap.containsKey(APKName)) {
            			APPName=APKAPPMap.get(APKName);
            			
            		}
            		String APKString="";      
            		//System.out.println("APKName ="+APKName);
            		if (APPName.length()>1) {
            			
            			while (str!=null && str.length()>1)
            			{
            				strtrim=str.trim();
            				APKString+=strtrim+"\n";
            				str = br.readLine();
            			}
            			//System.out.println("APKString="+APKString);
            			if (APKString.indexOf("installed successfully")>1 && APKString.indexOf("unnstalled successfully")>1) {
            				PassAPPs.add(APPName);
            			}
            		
            				
            		}
            			
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  

           
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        System.out.println("PassAPPs.size() ="+PassAPPs.size());
        return PassAPPs;
    }   
    

    public static void readWriteAPPMultiAllPassFails(String srcFile, LinkedHashMap<String, String> APKAPPMap, String dstFile, HashSet<String> AllPassAPPs) { 
    	HashMap<String, String> PassAPKs = new LinkedHashMap<String, String>();	
    	HashMap<String, String> FailAPKs = new LinkedHashMap<String, String>();
        FileReader reader = null;  
        BufferedReader br = null;  
        
        FileWriter writer = null;  
        BufferedWriter bw = null;  
   
        if (APKAPPMap.size()<1)
        	return;
        try {  
            
   
            reader = new FileReader(srcFile);     
            String str = null;     
            br = new BufferedReader(reader);  
  
            String strtrim;
            String APKName="";
            String APPName="";
            str = br.readLine();
            while (str!= null ) {  
            	strtrim=str.trim();
            	APKName="";
            	APPName="";
            	if (strtrim.indexOf("====================================== Install INDIVIDUAL APP: ")>=0)
            	{
            		APKName=getAPKName(strtrim);
            		if (APKName.length()<1) 
            			continue;
            		if (APKAPPMap.containsKey(APKName)) {
            			APPName=APKAPPMap.get(APKName);
            			
            		}
            		String APKString="";      
            		//System.out.println("APKName ="+APKName);
            		if (APPName.length()>1) {
            			
            			while (str!=null && str.length()>1)
            			{
            				strtrim=str.trim();
            				APKString+=strtrim+"\n";
            				str = br.readLine();
            			}
            			//System.out.println("APKString="+APKString);
            			if (APKString.indexOf("installed successfully")>1 && APKString.indexOf("unnstalled successfully")>1) {
            				PassAPKs.put(APPName, APKString);
//            				String curAPKFail= FailAPKs.get(APKName);
//            				
//            				if (curAPKFail!=null && curAPKFail.length()>1) {
//            					FailAPKs.remove(APPName);
//            				}
            			}
            			else if (APKString.indexOf("Failure")>1 && APKString.indexOf("failed.")>1 && !AllPassAPPs.contains(APPName)) {
            				FailAPKs.remove(APPName);
            				FailAPKs.put(APPName, APKString);
            			}
            				
            		}
            			
            	}
            	str = br.readLine();
            	//System.out.println("str ="+str);
            	
            
            }	
            br.close();  
            reader.close();  
   
//            System.out.println("PassAPKs ="+PassAPKs.size());
//            System.out.println("FailAPKs ="+FailAPKs.size());
   
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        //System.out.println("dstFile ="+dstFile+" dstFile.length()="+dstFile.length());
        if (dstFile.length()>1) {
	        try {  
	                    
		      File file = new File(dstFile);  
		      if (!file.exists()) {  
		          file.createNewFile();  
		      }  
		      writer = new FileWriter(dstFile, false);  
		      bw = new BufferedWriter(writer); 
		      
		      for ( String APPName : PassAPKs.keySet() ) {
					String APKString = (String) PassAPKs.get(APPName);
					bw.write(APKString);
					bw.write("\n");
			   }
		      for ( String APPName : FailAPKs.keySet() ) {
					String APKString = (String) FailAPKs.get(APPName);
					bw.write(APKString);
					bw.write("\n");
			   }			   
		      bw.close();  
		      writer.close(); 
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
        }
        
        
        
    }   
    public static boolean isPassOfAFile(String srcFile) {
        File file = new File(srcFile);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];
        String fileStr="";
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            fileStr=new String(filecontent);
            in.close(); 
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
        }  
        
        if (fileStr.length()<1)
        	return false;
        //"com.android.server.am.NativeCrashListener.run", "Msg: java.lang.VerifyError", "IllegalMonitorStateException", "", "", "", "", "", "", "", "", "", "", ""
//        native=message.find('Native')
//        	    verify=message.find('VerifyError')
//        	    illegal=message.find('IllegalMonitorStateException')
//        NoClass=message.find('NoClassDefFoundError')
//        	    Security=message.find('SecurityException')
//        	    NullPointer=message.find('NullPointerException')   Msg: java.lang.NullPointerException
//        	    Unsatisfied=message.find('UnsatisfiedLinkError')
//        	    langerror=message.find('lang.Error')
//        	    IOException=message.find('IOException')
//        	    Activity=message.find('ActivityNotFoundException')
        //'Native Crash','Verify error','Illegal monitor','No Class','Security','Null pointer','unatisfied link','lang.error','IO exception','Activity not found'
        if (fileStr.indexOf("com.android.server.am.NativeCrashListener.run")>1 || fileStr.indexOf("Msg: java.lang.VerifyError")>1  || fileStr.indexOf("IllegalMonitorStateException")>1  
        || fileStr.indexOf("NoClassDefFoundError")>1  || fileStr.indexOf("SecurityException")>1 || fileStr.indexOf("Msg: java.lang.NullPointerException")>1  || fileStr.indexOf("UnsatisfiedLinkError")>1 
        || fileStr.indexOf("lang.Error")>1  || fileStr.indexOf("IOException")>1 || fileStr.indexOf("Msg: android.content.ActivityNotFoundException")>1)
        	return false; 
    	return true;
    }
   
    public static HashSet<String> getPassMonkeyAPPs(String inputPath, LinkedHashMap<String, String> APKAPPMap, HashSet<String> oldAPPs) { 
    	HashSet<String> PassAPPs = (HashSet<String>) oldAPPs.clone();	
        File file = new File(inputPath);   
        File[] fs = file.listFiles();    
        for(File f:fs){              
            String fileName = f.getName();  
            if (!f.isDirectory() && fileName.endsWith(".apk.monkey") && isPassOfAFile(inputPath+"/"+fileName)) {  
            	//System.out.println("fileName ="+fileName);
                String APKName=fileName.replace(".apk.monkey", "");
        		if (APKName.length()<1) 
        			continue;
                String APPName="";
        		if (APKAPPMap.containsKey(APKName)) {
        			APPName=APKAPPMap.get(APKName);        			
        		}
        		if (APPName.length()>1)
        			PassAPPs.add(APPName);
            }
        }
        System.out.println("PassAPPs.size() ="+PassAPPs.size());
		return PassAPPs;	
    }	
    
    public static void updateFailedTracesMultiAllPass(String inputPath, LinkedHashMap<String, String> APKAPPMap, HashSet<String> AllPassAPPs) { 
    	System.out.println("inputPath ="+inputPath);
        File file = new File(inputPath);   
        File[] fs = file.listFiles();    
        for(File f:fs){              
            String fileName = f.getName();  
            if (!f.isDirectory() && fileName.endsWith(".apk.monkey")) {  
            	//System.out.println("fileName ="+fileName);
                String APKName=fileName.replace(".apk.monkey", "");
        		if (APKName.length()<1) 
        			continue;
                String APPName="";
        		if (APKAPPMap.containsKey(APKName)) {
        			APPName=APKAPPMap.get(APKName);        			
        		}
        		//System.out.println("fileName ="+fileName+" APKName = "+APKName+" APPName = "+APPName+" AllPassAPPs.contains(APPName)="+AllPassAPPs.contains(APPName)+" isPassOfAFile="+isPassOfAFile(inputPath+"/"+fileName));
        		if (APPName.length()<1) 
        			continue;
        		if (AllPassAPPs.contains(APPName) & !isPassOfAFile(inputPath+"/"+fileName)) {
        			//System.out.println(inputPath+" Multiple passed but failed FileName ="+fileName);
        			f.renameTo(new File(inputPath+"/"+APKName+".apk.monkeyMP"));
        			File f2 = new File(inputPath+"/"+APKName+".apk.logcat");
        			f2.renameTo(new File(inputPath+"/"+APKName+".apk.logcatMP"));			
        		}	

        			
            }
        }
    	
    }
}
