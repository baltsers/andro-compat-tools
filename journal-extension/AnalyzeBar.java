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

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook; 
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class AnalyzeBar {
	public static void main(String[] args) throws IOException, BiffException {
		//ArrayList<String> item0s = new ArrayList<>();
		
		for (int i=2017;i<=2017; i++) {
			LinkedHashMap<String, Float> item0s=getItem0s("C:/Research/appcompatibilitystudy/malware/stacked-bar_malware.xls","run");
			LinkedHashMap<String, Float>  ps= new LinkedHashMap<>();
//			ps=precentages("C:/Research/appcompatibilitystudy/malware/Failed Installation-iir3.xls",""+i, item0s);
//			System.out.println(ps);
//			writeLMapToCSV(ps,"C:/Research/appcompatibilitystudy/malware/MInstallationBar"+i+".csv");
			ps=precentages("C:/Research/appcompatibilitystudy/malware/Failed Execution-rir6.xls",""+i, item0s);
			System.out.println(ps);
			writeLMapToCSV(ps,"C:/Research/appcompatibilitystudy/malware/MRunBar"+i+".csv");
		}
	}
	public static LinkedHashMap<String, Float> getItem0s(String fileName,String sheetName) throws IOException, BiffException{
		//ArrayList<String> item0s = new ArrayList<>();
		LinkedHashMap<String, Float> item0s = new LinkedHashMap<>();
		try {
			//
			//Workbook workbook=Workbook.getWorkbook(new File("D:"+File.separator+"jxl_text.xls"));
			Workbook workbook=Workbook.getWorkbook(new File(fileName));
			//
			Sheet sheet=workbook.getSheet(sheetName);
			//
			int rows=sheet.getRows();    //
			int columns=sheet.getColumns();    //
			int apiLevel=0;
			for(int row=0;row<rows;row++){
				String item0=sheet.getCell(0, row).getContents().trim();
				if (item0!=null && item0.length()>0) {
					//item0s.add(item0);
					if (!item0s.containsKey(item0)) {
						item0s.put(item0, (float) 0.0);
					}
					if (item0.equals("TOTAL"))
						break;
				}		
			}
			workbook.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return item0s;
	}
	
	public static LinkedHashMap<String, Float> precentages(String fileName,String sheetName, LinkedHashMap<String, Float> item0s) throws IOException, BiffException{
		LinkedHashMap<String, Float>  ps = new LinkedHashMap<>();
		try {
			//
			//Workbook workbook=Workbook.getWorkbook(new File("D:"+File.separator+"jxl_text.xls"));
			Workbook workbook=Workbook.getWorkbook(new File(fileName));
			//
			Sheet sheet=workbook.getSheet(sheetName);
			//
			int rows=sheet.getRows();   //
			int totalNum=0;
			for(int row=0;row<rows;row++){
				String item1=sheet.getCell(1, row).getContents().trim();
				int num1=0;
				
				String item30=sheet.getCell(30, row).getContents().trim();
				if  (item30.length()>0 && isNumeric(item30))  {
					num1=Integer.valueOf(item30);
					//if (item1.equals("TOTAL"))
						System.out.println("item30="+item30+" item1="+item1); //+" apiLevel="+apiLevel);
					if (item0s.containsKey(item1)) {
						float oldValue=item0s.get(item1);
						item0s.replace(item1, oldValue+num1);
					}
					else
						item0s.put(item1, (float)num1);	
					if (item1.equals("TOTAL")) {
						totalNum+=num1;
						
					}
				}
				//System.out.println("item0="+item0+" item1="+item1+" apiLevel="+apiLevel);
			}			
			workbook.close();
			System.out.println("totalNum="+totalNum);
			System.out.println(item0s);
			if (totalNum>1)  {
	            for(Entry<String, Float> entry : item0s.entrySet()) {
	            	ps.put(entry.getKey(), (float)entry.getValue()/totalNum);	            
	            }  
			}
			else  
				ps=(LinkedHashMap<String, Float>) item0s.clone();
//				for(Entry<String, Float> entry : item0s.entrySet()) {
//	            	ps.put(entry.getKey(), (float)entry.getValue());	            
//	            }  
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return ps;
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
    
    public static void writeLMapToCSV(LinkedHashMap<String, Float> lmap, String dest) {  
        FileWriter writer = null;  
        BufferedWriter bw = null;  
   
        try {  
            File file = new File(dest);  
            if (!file.exists()) {  
                file.createNewFile();  
            }  
            writer = new FileWriter(dest, false); 
            bw = new BufferedWriter(writer);  
            for(Entry<String, Float> entry : lmap.entrySet()) {
            	bw.write(entry.getKey()+","+entry.getValue()+"\n");
            }    	   
            bw.close();  
            writer.close();  	
            //System.out.println("str="+str+" dest="+dest);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

}
