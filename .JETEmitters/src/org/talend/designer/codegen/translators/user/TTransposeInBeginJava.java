package org.talend.designer.codegen.translators.user;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TTransposeInBeginJava
{
  protected static String nl;
  public static synchronized TTransposeInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTransposeInBeginJava result = new TTransposeInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "// column list" + NL + "\tjava.util.ArrayList<String> listColumn_";
  protected final String TEXT_3 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_4 = NL + "    listColumn_";
  protected final String TEXT_5 = ".add(\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + NL + "Integer nb_output_";
  protected final String TEXT_8 = "=0;" + NL + "" + NL + "for (int i=0;i< ";
  protected final String TEXT_9 = "; i++ ) {" + NL + "    " + NL + "    nb_output_";
  protected final String TEXT_10 = "++;" + NL + "      " + NL + "\tjava.util.ArrayList<String> rowList";
  protected final String TEXT_11 = "= new java.util.ArrayList<String>();";
  protected final String TEXT_12 = NL + "\t";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = listColumn_";
  protected final String TEXT_15 = ".get(i);";
  protected final String TEXT_16 = NL + "    if ( nb_input_";
  protected final String TEXT_17 = " > ";
  protected final String TEXT_18 = " ) {" + NL + "\t\trowList";
  protected final String TEXT_19 = " = listOfList_";
  protected final String TEXT_20 = ".get(";
  protected final String TEXT_21 = ");\t" + NL + "\t\t";
  protected final String TEXT_22 = " = rowList";
  protected final String TEXT_23 = ".get(i);" + NL + "\t}    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String origin = ElementParameterParser.getValue(node, "__ORIGIN__");
String rowName = "";


IConnection connIN = null;
String connINName = "";

IConnection connOUT = null;
String connOUTName = "";

	for (INode pNode : node.getProcess().getNodesOfType("tTransposeOut")) {
		if (!pNode.getUniqueName().equals(origin + "_TransposeOut")) continue;
		for (IConnection conn : pNode.getIncomingConnections()) {
			rowName = conn.getName();
			connIN = conn;
			connINName = conn.getName();
			break;
		}
		
	}

    
   List< ? extends IConnection> conns = node.getOutgoingConnections(org.talend.core.model.process.EConnectionType.FLOW_MAIN);
	for (IConnection conn : conns) {
	    IMetadataTable metadataTable = conn.getMetadataTable();
	 	connOUT = conn;
		connOUTName = conn.getName();
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_3);
    
	    for (IMetadataColumn column :   connIN.getMetadataTable().getListColumns() ){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_6);
    
		}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connIN.getMetadataTable().getListColumns().size());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
        int j = 0; 
	    for (IMetadataColumn column :   connOUT.getMetadataTable().getListColumns() ){
	    	if ( "columnLabel".equals(column.getLabel()) ) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(connOUTName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_15);
    
			} else  {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connOUTName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			j++;
			}
		}

    return stringBuffer.toString();
  }
}
