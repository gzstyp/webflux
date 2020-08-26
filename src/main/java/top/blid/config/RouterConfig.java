package top.blid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import top.blid.handler.CityHandler;
import top.blid.handler.TimeHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 简单的路由配置
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-11 0:54
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Configuration
public class RouterConfig{

    @Autowired
    private TimeHandler timeHandler;

    // http://127.0.0.1:8280/time
    @Bean
    public RouterFunction<ServerResponse> timeRouter(){
        // 表示get的请求方式且url为time时走的是timeHandler.getTime(request),即用什么方法去处理它!!!
        return route(GET("/time"),request -> timeHandler.getTime(request))
                // 表示get的请求方式且url为date时走的是timeHandler.getDate(request),即用什么方法去处理它!!!
                .andRoute(GET("/date"),request -> timeHandler.getDate(request));
    }

    @Bean
    public RouterFunction<ServerResponse> routeCity(final CityHandler cityHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), cityHandler::helloCity);
    }

}