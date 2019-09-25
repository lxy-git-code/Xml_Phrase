package com.lxy.xevent;

import java.io.InputStream;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import com.lxy.stax.XML_Stax;

public class Xml_Xevent {
	public static void main(String[] args) {
		try {
			XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
			InputStream inputStream = XML_Stax.class.getClassLoader().getResourceAsStream("books.xml");
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);

			xmlInputFactory.createFilteredReader(reader, new EventFilter() {

				@Override
				public boolean accept(XMLEvent event) {
					// TODO Auto-generated method stub
					if (event.isStartElement())
						return true;
					return false;
				}
			});

			StringBuilder sB = new StringBuilder();
			while (reader.hasNext()) {

				XMLEvent xmlEvent = reader.nextEvent();

				if (xmlEvent.isCharacters()) {
					Characters characters = xmlEvent.asCharacters();
					sB.append(characters.getData());
				} else if (xmlEvent.isStartElement()) {
					QName name = xmlEvent.asStartElement().getName();
					Iterator iterator = xmlEvent.asStartElement().getAttributes();
					sB.append("<" + name);
					while (iterator.hasNext()) {
						sB.append(iterator.next().toString());
					}
					sB.append(">");
				} else if (xmlEvent.isEndElement()) {
					QName name = xmlEvent.asEndElement().getName();
					sB.append("</" + name + ">");
				}
			}
			System.out.println(sB.toString());
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
