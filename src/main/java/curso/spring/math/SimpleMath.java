package curso.spring.math;
import org.springframework.stereotype.Service;

@Service
public class SimpleMath {
    
    public Double sum(Double number1, Double number2){
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2){
        return number1 - number2;
    }

    public Double mult(Double number1, Double number2){
        return number1 * number2;
    }

    public Double div(Double number1, Double number2)  {
        return number1 / number2;
    }

    public Double avg(Double number1, Double number2){
        return (number1 + number2) / 2;
    }

    public Double raiz(Double number1)  {
        return  Math.sqrt(number1);
    }
}
