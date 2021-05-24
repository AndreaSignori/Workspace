package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPivotToColumnsDelimitedEndJava
{
  protected static String nl;
  public static synchronized TPivotToColumnsDelimitedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPivotToColumnsDelimitedEndJava result = new TPivotToColumnsDelimitedEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\tnb_line_out_";
  protected final String TEXT_3 = " = group_Keys";
  protected final String TEXT_4 = ".size();" + NL + "" + NL + "\t\t";
  protected final String TEXT_5 = NL + "  \t\t\t////////////////////////////////  Delimited  /////////  " + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t    out";
  protected final String TEXT_7 = ".write(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\t\t    " + NL + "\t\t\t    out";
  protected final String TEXT_9 = ".write(";
  protected final String TEXT_10 = ");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "    " + NL + "\t\t\tfor(int i = 0; i < pivot_Keys";
  protected final String TEXT_12 = ".size(); i++) {" + NL + "\t\t\t\tout";
  protected final String TEXT_13 = ".write(pivot_Keys";
  protected final String TEXT_14 = ".get(i));" + NL + "\t\t\t\tif(i == pivot_Keys";
  protected final String TEXT_15 = ".size()-1) {" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tout";
  protected final String TEXT_16 = ");" + NL + "\t\t\t}" + NL + "    " + NL + "\t\t    out";
  protected final String TEXT_17 = ");" + NL + "\t\t" + NL + "\t\t\tjava.util.Iterator<List<String>> iterator_";
  protected final String TEXT_18 = ".iterator();" + NL + "\t\t    " + NL + "\t\t\t" + NL + "\t\t    while(iterator_";
  protected final String TEXT_19 = ".hasNext()) {" + NL + "\t\t\t\tList<String> next = iterator_";
  protected final String TEXT_20 = ".next();" + NL + "\t\t        for(int j = 0; j < next.size(); j++) {" + NL + "\t\t\t\t\tout";
  protected final String TEXT_21 = ".write(next.get(j));" + NL + "\t\t\t\t\tout";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t}" + NL + "\t\t        " + NL + "\t\t        java.util.List<String> aggOut";
  protected final String TEXT_23 = " = aggregation";
  protected final String TEXT_24 = ".get(next);" + NL + "\t\t" + NL + "\t\t        int gap";
  protected final String TEXT_25 = " = aggOut";
  protected final String TEXT_26 = ".size() - pivot_Keys";
  protected final String TEXT_27 = ".size();" + NL + "\t\t        " + NL + "\t\t        if(gap";
  protected final String TEXT_28 = " < 0){" + NL + "\t\t        " + NL + "\t\t        \tfor(int k=0;k<-gap";
  protected final String TEXT_29 = ";k++)" + NL + "\t\t\t\t\t\taggOut";
  protected final String TEXT_30 = ".add(\"\");" + NL + "\t\t\t" + NL + "\t\t        }" + NL + "\t\t" + NL + "\t\t\t\tfor(int j = 0; j < aggOut";
  protected final String TEXT_31 = ".size(); j++) {" + NL + "\t\t\t\t\tout";
  protected final String TEXT_32 = ".write(aggOut";
  protected final String TEXT_33 = ".get(j));" + NL + "\t\t\t\t\tif(j == aggOut";
  protected final String TEXT_34 = ".size()-1) {" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tout";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t}" + NL + "\t\t        " + NL + "\t\t        out";
  protected final String TEXT_36 = ");" + NL + "\t\t" + NL + "\t\t    }" + NL + "    " + NL + "" + NL + "    \t";
  protected final String TEXT_37 = "  ////////////////////////////////   CSV    /////////    " + NL + "" + NL + "\t\t    int rowSize";
  protected final String TEXT_38 = " = pivot_Keys";
  protected final String TEXT_39 = ".size() + ";
  protected final String TEXT_40 = ";" + NL + "\t\t    " + NL + "\t\t    String[] finalStr";
  protected final String TEXT_41 = " = new String[rowSize";
  protected final String TEXT_42 = "];" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "    " + NL + "    \t\t\tfinalStr";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "] = \"";
  protected final String TEXT_46 = "\";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + NL + "\t\t\tfor (int i=0; i<pivot_Keys";
  protected final String TEXT_48 = ".size(); i++) {" + NL + "" + NL + "        \t\tfinalStr";
  protected final String TEXT_49 = "[i+";
  protected final String TEXT_50 = "] = pivot_Keys";
  protected final String TEXT_51 = ".get(i);" + NL + "" + NL + "   \t\t\t}  " + NL + "    " + NL + "    " + NL + "\t\t    CsvWriter";
  protected final String TEXT_52 = ".writeNext(finalStr";
  protected final String TEXT_53 = ");" + NL + "\t\t    " + NL + "\t\t    CsvWriter";
  protected final String TEXT_54 = ".flush();" + NL + "\t\t\tjava.util.Iterator<List<String>> iterator_";
  protected final String TEXT_55 = ".iterator();" + NL + "\t\t    " + NL + "\t\t      while(iterator_";
  protected final String TEXT_56 = ".hasNext()){" + NL + "\t\t\t\tList<String> next = iterator_";
  protected final String TEXT_57 = ".next();" + NL + "\t\t        finalStr";
  protected final String TEXT_58 = "];" + NL + "\t\t" + NL + "\t\t        java.util.List<String> gkSplit";
  protected final String TEXT_59 = " = next;" + NL + "        " + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "        " + NL + "        \t\t\tfinalStr";
  protected final String TEXT_61 = "] = gkSplit";
  protected final String TEXT_62 = ".get(";
  protected final String TEXT_63 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "        " + NL + "    \t\t\tjava.util.List<String> aggOut";
  protected final String TEXT_65 = ".get(gkSplit";
  protected final String TEXT_66 = ");" + NL + "" + NL + "  \t\t\t\tfor (int j=0; j<aggOut";
  protected final String TEXT_67 = ".size(); j++) {" + NL + "" + NL + "        \t\t\tfinalStr";
  protected final String TEXT_68 = "[j+";
  protected final String TEXT_69 = "] =  aggOut";
  protected final String TEXT_70 = ".get(j);" + NL + "" + NL + "  \t\t\t\t} " + NL + "        " + NL + "\t\t        CsvWriter";
  protected final String TEXT_71 = ");" + NL + "\t\t        " + NL + "\t\t        CsvWriter";
  protected final String TEXT_72 = ".flush();" + NL + "\t\t" + NL + "\t\t    }" + NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\t";
  protected final String TEXT_74 = NL + "\t\t\tif(CsvWriter";
  protected final String TEXT_75 = "!=null){" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_76 = ".close();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t\t\tif(out";
  protected final String TEXT_78 = "!=null){" + NL + "\t\t\t \tout";
  protected final String TEXT_79 = ".flush();" + NL + "\t\t\t \tout";
  protected final String TEXT_80 = NL + "\t\t\tif(nb_line_";
  protected final String TEXT_81 = " == 0 && (new java.io.File(fileName_";
  protected final String TEXT_82 = ").exists())){" + NL + "\t\t\t\tnew java.io.File(fileName_";
  protected final String TEXT_83 = ").delete();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\tresourceMap.put(\"finish_";
  protected final String TEXT_85 = "\", true);" + NL + "\t";
  protected final String TEXT_86 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_87 = "_NB_LINE\", nb_line_";
  protected final String TEXT_88 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_89 = "_NB_LINE_OUT\", nb_line_out_";
  protected final String TEXT_90 = ");" + NL;
  protected final String TEXT_91 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        List<Map<String, String>> groupbys = 
            ( List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");

        boolean csvOption = ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
        
        String pivotColumn = ElementParameterParser.getValue(node, "__PIVOT_COLUMN__");

        String aggColumn = ElementParameterParser.getValue(node, "__AGGREGATION_COLUMN__");
        
        String aggFunction = ElementParameterParser.getValue(node, "__AGGREGATION_FUNCTION__");
        
        String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
        
        String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        
        boolean isCsvOption=("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
        
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		if(!isCsvOption) { 
		
    stringBuffer.append(TEXT_5);
    
			for (int i=0; i<groupbys.size(); i++) {
        
        		Map<String, String> groupby = groupbys.get(i);
				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_10);
    
       		}  
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_36);
    
    	}else{
    	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(groupbys.size());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
			for (int i=0; i<groupbys.size(); i++) {
        
        		Map<String, String> groupby = groupbys.get(i);
				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_46);
    
       		}  
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(groupbys.size());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
				for (int i=0; i<groupbys.size(); i++) {
            
        			Map<String, String> groupby = groupbys.get(i);
					
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    
				}  
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(groupbys.size());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
        }
		
    stringBuffer.append(TEXT_73);
    
		if(isCsvOption) {
		
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
		}else{
		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
		}
		if(isDeleteEmptyFile){
		
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
		}
		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
    }
}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
