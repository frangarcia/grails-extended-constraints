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
    def "If rgb color does not have the right format, reject value is called - #rgbcolor"() {
        given:
            int calls = 0
            RgbcolorConstraint.metaClass.rejectValue = { target, Errors errors, String defaultMessageCode, String code, Object[] args ->
                if (defaultMessageCode=="Invalid rgb color format" && code=="default.rgbcolor.invalidFormat.message")
                    calls++
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
            rgbcolor                ||  expectedCalls
            null                    ||  1
            ""                      ||  1
            "#"                     ||  1
            "#GGGGGG"               ||  1
            "#0000000"              ||  1
            "#FFFFFFF"              ||  1
            "#000000"               ||  0
            "#aaaaaa"               ||  0
            "#AAAAAA"               ||  0
            "#ffffff"               ||  0
            "#FFFFFF"               ||  0
            "#000"                  ||  0
            "#aaa"                  ||  0
            "#AAA"                  ||  0
            "#fff"                  ||  0
            "#FFF"                  ||  0
            "aliceblue"             ||  0
            "antiquewhite"          ||  0
            "aqua"                  ||  0
            "aquamarine"            ||  0
            "azure"                 ||  0
            "beige"                 ||  0
            "bisque"                ||  0
            "black"                 ||  0
            "blanchedalmond"        ||  0
            "blue"                  ||  0
            "blueviolet"            ||  0
            "brown"                 ||  0
            "burlywood"             ||  0
            "cadetblue"             ||  0
            "chartreuse"            ||  0
            "chocolate"             ||  0
            "coral"                 ||  0
            "cornflowerblue"        ||  0
            "cornsilk"              ||  0
            "crimson"               ||  0
            "cyan"                  ||  0
            "darkblue"              ||  0
            "darkcyan"              ||  0
            "darkgoldenrod"         ||  0
            "darkgray"              ||  0
            "darkgreen"             ||  0
            "darkgrey"              ||  0
            "darkkhaki"             ||  0
            "darkmagenta"           ||  0
            "darkolivegreen"        ||  0
            "darkorange"            ||  0
            "darkorchid"            ||  0
            "darkred"               ||  0
            "darksalmon"            ||  0
            "darkseagreen"          ||  0
            "darkslateblue"         ||  0
            "darkslategray"         ||  0
            "darkslategrey"         ||  0
            "darkturquoise"         ||  0
            "darkviolet"            ||  0
            "deeppink"              ||  0
            "deepskyblue"           ||  0
            "dimgray"               ||  0
            "dimgrey"               ||  0
            "dodgerblue"            ||  0
            "firebrick"             ||  0
            "floralwhite"           ||  0
            "forestgreen"           ||  0
            "fuchsia"               ||  0
            "gainsboro"             ||  0
            "ghostwhite"            ||  0
            "gold"                  ||  0
            "goldenrod"             ||  0
            "gray"                  ||  0
            "green"                 ||  0
            "greenyellow"           ||  0
            "grey"                  ||  0
            "honeydew"              ||  0
            "hotpink"               ||  0
            "indianred"             ||  0
            "indigo"                ||  0
            "ivory"                 ||  0
            "khaki"                 ||  0
            "lavender"              ||  0
            "lavenderblush"         ||  0
            "lawngreen"             ||  0
            "lemonchiffon"          ||  0
            "lightblue"             ||  0
            "lightcoral"            ||  0
            "lightcyan"             ||  0
            "lightgoldenrodyellow"  ||  0
            "lightgray"             ||  0
            "lightgreen"            ||  0
            "lightgrey"             ||  0
            "lightpink"             ||  0
            "lightsalmon"           ||  0
            "lightseagreen"         ||  0
            "lightskyblue"          ||  0
            "lightslategray"        ||  0
            "lightslategrey"        ||  0
            "lightsteelblue"        ||  0
            "lightyellow"           ||  0
            "lime"                  ||  0
            "limegreen"             ||  0
            "linen"                 ||  0
            "magenta"               ||  0
            "maroon"                ||  0
            "mediumaquamarine"      ||  0
            "mediumblue"            ||  0
            "mediumorchid"          ||  0
            "mediumpurple"          ||  0
            "mediumseagreen"        ||  0
            "mediumslateblue"       ||  0
            "mediumspringgreen"     ||  0
            "mediumturquoise"       ||  0
            "mediumvioletred"       ||  0
            "midnightblue"          ||  0
            "mintcream"             ||  0
            "mistyrose"             ||  0
            "moccasin"              ||  0
            "navajowhite"           ||  0
            "navy"                  ||  0
            "oldlace"               ||  0
            "olive"                 ||  0
            "olivedrab"             ||  0
            "orange"                ||  0
            "orangered"             ||  0
            "orchid"                ||  0
            "palegoldenrod"         ||  0
            "palegreen"             ||  0
            "paleturquoise"         ||  0
            "palevioletred"         ||  0
            "papayawhip"            ||  0
            "peachpuff"             ||  0
            "peru"                  ||  0
            "pink"                  ||  0
            "plum"                  ||  0
            "powderblue"            ||  0
            "purple"                ||  0
            "red"                   ||  0
            "rosybrown"             ||  0
            "royalblue"             ||  0
            "saddlebrown"           ||  0
            "salmon"                ||  0
            "sandybrown"            ||  0
            "seagreen"              ||  0
            "seashell"              ||  0
            "sienna"                ||  0
            "silver"                ||  0
            "skyblue"               ||  0
            "slateblue"             ||  0
            "slategray"             ||  0
            "slategrey"             ||  0
            "snow"                  ||  0
            "springgreen"           ||  0
            "steelblue"             ||  0
            "tan"                   ||  0
            "teal"                  ||  0
            "thistle"               ||  0
            "tomato"                ||  0
            "turquoise"             ||  0
            "violet"                ||  0
            "wheat"                 ||  0
            "white"                 ||  0
            "whitesmoke"            ||  0
            "yellow"                ||  0
            "yellowgreen"           ||  0
    }
}
