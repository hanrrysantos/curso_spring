package curso.spring.controllers;

import curso.spring.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    //http:localhost:8080/math/sum/3/5
    @RequestMapping(value= "/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws IllegalArgumentException {
            if (!isNumeric(number1) || !isNumeric(number2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
            return convertToDouble(number1) + convertToDouble(number2);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }


    //http:localhost:8080/math/sub/3/5
    //http:localhost:8080/math/div/3/5
    //http:localhost:8080/math/multi/3/5
}
