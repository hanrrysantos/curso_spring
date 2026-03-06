package curso.spring.controllers;

import curso.spring.exceptions.UnsupportedMathOperationException;
import curso.spring.math.SimpleMath;
import curso.spring.request.NumberConverters;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    public SimpleMath simpleMath;

    public MathController(SimpleMath simpleMath){
        this.simpleMath = simpleMath;
    }

    //http:localhost:8080/math/sum/3/5
    @RequestMapping(value= "/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
            if (!NumberConverters.isNumeric(number1) || (!NumberConverters.isNumeric(number2))) throw new UnsupportedMathOperationException("Please set a numeric value!");
            return simpleMath.sum(NumberConverters.convertToDouble(number1), NumberConverters.convertToDouble(number2));
    }

    @RequestMapping(value= "/sub/{number1}/{number2}")
    public Double sub(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverters.isNumeric(number1) || (!NumberConverters.isNumeric(number2))) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.sub(NumberConverters.convertToDouble(number1), NumberConverters.convertToDouble(number2));
    }

    @RequestMapping(value= "/mult/{number1}/{number2}")
    public Double mult(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverters.isNumeric(number1) || (!NumberConverters.isNumeric(number2))) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.mult(NumberConverters.convertToDouble(number1), NumberConverters.convertToDouble(number2));
    }

    @RequestMapping(value= "/div/{number1}/{number2}")
    public Double div(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverters.isNumeric(number1) || (!NumberConverters.isNumeric(number2))) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.div(NumberConverters.convertToDouble(number1), NumberConverters.convertToDouble(number2));
    }

    @RequestMapping(value= "/avg/{number1}/{number2}")
    public Double avg(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!NumberConverters.isNumeric(number1) || (!NumberConverters.isNumeric(number2))) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.avg(NumberConverters.convertToDouble(number1), NumberConverters.convertToDouble(number2));
    }

    @RequestMapping(value= "/raiz/{number1}")
    public Double raiz(
            @PathVariable("number1") String number1
    ) throws Exception {
        if (!NumberConverters.isNumeric(number1)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.raiz((NumberConverters.convertToDouble(number1)));
    }
}
