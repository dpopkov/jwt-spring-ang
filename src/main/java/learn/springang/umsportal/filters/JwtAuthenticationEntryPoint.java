package learn.springang.umsportal.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.springang.umsportal.constants.SecurityConstants;
import learn.springang.umsportal.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException {
        final HttpStatus statusForbidden = HttpStatus.FORBIDDEN;
        HttpResponse httpResponse = new HttpResponse(statusForbidden.value(), statusForbidden,
                statusForbidden.getReasonPhrase().toUpperCase(), SecurityConstants.FORBIDDEN_MESSAGE);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(statusForbidden.value());
        ServletOutputStream out = response.getOutputStream();
        new ObjectMapper().writeValue(out, httpResponse);
        out.flush();
    }
}
