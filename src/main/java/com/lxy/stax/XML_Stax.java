package com.lxy.stax;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XML_Stax {
	public static void main(String[] args) {
		try {
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			InputStream inputStream = XML_Stax.class.getClassLoader().getResourceAsStream("books.xml");
			XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(inputStream);
			StringBuilder sB = new StringBuilder();
		
		    sB.append("<?xml version=\""+reader.getVersion()+"\" encoding=\""+reader.getEncoding()+"\"?>\n");
		
			while(reader.hasNext())
			{
				int val = reader.next();
				 if (val==XMLStreamConstants.CHARACTERS){
					sB.append(reader.getText());
				}
				else if (val==XMLStreamConstants.START_ELEMENT)
				{
					if(reader.getAttributeCount()!=0)
					sB.append("<"+reader.getName()+" "+reader.getAttributeName(0)+"=\""+reader.getAttributeValue(0)+"\">");
					else
						sB.append("<"+reader.getName()+">");

				}else if (val==XMLStreamConstants.END_ELEMENT)
				{
					sB.append("</"+reader.getName()+">");
				}
			}
			System.out.println(sB.toString());
			
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
