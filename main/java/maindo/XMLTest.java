package maindo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTest {
	public static void main (String [] args) {
		try {
			SSSXML();
		} catch (IOException | SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SSSXML() throws IOException, SAXException, ParserConfigurationException {
        //创建一个DOM解析器(文档生成器)工厂对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //通过工厂对象创建一个DOM解析器对象
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputStream resourceAsStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\监督平台xml\\20200611-000001-500.xml");
        File file = new File("C:\\Users\\Administrator\\Desktop\\监督平台xml\\20200611-000001-500.xml");
        //此代码完成后,整个XML文档已经被加载到内存中,以树状形式存储;
        Document parse = documentBuilder.parse(resourceAsStream);
        //4.从内存中读取数据生成对象

        //获取节点名称为person的所有节点,返回节点集合.
        NodeList personNodeList = parse.getElementsByTagName("HEADDATA");

        //循环读取
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);
            //获取节点属性值;
           // String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            String text = personNode.getTextContent();
            System.out.println(text);
            //获取当前节点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if("FROMPLATFORMCODE".equals(nodeName)){
                	System.out.println("FROMPLATFORMCODE:"+item.getTextContent());
                }else if("TOPLATFORMCODE".equals(nodeName)){
                	System.out.println("TOPLATFORMCODE:"+item.getTextContent());
                }
                else if("DATA_NO".equals(nodeName)){
                	System.out.println("DATA_NO:"+item.getTextContent());
                }
                else if("DATA_EN".equals(nodeName)){
                	System.out.println("DATA_EN:"+item.getTextContent());
                }
                else if("DATA_CN".equals(nodeName)){
                	System.out.println("DATA_CN:"+item.getTextContent());
                }
                else {
                	System.out.println("其他:"+item.getTextContent());
                }
            }
        }
    }
}
