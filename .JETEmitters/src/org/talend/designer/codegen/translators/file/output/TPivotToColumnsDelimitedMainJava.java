package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TPivotToColumnsDelimitedMainJava
{
  protected static String nl;
  public static synchronized TPivotToColumnsDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPivotToColumnsDelimitedMainJava result = new TPivotToColumnsDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "                   " + NL + "    //pivot key  " + NL + "    pivot_Exists";
  protected final String TEXT_3 = " = false;" + NL + "    " + NL + "    int pivotNum";
  protected final String TEXT_4 = " = 0;" + NL + "    " + NL + "    for(int i = 0;i<pivot_Keys";
  protected final String TEXT_5 = ".size();i++){" + NL;
  protected final String TEXT_6 = NL + "\t\t\t\tif(ParserUtils.parseTo_";
  protected final String TEXT_7 = "(pivot_Keys";
  protected final String TEXT_8 = ".get(i)).equals(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ")){";
  protected final String TEXT_11 = ".get(i)) == ";
  protected final String TEXT_12 = "){";
  protected final String TEXT_13 = " " + NL + " \t \t\t    if(pivot_Keys";
  protected final String TEXT_14 = ".get(i).equals(FormatterUtils.format_Date(";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = "))){ ";
  protected final String TEXT_17 = NL + "\t \t\tif(pivot_Keys";
  protected final String TEXT_18 = ".get(i).equals(";
  protected final String TEXT_19 = NL + "\t            pivot_Exists";
  protected final String TEXT_20 = " = true;" + NL + "\t            " + NL + "\t            pivotNum";
  protected final String TEXT_21 = " = i + 1;" + NL + "\t            " + NL + "\t            break;" + NL + "            " + NL + "        \t }" + NL + "    }" + NL + "    " + NL + "    if(!pivot_Exists";
  protected final String TEXT_22 = "){" + NL + "        " + NL + "        pivot_Key";
  protected final String TEXT_23 = ".delete(0, pivot_Key";
  protected final String TEXT_24 = ".length());";
  protected final String TEXT_25 = " " + NL + " \t  \t    pivot_Keys";
  protected final String TEXT_26 = ".add(pivot_Key";
  protected final String TEXT_27 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_28 = ")).toString()); ";
  protected final String TEXT_29 = " " + NL + "            pivot_Keys";
  protected final String TEXT_30 = ".append(";
  protected final String TEXT_31 = ").toString()); ";
  protected final String TEXT_32 = " " + NL + "" + NL + "        pivotNum";
  protected final String TEXT_33 = " = pivot_Keys";
  protected final String TEXT_34 = ".size();" + NL + "        " + NL + "    }" + NL + "" + NL + "    " + NL + "    //group key" + NL + "    group_Exists";
  protected final String TEXT_35 = " = false;" + NL + "    " + NL + "    gKvalue";
  protected final String TEXT_36 = " = new java.util.ArrayList<String>();" + NL + "    " + NL + "    group_Key";
  protected final String TEXT_37 = ".delete(0,group_Key";
  protected final String TEXT_38 = ".length());" + NL + "        ";
  protected final String TEXT_39 = NL + "\t\t\t" + NL + "\t\t\t\tgKvalue";
  protected final String TEXT_40 = ".add(group_Key";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ")).toString());" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t" + NL + "        \t\tgKvalue";
  protected final String TEXT_44 = ").toString());" + NL + "        ";
  protected final String TEXT_45 = NL + "        " + NL + "        group_Key";
  protected final String TEXT_46 = NL + "    " + NL + "\tif (group_Keys";
  protected final String TEXT_47 = ".contains(gKvalue";
  protected final String TEXT_48 = ")) {" + NL + "                     group_Exists";
  protected final String TEXT_49 = " = true;" + NL + "\t}" + NL + "\t" + NL + "" + NL + "    if(!group_Exists";
  protected final String TEXT_50 = "){" + NL + "        " + NL + "        group_Key";
  protected final String TEXT_51 = ".delete(0, group_Key";
  protected final String TEXT_52 = ".length());" + NL + "        " + NL + "        group_Keys";
  protected final String TEXT_53 = ".add(gKvalue";
  protected final String TEXT_54 = ");" + NL + "        " + NL + "\t\taggValues";
  protected final String TEXT_55 = " = new java.util.ArrayList<String>();" + NL + "        " + NL + "        for(int i = 0; i<pivotNum";
  protected final String TEXT_56 = "-1; i++)" + NL + "            " + NL + "            aggValues";
  protected final String TEXT_57 = ".add(\"\");" + NL + "        ";
  protected final String TEXT_58 = NL + NL + "\t\taggValues";
  protected final String TEXT_59 = ".add(\"1\");" + NL + "        aggregation";
  protected final String TEXT_60 = ".put(gKvalue";
  protected final String TEXT_61 = ",aggValues";
  protected final String TEXT_62 = ");" + NL;
  protected final String TEXT_63 = NL + "        aggValues";
  protected final String TEXT_64 = ".add(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_65 = "),";
  protected final String TEXT_66 = "));" + NL + "        aggregation";
  protected final String TEXT_67 = ");" + NL + "  ";
  protected final String TEXT_68 = NL + "\t\t\t" + NL + "\t\t\t\taggValues";
  protected final String TEXT_69 = ".add(FormatterUtils.format_Date(";
  protected final String TEXT_70 = "));" + NL + "\t\t\t\taggregation";
  protected final String TEXT_71 = ");" + NL + "\t\t\t  " + NL + "       \t \t";
  protected final String TEXT_72 = NL + "        " + NL + "        \t\taggValues";
  protected final String TEXT_73 = ".add(String.valueOf(";
  protected final String TEXT_74 = "));" + NL + "        \t\taggregation";
  protected final String TEXT_75 = ");" + NL + "        \t";
  protected final String TEXT_76 = NL + "    }else{" + NL + "" + NL + "        java.util.List<String> aggStr";
  protected final String TEXT_77 = " = aggregation";
  protected final String TEXT_78 = ".get(gKvalue";
  protected final String TEXT_79 = ");" + NL + "        " + NL + "        int aggSize";
  protected final String TEXT_80 = " = aggStr";
  protected final String TEXT_81 = ".size();" + NL + "        if(aggSize";
  protected final String TEXT_82 = " < pivotNum";
  protected final String TEXT_83 = "){" + NL + "            " + NL + "" + NL + "    \t\tfor(int i = 0 ; i<pivotNum";
  protected final String TEXT_84 = " - aggSize";
  protected final String TEXT_85 = "-1; i++){" + NL + "                    " + NL + "\t\t\t\taggStr";
  protected final String TEXT_86 = ".add(\"\");" + NL + "            " + NL + "            }    " + NL + "               ";
  protected final String TEXT_87 = NL + NL + "\t\t\taggStr";
  protected final String TEXT_88 = ".add(\"1\");" + NL;
  protected final String TEXT_89 = NL + "            " + NL + "\t\t\taggStr";
  protected final String TEXT_90 = "));" + NL;
  protected final String TEXT_91 = NL + "\t\t\t\t" + NL + "\t\t\taggStr";
  protected final String TEXT_92 = "));" + NL + "\t\t\t\t  " + NL + "        \t";
  protected final String TEXT_93 = "));" + NL + "            ";
  protected final String TEXT_94 = NL + "  " + NL + "        }else{" + NL + "            " + NL + "            //step1: get the index of the pivot" + NL + "            int pivotIndex";
  protected final String TEXT_95 = " = 0 ;" + NL + "            " + NL + "            for(int i = 0; i<pivot_Keys";
  protected final String TEXT_96 = ".size(); i++){" + NL;
  protected final String TEXT_97 = " " + NL + " \t \t\t\tif(pivot_Keys";
  protected final String TEXT_98 = NL + "                    pivotIndex";
  protected final String TEXT_99 = " = i;" + NL + "                    " + NL + "                    break;" + NL + "                    " + NL + "                }" + NL + "                " + NL + "            }" + NL + "            " + NL + "            //step2: process the splitted data according to function" + NL + "            ";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = NL + "                ";
  protected final String TEXT_102 = " sum";
  protected final String TEXT_103 = " ;" + NL + "" + NL + "                if ((\"\").equals(aggStr";
  protected final String TEXT_104 = ".get(pivotIndex";
  protected final String TEXT_105 = "))){" + NL + "                " + NL + "                \t";
  protected final String TEXT_106 = NL + "                \t\tsum";
  protected final String TEXT_107 = " = new java.math.BigDecimal(";
  protected final String TEXT_108 = ".toPlainString());" + NL + "                \t";
  protected final String TEXT_109 = NL + "                \t\taggStr";
  protected final String TEXT_110 = ".set(pivotIndex";
  protected final String TEXT_111 = ", FormatterUtils.format_Number(sum";
  protected final String TEXT_112 = ".toPlainString(),";
  protected final String TEXT_113 = "));" + NL + "                \t";
  protected final String TEXT_114 = ", sum";
  protected final String TEXT_115 = ".toPlainString());" + NL + "                \t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t  sum";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = ".parse";
  protected final String TEXT_119 = "(";
  protected final String TEXT_120 = " + \"\");" + NL + "\t                    " + NL + "\t                      aggStr";
  protected final String TEXT_121 = ", FormatterUtils.format_Number(String.valueOf(sum";
  protected final String TEXT_122 = "));" + NL + "                      " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t  sum";
  protected final String TEXT_124 = ", String.valueOf(sum";
  protected final String TEXT_125 = NL + NL + "\t\t\t\t\t  sum";
  protected final String TEXT_126 = " + \"\");" + NL + "                    " + NL + "                      aggStr";
  protected final String TEXT_127 = "));                      " + NL + "                      " + NL + "\t\t\t\t\t";
  protected final String TEXT_128 = NL + "                    " + NL + "                }else{" + NL + "               \t\t";
  protected final String TEXT_129 = NL + "               \t\t\t" + NL + "\t\t\t\t\t\t\tjava.math.BigDecimal sourceBD_";
  protected final String TEXT_130 = " = new java.math.BigDecimal(FormatterUtils.unformat_Number(aggStr";
  protected final String TEXT_131 = "));" + NL + "\t\t\t\t\t\t\tjava.math.BigDecimal targetBD_";
  protected final String TEXT_132 = ".toString());" + NL + "\t\t\t\t\t  \t\taggStr";
  protected final String TEXT_133 = ", FormatterUtils.format_Number(sourceBD_";
  protected final String TEXT_134 = ".add(targetBD_";
  protected final String TEXT_135 = ").toString(),";
  protected final String TEXT_136 = "));" + NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + NL + "\t\t\t\t\t  \t\taggStr";
  protected final String TEXT_138 = ", (new java.math.BigDecimal(aggStr";
  protected final String TEXT_139 = "))).add(new java.math.BigDecimal(";
  protected final String TEXT_140 = ".toString())).toString());" + NL + "\t\t\t\t\t  " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t  sum";
  protected final String TEXT_142 = " = (";
  protected final String TEXT_143 = ")(";
  protected final String TEXT_144 = "(aggStr";
  protected final String TEXT_145 = ")) + ";
  protected final String TEXT_146 = "(String.valueOf(";
  protected final String TEXT_147 = ")));" + NL + "                \t" + NL + "                \t  aggStr";
  protected final String TEXT_148 = "));" + NL + "                \t  " + NL + "\t\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t" + NL + "\t\t\t\t}" + NL + "            ";
  protected final String TEXT_150 = NL + "                int count";
  protected final String TEXT_151 = " = 1;" + NL + "                " + NL + "                if (!(\"\").equals(aggStr";
  protected final String TEXT_152 = ")))" + NL + "            " + NL + "                    count";
  protected final String TEXT_153 = " = Integer.parseInt(aggStr";
  protected final String TEXT_154 = ")) + 1;" + NL + "                    " + NL + "                aggStr";
  protected final String TEXT_155 = ", String.valueOf(count";
  protected final String TEXT_156 = NL + " \t\t\t\tif (!(\"\").equals(aggStr";
  protected final String TEXT_157 = "))) {" + NL + " \t\t\t";
  protected final String TEXT_158 = NL + "               \t\t" + NL + "               \t\tString unformatedSourceStr_";
  protected final String TEXT_159 = " = FormatterUtils.unformat_Number(String.valueOf(";
  protected final String TEXT_160 = ");" + NL + "            \t\tString unformatedTargetStr_";
  protected final String TEXT_161 = " = FormatterUtils.unformat_Number(aggStr";
  protected final String TEXT_162 = ");" + NL + "\t                if(Float.parseFloat(unformatedSourceStr_";
  protected final String TEXT_163 = ")>Float.parseFloat(unformatedTargetStr_";
  protected final String TEXT_164 = "))" + NL + "\t                    aggStr";
  protected final String TEXT_165 = ", FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_166 = "));" + NL + "\t                    " + NL + "\t            ";
  protected final String TEXT_167 = NL + "\t            " + NL + "\t                if(Float.parseFloat(String.valueOf(";
  protected final String TEXT_168 = "))>Float.parseFloat(aggStr";
  protected final String TEXT_169 = ")))" + NL + "\t                    aggStr";
  protected final String TEXT_170 = ", String.valueOf(";
  protected final String TEXT_171 = NL + "            \t} else {" + NL + "            \t\taggStr";
  protected final String TEXT_172 = "));" + NL + "            \t}";
  protected final String TEXT_173 = NL + "            \tif (!(\"\").equals(aggStr";
  protected final String TEXT_174 = "))) {";
  protected final String TEXT_175 = NL + "                " + NL + "               \t\tString unformatedSourceStr_";
  protected final String TEXT_176 = ")<Float.parseFloat(unformatedTargetStr_";
  protected final String TEXT_177 = "));" + NL + "                    ";
  protected final String TEXT_178 = NL + "                " + NL + "\t                if(Float.parseFloat(String.valueOf(";
  protected final String TEXT_179 = "))<Float.parseFloat(aggStr";
  protected final String TEXT_180 = NL + "            \t" + NL + "                if ((\"\").equals(aggStr";
  protected final String TEXT_181 = ")))" + NL + "                ";
  protected final String TEXT_182 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t    aggStr";
  protected final String TEXT_183 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t\t\taggStr";
  protected final String TEXT_184 = ", FormatterUtils.format_Date(";
  protected final String TEXT_185 = "));" + NL + "\t\t\t\t  " + NL + "           \t\t\t\t";
  protected final String TEXT_186 = NL + "                " + NL + "                    \taggStr";
  protected final String TEXT_187 = "));" + NL + "                    " + NL + "                    \t";
  protected final String TEXT_188 = NL + "\t\t\t\t" + NL + "                    \taggStr";
  protected final String TEXT_189 = NL + "\t\t\t\t" + NL + "\t\t\t\t\t\taggStr";
  protected final String TEXT_190 = "));" + NL + "\t\t\t\t  " + NL + "\t\t\t\t\t";
  protected final String TEXT_191 = NL + "            " + NL + "                    \taggStr";
  protected final String TEXT_192 = "));";
  protected final String TEXT_193 = " " + NL + "            " + NL + "        }" + NL + "        " + NL + "        } " + NL + "" + NL + "    nb_line_";
  protected final String TEXT_194 = "++;" + NL + "    resourceMap.put(\"nb_line_";
  protected final String TEXT_195 = "\", nb_line_";
  protected final String TEXT_196 = "); " + NL + "   ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
List<Map<String, String>> groupbys = 
    ( List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                
            String pivotColumn = ElementParameterParser.getValue(node, "__PIVOT_COLUMN__");

            String aggColumn = ElementParameterParser.getValue(node, "__AGGREGATION_COLUMN__");

            String aggFunction = ElementParameterParser.getValue(node, "__AGGREGATION_FUNCTION__");
                
            String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
            
            String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");

            //String fieldSeparator = delim1.substring(1,delim1.length()-1);
            
            List<? extends IConnection> incomingConnections = node.getIncomingConnections();
            
                if (incomingConnections != null && !incomingConnections.isEmpty()) {
                    
                    IMetadataTable inMetadata = incomingConnections.get(0).getMetadataTable();
                    
                    String inConnName = incomingConnections.get(0).getName();
                    
                    List<IMetadataColumn> columnList = metadata.getListColumns();
                    
                    JavaType javaType = null;
                    
                    String columnType = null;
                    
                    String columnTypeValue = null;
                    
                    String columnTypeFunName = null;
                    
                    String pattern = null;
                    
                    JavaType pivotJavaType = null;
                    
					String pivotTypeToGenerate = null;
					
					IMetadataColumn columnPivot = null;
					
					String pivotpattern = null; 
					
             		for(IMetadataColumn column:columnList){
             			
             			if(column.getLabel().equals(aggColumn)){
             			
             				javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
             			
							columnType = column.getTalendType().substring(3);
							
							columnTypeValue = JavaTypesManager.getShortNameFromJavaType(JavaTypesManager.getJavaTypeFromId(column.getTalendType()));
							
							columnTypeFunName = columnTypeValue.substring(0,1).toUpperCase()+columnTypeValue.substring(1);
							
							pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

							break;
						}
             		}
	
					for(IMetadataColumn column:columnList){
					
					   	if(column.getLabel().equals(pivotColumn)){
					   	
					    		pivotJavaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					    		
					    		pivotTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					    		
					    		columnPivot = column;
					    		
					    		pivotpattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern(); 
					    							    		
					    		break;
					    }
					}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	if(JavaTypesManager.isNumberType(pivotJavaType,columnPivot.isNullable())){
	
			if(columnPivot.isNullable() || "BigDecimal".equals(pivotTypeToGenerate)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_10);
    
			}else{

    stringBuffer.append(TEXT_6);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_12);
    
			}
	}else if(pivotJavaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pivotpattern);
    stringBuffer.append(TEXT_16);
    
	}else{

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_10);
    	
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
     
		if(pivotJavaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pivotpattern);
    stringBuffer.append(TEXT_28);
     
        }else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_31);
     
		} 

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
    for (int i=0; i<groupbys.size(); i++) {
       
    	Map<String, String> groupby = groupbys.get(i);
      
      	String pattern_groupby = null;
      
      	JavaType columnType_groupby = null;
      	
		for(IMetadataColumn column:columnList){
		
			if(column.getLabel().equals(groupby.get("INPUT_COLUMN"))){
			
				columnType_groupby = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				
				pattern_groupby = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
				break;
			}
		}
		if(columnType_groupby == JavaTypesManager.DATE){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern_groupby );
    stringBuffer.append(TEXT_42);
    }else{
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    

     }
    
    
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
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
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    if( ("count").equals(aggFunction)){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }else{
	if(advancedSeparator && JavaTypesManager.isNumberType(javaType)){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }else{
  
  			if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    }else{
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }
		}
  }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    if( ("count").equals(aggFunction)){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }else{
	if(advancedSeparator && JavaTypesManager.isNumberType(javaType)){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_90);
    }else{
  
  			if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_92);
    }else{
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_93);
    			}
        }
  }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
	if(JavaTypesManager.isNumberType(pivotJavaType,columnPivot.isNullable())){
	
			if(columnPivot.isNullable() || "BigDecimal".equals(pivotTypeToGenerate)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_10);
    
			}else{

    stringBuffer.append(TEXT_6);
    stringBuffer.append( pivotTypeToGenerate );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_12);
    
			}
	}else if(pivotJavaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pivotpattern);
    stringBuffer.append(TEXT_16);
    
	}else{

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pivotColumn);
    stringBuffer.append(TEXT_10);
    	
	}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
      
            if( ("sum").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnTypeValue);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
                	if(("BigDecimal").equals(columnType)) {
                	
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_108);
    
                		if(advancedSeparator){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_113);
    
                		} else {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
                		}
					} else if(("Double").equals(columnType)||("Float").equals(columnType)){
						if(advancedSeparator){
						
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_122);
    }else{
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    }
					  }else{
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    if(("BigDecimal").equals(columnType) || ("Double").equals(columnType)||("Float").equals(columnType)){
               			if(advancedSeparator){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_136);
    }else{
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_140);
    }
					}else{
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columnTypeValue);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnTypeFunName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    
            }else if( ("count").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
            }else if( ("max").equals(aggFunction) ){
 			
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
               	if(advancedSeparator){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_166);
    }else{
    stringBuffer.append(TEXT_167);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_93);
    
            	}
            
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_172);
    
            }else if( ("min").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
               	if(advancedSeparator){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_177);
    }else{
    stringBuffer.append(TEXT_178);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_93);
    
            	}
            
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_172);
    
            }else if( ("first").equals(aggFunction) ){
            
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    if(advancedSeparator){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_177);
    }else{
                    	if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_185);
    }else{
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_187);
    }
            		}
            }else if( ("last").equals(aggFunction) ){
            	if(advancedSeparator){
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_177);
    }else{
           			if(("Date").equals(columnType)){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_190);
    }else{
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggColumn);
    stringBuffer.append(TEXT_192);
    }
            	}
            }
            
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
        }
    }
}

    stringBuffer.append(TEXT_100);
    return stringBuffer.toString();
  }
}
