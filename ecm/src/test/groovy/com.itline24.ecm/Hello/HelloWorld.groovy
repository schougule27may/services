import com.itline24.ecm.service.MathExample
import spock.lang.*

class HelloWorld extends Specification {

    MathExample math

    def setup() {
        math = new MathExample();
    }

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }


    def  "Sum of two integers"() {
        given :
        int a = 20;
        int b = 10;
        int output ;
        when :
        output  = math.add(a,b)
        then :
        println output
        output == 20

    }
}
