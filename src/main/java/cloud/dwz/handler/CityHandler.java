package cloud.dwz.handler;

import cloud.dwz.error.GlobalException;
import cloud.dwz.tool.ToolClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
public class CityHandler {
    
    public Mono<ServerResponse> helloCity(final ServerRequest request){
        return responseJson(sayHelloCity(request));
    }

    // http://127.0.0.1:8280/hello?city=beijing
    private Mono<String> sayHelloCity(final ServerRequest request) {
        final Optional<String> cityParamOptional = request.queryParam("city");
        if (!cityParamOptional.isPresent()) {
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR,"request param city is ERROR");
        }
        final String json = ToolClient.json("Hello," + cityParamOptional.get());
        return Mono.just(json);
    }

    protected Mono<ServerResponse> responseJson(final Mono<String> json){
        return ServerResponse.ok().contentType(new MediaType("text","html",StandardCharsets.UTF_8)).body(json,String.class);
    }
}
