package net.frangarcia

import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class JsonConstraint extends AbstractConstraint {

    public static final String CONSTRAINT_NAME = "json"

    protected void processValidate(Object target, Object propertyValue, Errors errors) {
        try {
            new JsonSlurper().parseText(propertyValue)
            return
        }
        catch (Exception e) {
            Object[] args = [ constraintPropertyName, constraintOwningClass, propertyValue ]
            rejectValue(target, errors, "Invalid json format", "default.json.invalidFormat.message", args)
            return
        }
    }

    boolean supports(Class type) {
        return type && String.class.isAssignableFrom(type);
    }

    String getName() {
        return CONSTRAINT_NAME;
    }
}
