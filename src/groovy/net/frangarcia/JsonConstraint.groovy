package net.frangarcia

import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class JsonConstraint extends AbstractConstraint {

    public static final String CONSTRAINT_NAME = "json"

    protected void processValidate(target, propertyValue, Errors errors) {
        try {
            new JsonSlurper().parseText(propertyValue)
        }
        catch (ignored) {
            rejectValue(target, errors, "Invalid json format", "default.json.invalidFormat.message",
               [ constraintPropertyName, constraintOwningClass, propertyValue ] as Object[])
        }
    }

    boolean supports(Class type) {
        String.isAssignableFrom(type)
    }

    String getName() { CONSTRAINT_NAME }
}
