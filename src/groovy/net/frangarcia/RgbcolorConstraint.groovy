package net.frangarcia

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class RgbcolorConstraint extends AbstractConstraint {

    public static final String CONSTRAINT_NAME = "rgbcolor"

    protected void processValidate(target, propertyValue, Errors errors) {
        if (!(propertyValue ==~ /#[0-9A-Fa-f]{6}/)) {
            rejectValue(target, errors, "Invalid rgb color format", "default.rgbcolor.invalidFormat.message",
            	[ constraintPropertyName, constraintOwningClass, propertyValue ] as Object)
        }
    }

    boolean supports(Class type) {
        String.isAssignableFrom(type)
    }

    String getName() { CONSTRAINT_NAME }
}
