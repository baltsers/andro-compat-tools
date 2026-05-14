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

public class AnalyzeExcel {
	
	//int api_level=0;
    //int api_year=2010;
    public static void main(String[] args) throws IOException, BiffException {
//        String fileName="C:/Research/appcompatibilitystudy/malware/Failed Installation-iir3.xls";
//        String sheetName="2010";
        //readExcel(fileName,sheetName);
        
        HashMap<Integer, Integer> apiYears = new LinkedHashMap<Integer, Integer>();
        apiYears.put(19, 2013);
        apiYears.put(21, 2014);
        apiYears.put(22, 2015);
        apiYears.put(23, 2015);
        apiYears.put(24, 2016);
        apiYears.put(25, 2016);
        apiYears.put(26, 2017);
        apiYears.put(27, 2017);
        //System.out.println(getYearSPSSLines(fileName,sheetName,apiYears));
        for (int i=2017;i<=2019; i++) {
        	//SaveYearSPSSLines("C:/Research/appcompatibilitystudy/benign/Failed Installation-iir_benign.xls","B"+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignInstallationAll.csv");
        	//SaveYearSPSSLines("C:/Research/appcompatibilitystudy/benign/Failed Execution-rir_benign.xls",""+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignRunTimeAll.csv");
        	//SaveYearSPSSItemLines("C:/Research/appcompatibilitystudy/benign/Failed Installation-iir_benign.xls","B"+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignInstallationABI.csv","INSTALL_FAILED_NO_MATCHING_ABIS");
        	//SaveYearSPSSItemLines("C:/Research/appcompatibilitystudy/benign/Failed Installation-iir_benign.xls","B"+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignInstallationLIB.csv","INSTALL_FAILED_MISSING_SHARED_LIBRARY");
        	//SaveYearSPSSItemLines("C:/Research/appcompatibilitystudy/benign/Failed Execution-rir_benign.xls",""+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignRunTimnaive.csv","Native Crash");
        	//SaveYearSPSSItemLines("C:/Research/appcompatibilitystudy/benign/Failed Execution-rir_benign.xls",""+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignRunTimverify.csv","Verify error");
        	//SaveYearSPSSItemLines("C:/Research/appcompatibilitystudy/benign/Failed Execution-rir_benign.xls",""+i,apiYears,"C:/Research/appcompatibilitystudy/benign/benignRunTimnull.csv","Null Pointer");
        }
        //SaveYearSPSSLines("C:/Research/appcompatibilitystudy/benign/Failed Execution-rir5.xls",""+2010,apiYears,"C:/Research/appcompatibilitystudy/benign/benignRunTime2010.csv");
//    	float[]  pres=new  float[28];
//    	pres=readcsvLine("1,2,3,38,30,9,2,12,12,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,111");
//		for (int i=0; i<28; i++) {
//			System.out.println("pres["+i+"]="+pres[i]);
//		}
//    	System.out.println(csvLineToString("1,2,3,38,30,9,2,12,12,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,111",27,2010,apiYear));
    }	
	public static void readExcel(String fileName,String sheetName) throws IOException, BiffException{
		try {
			//
			//Workbook workbook=Workbook.getWorkbook(new File("D:"+File.separator+"jxl_text.xls"));
			Workbook workbook=Workbook.getWorkbook(new File(fileName));
			//
			Sheet sheet=workbook.getSheet(sheetName);
			//
			int rows=sheet.getRows();    //
			int columns=sheet.getColumns();    //
			for(int row=0;row<rows;row++){
			for(int column=0;column<columns;column++){
			Cell cell=sheet.getCell(column, row);
			System.out.print(cell.getContents()+" ");
			}
			System.out.println();
			}
			workbook.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	public static float[] readcsvLine(String csvLine) {
		float[]  pres=new  float[28];
		for (int i=0; i<28; i++) {
			pres[i]=(float) 0.0;
		}
		int[]  ints=new  int[28];		
		int totalNum=0;
		try {
			String[]  items=csvLine.split(",");
			int itemslength=items.length;
			System.out.println("itemslength="+itemslength);			
			if (items.length>=29)  {
				totalNum= Integer.valueOf(items[28]);
			}
			System.out.println("totalNum="+totalNum);			
			if (items.length<28)  {
				return pres;
			}
			for (int i=0; i<28; i++) {
				ints[i]=Integer.valueOf(items[i]);
				if (items.length>=29)  {
					pres[i]=(float)ints[i]/totalNum;
				}
				else
					totalNum=totalNum+ints[i];
			}
			if (items.length<29 && totalNum>0)  {
				for (int i=0; i<28; i++) {
					pres[i]=(float)ints[i]/totalNum;
				}
			}
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
		return pres;	
		
	}
	
	public static String csvLineToString(String csvLine, int api_level, int year, HashMap<Integer, Integer> apiYears) {
		String resultS="";
    	float[]  pres=new  float[28];
    	pres=readcsvLine(csvLine);
    	int api_year=apiYears.get(api_level);
		for (int i=0; i<28; i++) {
			resultS+=pres[i]+","+i+","+api_level+","+year+","+api_year+","+(api_year-year)+","+(api_level-i)+"\n";
		}
		return resultS;
		
	}
	
	public static HashMap<Integer, String> getYearSPSSLines(String fileName,String sheetName, HashMap<Integer, Integer> apiYears) throws IOException, BiffException{
		HashMap<Integer, String>  yearLines = new LinkedHashMap<Integer, String>();
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
				if  (item0.length()==2 && isNumeric(item0))  {
					apiLevel=Integer.valueOf(item0);
				}
				String item1=sheet.getCell(1, row).getContents().trim();
				//System.out.println("item0="+item0+" item1="+item1+" apiLevel="+apiLevel);
				if (item1.equals("TOTAL") && apiLevel>=19 && apiLevel<=27  ) {
					float[]  pres=new  float[28];
//					for (int i=0; i<28; i++) {
//						pres[i]=(float) 0.0;
//					}
					int[]  ints=new  int[28];		
					int totalNum=0;
					String item30=sheet.getCell(30, row).getContents().trim();
					if  (item30.length()>0 && isNumeric(item30))  {
						totalNum=Integer.valueOf(item30);
						System.out.println("item30="+item30+" item1="+item1+" apiLevel="+apiLevel);
					}
					int sheetYear=0;
					sheetName=sheetName.replace("B", "");
					if  (sheetName.length()>0 && isNumeric(sheetName))  {
						sheetYear=Integer.valueOf(sheetName);						
					}
					String resultS="";
					for (int i=0; i<28; i++) {
						pres[i]=(float) 0.0;
						String itemCell=sheet.getCell(i+2, row).getContents().trim();
						//System.out.println("itemCell="+itemCell);
						if  (itemCell.length()>0 && isNumeric(itemCell) && totalNum>0)  {
							//int itemNum=Integer.valueOf(itemCell);
							pres[i]=(float)Integer.valueOf(itemCell)/totalNum;	
							//System.out.println("pres[i]="+pres[i]);
						}
						int api_year=apiYears.get(apiLevel);

						resultS+=pres[i]+","+i+","+apiLevel+","+sheetYear+","+api_year+","+(api_year-sheetYear)+","+(apiLevel-i)+"\n";
						System.out.println("resultS="+resultS);
					}
					//System.out.println("resultS="+resultS);
					if (sheetYear>0 && resultS.length()>0)
						yearLines.put(apiLevel, resultS);
					
				}
//				for(int column=0;column<columns;column++){
//					Cell cell=sheet.getCell(column, row);
//					System.out.print(cell.getContents()+" ");
//				}
//				System.out.println();
			}
			workbook.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return yearLines;
	}
	
	public static  void SaveYearSPSSLines(String fileName,String sheetName, HashMap<Integer, Integer> apiYears, String dest) throws BiffException, IOException {
		String linesStr=""; //"failure rate,min sdk,api level,year,api's year,api-year,api-min\n";
		HashMap<Integer, String>  yearLines = new LinkedHashMap<Integer, String>();
		yearLines=getYearSPSSLines(fileName,sheetName,apiYears);
		System.out.println("yearLines="+yearLines);
		for (int api=27;api>=19;api--) {
			if (yearLines.containsKey(api))
			linesStr+=yearLines.get(api);
			
		}
		//System.out.println("linesStr="+linesStr);
		File file=new File(dest);
        if(file.exists()) {
        	writeStringToFile(linesStr, dest,true);
        }
        else
        	writeStringToFile(linesStr, dest,false);
		//return linesStr;
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

	public static HashMap<Integer, String> getYearSPSSItemLines(String fileName,String sheetName, HashMap<Integer, Integer> apiYears, String item) throws IOException, BiffException{
		HashMap<Integer, String>  yearLines = new LinkedHashMap<Integer, String>();
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
				if  (item0.length()==2 && isNumeric(item0))  {
					apiLevel=Integer.valueOf(item0);
				}
				String item1=sheet.getCell(1, row).getContents().trim();
				//System.out.println("item0="+item0+" item1="+item1+" apiLevel="+apiLevel);
				if (item1.equals(item) && apiLevel>=19 && apiLevel<=27  ) {
					float[]  pres=new  float[28];
//					for (int i=0; i<28; i++) {
//						pres[i]=(float) 0.0;
//					}
					int[]  ints=new  int[28];		
					int totalNum=0;
					String item30=sheet.getCell(30, row).getContents().trim();
					if  (item30.length()>0 && isNumeric(item30))  {
						totalNum=Integer.valueOf(item30);
						//System.out.println("item30="+item30+" item1="+item1+" apiLevel="+apiLevel);
					}
					int sheetYear=0;
					sheetName=sheetName.replace("B", "");
					if  (sheetName.length()>0 && isNumeric(sheetName))  {
						sheetYear=Integer.valueOf(sheetName);						
					}
					String resultS="";
					for (int i=0; i<28; i++) {
						pres[i]=(float) 0.0;
						String itemCell=sheet.getCell(i+2, row).getContents().trim();
						//System.out.println("itemCell="+itemCell);
						if  (itemCell.length()>0 && isNumeric(itemCell) && totalNum>0)  {
							//int itemNum=Integer.valueOf(itemCell);
							pres[i]=(float)Integer.valueOf(itemCell)/totalNum;	
							//System.out.println("pres[i]="+pres[i]);
						}
						int api_year=apiYears.get(apiLevel);

						resultS+=pres[i]+","+i+","+apiLevel+","+sheetYear+","+api_year+","+(api_year-sheetYear)+","+(apiLevel-i)+"\n";
						//System.out.println("resultS="+resultS);
					}
					//System.out.println("resultS="+resultS);
					if (sheetYear>0 && resultS.length()>0)
						yearLines.put(apiLevel, resultS);
					
				}
//				for(int column=0;column<columns;column++){
//					Cell cell=sheet.getCell(column, row);
//					System.out.print(cell.getContents()+" ");
//				}
//				System.out.println();
			}
			workbook.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return yearLines;
	}
	
	public static  void SaveYearSPSSItemLines(String fileName,String sheetName, HashMap<Integer, Integer> apiYears, String dest, String item) throws BiffException, IOException {
		String linesStr=""; //"failure rate,min sdk,api level,year,api's year,api-year,api-min\n";
		HashMap<Integer, String>  yearLines = new LinkedHashMap<Integer, String>();
		yearLines=getYearSPSSItemLines(fileName,sheetName,apiYears,item);
		for (int api=27;api>=19;api--) {
			if (yearLines.containsKey(api))
			linesStr+=yearLines.get(api);
			
		}
		File file=new File(dest);
        if(file.exists()) {
        	writeStringToFile(linesStr, dest,true);
        }
        else
        	writeStringToFile(linesStr, dest,false);
		//return linesStr;
	}
}

