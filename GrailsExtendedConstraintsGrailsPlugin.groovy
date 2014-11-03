import net.frangarcia.TwitterMessageConstraint
import org.codehaus.groovy.grails.validation.ConstrainedProperty

class GrailsExtendedConstraintsGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.4 > *"
    def pluginExcludes = [
        "grails-app/domain/**"
    ]

    def title = "Grails Extended Constraints Plugin"
    def author = "Fran Garcia"
    def authorEmail = "fgarciarico@gmail.com"
    def description = 'Grails extendend constraints plugin'
    def documentation = "http://grails.org/plugin/grails-extended-constraints"

    def license = "APACHE"
//    def developers = [ [ name: "Joe Bloggs", email	: "joe@bloggs.net" ]]
    def issueManagement = [system: 'GITHUB', url: 'https://github.com/frangarcia/grails-extended-constraints/issues']
    def scm = [url: 'https://github.com/frangarcia/grails-extended-constraints']

    def doWithSpring = {
        ConstrainedProperty.registerNewConstraint(TwitterMessageConstraint.CONSTRAINT_NAME, TwitterMessageConstraint)
    }
}
