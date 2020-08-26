package top.blid.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2019-06-11 1:04
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Component
public class TimeHandler{

    public Mono<ServerResponse> getTime(final ServerRequest serverRequest){
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("现在是" + new SimpleDateFormat("HH:mm:ss").format(new Date())),String.class);
    }

    public Mono<ServerResponse> getDate(final ServerRequest serverRequest){
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("今天是" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())),String.class);
    }

}