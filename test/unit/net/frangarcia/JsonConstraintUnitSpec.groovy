package net.frangarcia

import grails.validation.ValidationErrors
import groovy.json.JsonSlurper
import org.springframework.validation.Errors
import spock.lang.Specification
import spock.lang.Unroll

class JsonConstraintUnitSpec extends Specification {

    def "Returning the name of the constraint"() {
        expect:
            new JsonConstraint().name == "json"
    }

    @Unroll
    def "If json does not have the right format, reject value is called"(){
        given:
            def calls = 0
            JsonConstraint.metaClass.rejectValue = { Object target,Errors errors, String defaultMessageCode, String code, Object[] args ->
                if (defaultMessageCode=="Invalid json format" && code=="default.json.invalidFormat.message")
                    calls++
                return
            }
        and:
            JsonSlurper.metaClass.parseText = { String str ->
                if (e)
                    throw e
            }
        and:
            def tmc = new JsonConstraint()
        when:
            tmc.processValidate(null, "", null)
        then:
            calls == expectedCalls
        cleanup:
            JsonConstraint.metaClass = null
            JsonSlurper.metaClass = null
        where:
            e               ||  expectedCalls
            null            ||  0
            new Exception() ||  1
    }
}
