package net.frangarcia

import grails.validation.ValidationErrors
import org.springframework.validation.Errors
import spock.lang.Specification
import spock.lang.Unroll
import net.frangarcia.*

class RgbcolorConstraintUnitSpec extends Specification {

    def "Returning the name of the constraint"() {
        expect:
            new RgbcolorConstraint().name == "rgbcolor"
    }

    @Unroll
    def "If content has more than 140 chars, errors returns filled up"(){
        given:
            def calls = 0
            RgbcolorConstraint.metaClass.rejectValue = { Object target,Errors errors, String defaultMessageCode, String code, Object[] args ->
                if (defaultMessageCode=="Invalid string format" && code=="default.string.invalidFormat.message")
                    calls++
                return
            }
        and:
            def tmc = new RgbcolorConstraint()
        and:
            def object = new Object()
            ValidationErrors errors = new ValidationErrors(object)
        when:
            tmc.processValidate(object, rgbcolor, errors)
        then:
            calls == expectedCalls
        cleanup:
            RgbcolorConstraint.metaClass = null
        where:
            rgbcolor    ||  expectedCalls
            null        ||  1
            ""          ||  1
            "#"         ||  1
            "#GGGGGG"   ||  1
            "#0000000"  ||  1
            "#FFFFFFF"  ||  1
            "#000000"   ||  0
            "#aaaaaa"   ||  0
            "#AAAAAA"   ||  0
            "#ffffff"   ||  0
            "#FFFFFF"   ||  0
    }
}
