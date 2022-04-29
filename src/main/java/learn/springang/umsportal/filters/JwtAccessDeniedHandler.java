package learn.springang.umsportal.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.springang.umsportal.constants.SecurityConstants;
import learn.springang.umsportal.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException exception) throws IOException {
        final HttpStatus statusUnauthorized = HttpStatus.UNAUTHORIZED;
        HttpResponse httpResponse = new HttpResponse(statusUnauthorized.value(), statusUnauthorized,
                statusUnauthorized.getReasonPhrase().toUpperCase(), SecurityConstants.ACCESS_DENIED);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(statusUnauthorized.value());
        ServletOutputStream out = response.getOutputStream();
        new ObjectMapper().writeValue(out, httpResponse);
        out.flush();
    }
}
