import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors
import java.util.regex.Pattern

class TwitterMessageConstraint extends AbstractConstraint {

    public static final String CONSTRAINT_NAME = "twitterMessage"

    protected void processValidate(Object target, Object propertyValue, Errors errors) {
        if (propertyValue?.size()>140) {
            Object[] args = [ constraintPropertyName, constraintOwningClass, propertyValue ]
            rejectValue(target, errors, "Invalid string format", "default.string.invalidFormat.message", args)
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
