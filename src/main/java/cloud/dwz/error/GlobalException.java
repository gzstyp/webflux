package cloud.dwz.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GlobalException extends ResponseStatusException {
    
    public GlobalException(final HttpStatus status,final String message) {
        super(status, message);
    }
    
    public GlobalException(final HttpStatus status,final String message,final Throwable e) {
        super(status, message, e);
    }
}