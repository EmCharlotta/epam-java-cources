package com.epam.university.java.core.task034;

import javax.xml.bind.annotation.XmlValue;

public class PhoneNumberImpl implements PhoneNumber {
    String phoneNumber;

    @Override
    @XmlValue
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
