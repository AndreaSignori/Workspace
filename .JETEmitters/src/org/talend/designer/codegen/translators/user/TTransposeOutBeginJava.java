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

public class TTransposeOutBeginJava
{
  protected static String nl;
  public static synchronized TTransposeOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTransposeOutBeginJava result = new TTransposeOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "java.util.ArrayList<java.util.ArrayList<String>> listOfList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<java.util.ArrayList<String>>();" + NL + "globalMap.put(\"array_";
  protected final String TEXT_3 = "\",listOfList_";
  protected final String TEXT_4 = ");" + NL + "" + NL + "Integer nb_input_";
  protected final String TEXT_5 = "=0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
