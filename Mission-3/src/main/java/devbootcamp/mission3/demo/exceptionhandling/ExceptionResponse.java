package devbootcamp.mission3.demo.exceptionhandling;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}
