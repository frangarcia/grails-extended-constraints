package net.frangarcia

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class TwitterMessageConstraint extends AbstractConstraint {

    public static final String CONSTRAINT_NAME = "twitterMessage"

    protected void processValidate(target, propertyValue, Errors errors) {
        if (propertyValue?.size()>140) {
            rejectValue(target, errors, "Invalid string format", "default.string.invalidFormat.message",
            	[ constraintPropertyName, constraintOwningClass, propertyValue ] as Object[])
        }
    }

    boolean supports(Class type) {
        String.isAssignableFrom(type)
    }

    String getName() { CONSTRAINT_NAME }
}
