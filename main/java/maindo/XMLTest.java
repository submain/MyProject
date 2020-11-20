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
        //����һ��DOM������(�ĵ�������)��������
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //ͨ���������󴴽�һ��DOM����������
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputStream resourceAsStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\�ලƽ̨xml\\20200611-000001-500.xml");
        File file = new File("C:\\Users\\Administrator\\Desktop\\�ලƽ̨xml\\20200611-000001-500.xml");
        //�˴�����ɺ�,����XML�ĵ��Ѿ������ص��ڴ���,����״��ʽ�洢;
        Document parse = documentBuilder.parse(resourceAsStream);
        //4.���ڴ��ж�ȡ�������ɶ���

        //��ȡ�ڵ�����Ϊperson�����нڵ�,���ؽڵ㼯��.
        NodeList personNodeList = parse.getElementsByTagName("HEADDATA");

        //ѭ����ȡ
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);
            //��ȡ�ڵ�����ֵ;
           // String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            String text = personNode.getTextContent();
            System.out.println(text);
            //��ȡ��ǰ�ڵ�������ӽڵ�
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
                	System.out.println("����:"+item.getTextContent());
                }
            }
        }
    }
}
