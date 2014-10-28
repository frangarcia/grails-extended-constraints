package net.frangarcia

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class RgbcolorConstraint extends AbstractConstraint {

    public static final String CONSTRAINT_NAME = "rgbcolor"

    protected void processValidate(Object target, Object propertyValue, Errors errors) {
        if (!(propertyValue ==~ /#[0-9A-Fa-f]{6}/)) {
            Object[] args = [ constraintPropertyName, constraintOwningClass, propertyValue ]
            rejectValue(target, errors, "Invalid rgb color format", "default.rgbcolor.invalidFormat.message", args)
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
