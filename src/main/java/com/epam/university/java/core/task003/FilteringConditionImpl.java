package com.epam.university.java.core.task003;

public class FilteringConditionImpl implements FilteringCondition {
    @Override
    public boolean isValid(String element) {
        boolean isValid = true;
        if (element.equals("One") || element.equals("Two")) {
            isValid = false;
        }
        return isValid;
    }
}
