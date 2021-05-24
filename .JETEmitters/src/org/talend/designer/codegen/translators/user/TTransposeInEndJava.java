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

public class TTransposeInEndJava
{
  protected static String nl;
  public static synchronized TTransposeInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTransposeInEndJava result = new TTransposeInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t} // for " + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE_INPUT\",nb_input_";
  protected final String TEXT_3 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE_OUTPUT\",nb_output_";
  protected final String TEXT_5 = "); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String origin = ElementParameterParser.getValue(node, "__ORIGIN__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(origin);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(origin);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
