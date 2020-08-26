package top.blid.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import top.blid.error.GlobalException;

import java.util.Optional;

@Component
public class CityHandler {
    
    public Mono<ServerResponse> helloCity(ServerRequest request) {
        return ServerResponse.ok().body(sayHelloCity(request), String.class);
    }

    // http://127.0.0.1:8280/hello?city=%E5%8C%97%E4%BA%AC
    private Mono<String> sayHelloCity(ServerRequest request) {
        final Optional<String> cityParamOptional = request.queryParam("city");
        if (!cityParamOptional.isPresent()) {
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "request param city is ERROR");
        }
        return Mono.just("Hello," + cityParamOptional.get());
    }
}
