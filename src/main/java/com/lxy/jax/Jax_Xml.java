package com.lxy.jax;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.lxy.bean.Student;

public class Jax_Xml {
	public static void main(String[] args) {
		try {
			/* 使用JAXBContext进行Bean-xml之间的转换 */
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(new Student(1, "李兴宇", "男", 28), System.out);

			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
					+ "   <student>"
					+ "   <age>28</age>"
					+ "   <gender>男</gender>"
					+ "   <id>1</id>"
					+ "   <name>李兴宇</name>"
					+ "   </student>";
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student)unmarshaller.unmarshal(new StringReader(xml));
			System.out.println("\n"+student+"");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}
}
