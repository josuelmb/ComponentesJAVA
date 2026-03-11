package pe.edu.idat.proyecto.gestion.exception;
//posibles errores

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

//@ControllerAdvice
@RestControllerAdvice

public class GlobalException {
    @ExceptionHandler (MethodArgumentNotValidException.class)

    public ResponseEntity<ErrorException> handleException(MethodArgumentNotValidException ex, WebRequest webRequest){
        String detalleErrores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(m -> m.getField() + ": "+ m.getDefaultMessage()) //Reune los errores y los reune en un collect
                .collect(Collectors.joining());

        ErrorException objErrorException = ErrorException.builder()
                .fechaHora(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Operacion Fallida")
                .mensaje(detalleErrores)
                .ruta(webRequest.getDescription(false))
                .build();

        return ResponseEntity.badRequest().body(objErrorException);
    }


}
