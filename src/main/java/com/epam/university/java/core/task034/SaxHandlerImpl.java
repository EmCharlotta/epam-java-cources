package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;

public class SaxHandlerImpl extends SaxHandler {
    String elementName;
    Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
    String firstName;
    String lastName;

    @Override
    public void endDocument() throws SAXException {
        Task034Impl.person.setPhoneNumbers(phoneNumbers);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        elementName = qName;
        if (qName.equals("person")) {

            int id = Integer.parseInt(attributes.getValue("id"));
            Task034Impl.person.setId(id);

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!firstName.isEmpty()) {
            Task034Impl.person.setFirstName(firstName);
        } else if (!lastName.isEmpty()) {
            Task034Impl.person.setLastName(lastName);
        }
        firstName = "";
        lastName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();
        if (!information.isEmpty() && !information.isBlank()) {
            if (elementName.equals("first-name")) {
                firstName = information;
            } else if (elementName.equals("last-name")) {
                lastName = information;
            } else if (elementName.equals("person-phone")) {
                PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(information);
                phoneNumbers.add(phoneNumber);
            }
        }
    }
}

