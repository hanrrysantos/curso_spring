package curso.spring.exceptions.handler;

import curso.spring.exceptions.exceptionreponse.StandardError;
import curso.spring.exceptions.UnsupportedMathOperationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handAllExceptions(Exception ex, HttpServletRequest request){
        String error ="Exception";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err  = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public ResponseEntity<StandardError> handleBadRequestExceptions(UnsupportedMathOperationException e, HttpServletRequest request){
        String error ="Unsupported math operation";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err  = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
