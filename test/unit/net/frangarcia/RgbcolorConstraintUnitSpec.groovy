package net.frangarcia

import org.springframework.validation.Errors
import spock.lang.Specification
import spock.lang.Unroll

class RgbcolorConstraintUnitSpec extends Specification {

    def "Returning the name of the constraint"() {
        expect:
            new RgbcolorConstraint().name == "rgbcolor"
    }

    @Unroll
    def "If rgb color does not have the right format, reject value is called"(){
        given:
            def calls = 0
            RgbcolorConstraint.metaClass.rejectValue = { Object target,Errors errors, String defaultMessageCode, String code, Object[] args ->
                if (defaultMessageCode=="Invalid rgb color format" && code=="default.rgbcolor.invalidFormat.message")
                    calls++
                return
            }
        and:
            def tmc = new RgbcolorConstraint()
        when:
            tmc.processValidate(null, rgbcolor, null)
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
