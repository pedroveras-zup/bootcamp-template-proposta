package br.com.zup.bootcamp.proposta.core.ports.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiErroException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String reason;

    public ApiErroException(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }
}
