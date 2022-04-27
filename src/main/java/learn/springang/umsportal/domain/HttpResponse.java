package learn.springang.umsportal.domain;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class HttpResponse {

    private final int httpStatusCode;
    private final HttpStatus httpStatus;
    private final String reason;
    private final String message;
}
