package com.my.learning.utility;

public class Helper {
    public static String getFieldName(Object fieldObject, Object parent) {

        java.lang.reflect.Field[] allFields = parent.getClass().getFields();
        for (java.lang.reflect.Field field : allFields) {
            Object currentFieldObject;
            try {
                currentFieldObject = field.get(parent);
            } catch (Exception e) {
                return null;
            }
            boolean isWantedField = fieldObject.equals(currentFieldObject);
            if (isWantedField) {
                String fieldName = field.getName();
                return fieldName;
            }
        }
        return null;
    }
}
