import grails.validation.ValidationErrors
import org.springframework.validation.Errors
import spock.lang.Specification
import spock.lang.Unroll

class TwitterMessageConstraintUnitSpec extends Specification {

    def "Returning the name of the constraint"() {
        expect:
            new TwitterMessageConstraint().name == "twitterMessage"
    }

    @Unroll
    def "If content has more than 140 chars, errors returns filled up"(){
        given:
            def calls = 0
            TwitterMessageConstraint.metaClass.rejectValue = { Object target,Errors errors, String defaultMessageCode, String code, Object[] args ->
                if (defaultMessageCode=="Invalid string format" && code=="default.string.invalidFormat.message")
                    calls++
                return
            }
        and:
            def tmc = new TwitterMessageConstraint()
        and:
            def object = new Object()
            ValidationErrors errors = new ValidationErrors(object)
        when:
            tmc.processValidate(object, 'a'*size, errors)
        then:
            calls == expectedCalls
        cleanup:
            TwitterMessageConstraint.metaClass = null
        where:
            size    ||  expectedCalls
            0       ||  0
            1       ||  0
            140     ||  0
            141     ||  1
    }
}
