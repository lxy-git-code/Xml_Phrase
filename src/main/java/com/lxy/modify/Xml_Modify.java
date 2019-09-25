package com.lxy.modify;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Xml_Modify {
public static void main(String[] args) {
	try {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		InputStream inputStream = Xml_Modify.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = documentBuilder.parse(inputStream);
        
        XPathFactory xFactory = XPathFactory.newInstance();
        XPath xPath = xFactory.newXPath();
        NodeList list = (NodeList)xPath.evaluate("//book[title='Learning XML']", document, XPathConstants.NODESET);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        //设置编码
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        
    	Node item = list.item(0);
		Element e=(Element)item;
		Element price =(Element) e.getElementsByTagName("price").item(0);
		price.setTextContent("444");
		//new StreamResult(System.out)指明结果输出目前输出到System.out中
		transformer.transform(new DOMSource(document), new StreamResult(System.out));
        
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (XPathExpressionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
}
