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

public class TTransposeOutMainJava
{
  protected static String nl;
  public static synchronized TTransposeOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTransposeOutMainJava result = new TTransposeOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\tjava.util.ArrayList<String> rowList";
  protected final String TEXT_3 = "= new java.util.ArrayList<String>();";
  protected final String TEXT_4 = "\t" + NL + "\trowList";
  protected final String TEXT_5 = ".add(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tlistOfList_";
  protected final String TEXT_9 = ".add(rowList";
  protected final String TEXT_10 = ");" + NL + "\tnb_input_";
  protected final String TEXT_11 = "++;";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();


String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
String rowName= "";
if ((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0)) {
	rowName = node.getIncomingConnections().get(0).getName();
} else {
	rowName="defaultRow";
}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	for ( IConnection connIN : node.getIncomingConnections() ) {
		for (IMetadataColumn column : connIN.getMetadataTable().getListColumns() ) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_7);
    
		}
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
