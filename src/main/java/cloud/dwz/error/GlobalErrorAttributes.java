package cloud.dwz.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {
    
    @Override
    public Map<String,Object> getErrorAttributes(final ServerRequest request,final ErrorAttributeOptions options) {
        final Map<String, Object> map = super.getErrorAttributes(request,options);
        if (getError(request) instanceof GlobalException) {
            final GlobalException ex = (GlobalException) getError(request);
            map.put("exception", ex.getClass().getSimpleName());
            map.put("message", ex.getMessage());
            map.put("status", ex.getStatus().value());
            map.put("error", ex.getStatus().getReasonPhrase());
            return map;
        }
        map.put("exception", "SystemException");
        map.put("message", "System Error , Check logs!");
        map.put("status",500);
        map.put("error", "系统出现错误");
        return map;
    }
}