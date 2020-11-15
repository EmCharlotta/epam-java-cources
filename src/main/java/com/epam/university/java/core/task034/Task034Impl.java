package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Task034Impl implements Task034 {

    public static PersonImpl person = new PersonImpl();

    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            parser.parse(Task034Impl.class.getClassLoader().getResourceAsStream(
                    "task034/data.xml"), handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {

            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class,
                    PhoneNumberImpl.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (PersonImpl) un.unmarshal(Task034Impl.class.getClassLoader().getResourceAsStream(
                    "task034/data.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = null;
        Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(
                    Task034Impl.class.getClassLoader().getResourceAsStream("task034/data.xml"));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("person")) {
                        person = new PersonImpl();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            person.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("first-name")) {
                        xmlEvent = reader.nextEvent();
                        person.setFirstName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("last-name")) {
                        xmlEvent = reader.nextEvent();
                        person.setLastName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("person-phone")) {
                        xmlEvent = reader.nextEvent();
                        PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                        phoneNumber.setPhoneNumber(xmlEvent.asCharacters().getData());
                        phoneNumbers.add(phoneNumber);
                        person.setPhoneNumbers(phoneNumbers);
                    }
                }

            }
        } catch (XMLStreamException exc) {
            exc.printStackTrace();
        }
        return person;
    }
}
