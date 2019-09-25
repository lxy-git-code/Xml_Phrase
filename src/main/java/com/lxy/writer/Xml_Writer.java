package com.lxy.writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Xml_Writer {
	public static void main(String[] args) {
		try {
			XMLOutputFactory factory = XMLOutputFactory.newFactory();
			XMLStreamWriter xmlStreamWriter = factory.createXMLStreamWriter(System.out);
			xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
			xmlStreamWriter.writeEndDocument();
			xmlStreamWriter.writeStartElement("pseron");
			xmlStreamWriter.writeAttribute("sex", "male");
			xmlStreamWriter.writeStartElement("address");
			xmlStreamWriter.writeCharacters("xi'an");
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.flush();//注意flush和close
			xmlStreamWriter.close();//
			
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
